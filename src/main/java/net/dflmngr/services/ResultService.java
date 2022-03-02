package net.dflmngr.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dflmngr.model.entities.AflPlayer;
import net.dflmngr.model.entities.DflFixture;
import net.dflmngr.model.entities.DflPlayer;
import net.dflmngr.model.entities.DflPlayerPredictedScores;
import net.dflmngr.model.entities.DflPlayerScores;
import net.dflmngr.model.entities.DflSelectedPlayer;
import net.dflmngr.model.entities.DflTeam;
import net.dflmngr.model.entities.DflTeamPredictedScores;
import net.dflmngr.model.entities.DflTeamScores;
import net.dflmngr.model.entities.Globals;
import net.dflmngr.model.entities.RawPlayerStats;
import net.dflmngr.model.entities.keys.DflFixturePK;
import net.dflmngr.model.entities.keys.DflPlayerPredictedScoresPK;
import net.dflmngr.model.entities.keys.DflPlayerScoresPK;
import net.dflmngr.model.entities.keys.DflTeamPredictedScoresPK;
import net.dflmngr.model.entities.keys.DflTeamScoresPK;
import net.dflmngr.model.entities.keys.GlobalsPK;
import net.dflmngr.model.web.GameMenu;
import net.dflmngr.model.web.PlayerStats;
import net.dflmngr.model.web.Results;
import net.dflmngr.model.web.RoundMenu;
import net.dflmngr.model.web.SelectedPlayer;
import net.dflmngr.model.web.TeamResults;
import net.dflmngr.repositories.AflPlayerRepository;
import net.dflmngr.repositories.DflFixtureRepository;
import net.dflmngr.repositories.DflPlayerPredictedScoresRepository;
import net.dflmngr.repositories.DflPlayerRepository;
import net.dflmngr.repositories.DflPlayerScoresRepository;
import net.dflmngr.repositories.DflSelectedPlayerRepository;
import net.dflmngr.repositories.DflTeamPredictedScoresRepository;
import net.dflmngr.repositories.DflTeamRepository;
import net.dflmngr.repositories.DflTeamScoresRepository;
import net.dflmngr.repositories.GlobalsRespository;
import net.dflmngr.repositories.RawPlayerStatsRepository;

@Service
public class ResultService {

	private final DflFixtureRepository dflFixtureRepository;
	private final DflTeamRepository dflTeamRepository;
	private final DflPlayerRepository dflPlayerRepository;
	private final AflPlayerRepository aflPlayerRepository;
	private final DflSelectedPlayerRepository dflSelectedPlayerRepository;
	private final RawPlayerStatsRepository rawPlayerStatsRepository;
	private final DflPlayerScoresRepository dflPlayerScoresRepository;
	private final DflPlayerPredictedScoresRepository dflPlayerPredictedScoresRepository;
	private final DflTeamScoresRepository dflTeamScoresRepository;
	private final DflTeamPredictedScoresRepository dflTeamPredictedScoresRepository;
	private final GlobalsRespository globalsRespository;
	
	@Autowired
	public ResultService(DflFixtureRepository dflFixtureRepository, DflTeamRepository dflTeamRepository, DflPlayerRepository dflPlayerRepository, AflPlayerRepository aflPlayerRepository,
			             DflSelectedPlayerRepository dflSelectedPlayerRepository, RawPlayerStatsRepository rawPlayerStatsRepository, DflPlayerScoresRepository dflPlayerScoresRepository,
			             DflPlayerPredictedScoresRepository dflPlayerPredictedScoresRepository, DflTeamScoresRepository dflTeamScoresRepository,
			             DflTeamPredictedScoresRepository dflTeamPredictedScoresRepository, GlobalsRespository globalsRespository) {
		this.dflFixtureRepository = dflFixtureRepository;
		this.dflTeamRepository = dflTeamRepository;
		this.dflPlayerRepository = dflPlayerRepository;
		this.aflPlayerRepository = aflPlayerRepository;
		this.dflSelectedPlayerRepository = dflSelectedPlayerRepository;
		this.rawPlayerStatsRepository = rawPlayerStatsRepository;
		this.dflPlayerScoresRepository = dflPlayerScoresRepository;
		this.dflPlayerPredictedScoresRepository = dflPlayerPredictedScoresRepository;
		this.dflTeamScoresRepository = dflTeamScoresRepository;
		this.dflTeamPredictedScoresRepository = dflTeamPredictedScoresRepository;
		this.globalsRespository = globalsRespository;
	}
	
	public Results getResults(int round, int game) {
		
		Results results = new Results();
		results.setRound(round);
		results.setGame(game);
		
		DflFixture dflFixture = getFixture(round, game);
		String homeTeamCode = dflFixture.getHomeTeam();
		String awayTeamCode = dflFixture.getAwayTeam();
		
		results.setHomeTeam(getTeamResults(round, homeTeamCode));
		results.setAwayTeam(getTeamResults(round, awayTeamCode));
			
		return results;
	}
	
	public Results getCurrentResults() {
		GlobalsPK globalsPK = new GlobalsPK();
		globalsPK.setCode("currentRound");
		globalsPK.setGroupCode("dflRef");
		
		Globals currentRoundGlobal = globalsRespository.findById(globalsPK).orElseThrow();
		int currentRound = Integer.parseInt(currentRoundGlobal.getValue());
		Results results = getResults(currentRound, 1);
		
		return results;
	}
	
	public List<RoundMenu> getMenu(int round, int game) {
		
		List<RoundMenu> menu = new ArrayList<>();
		
		List<DflFixture> dflFixtures = dflFixtureRepository.findAll();
		
		Comparator<DflFixture> dflFixtureComparator = Comparator.comparingInt(DflFixture::getRound).thenComparingInt(DflFixture::getGame);
		dflFixtures.sort(dflFixtureComparator);
		
		int currentRound = 1;
		RoundMenu roundMenu = new RoundMenu();
		List<GameMenu> games = new ArrayList<>();
		Comparator<GameMenu> gamesComparator = Comparator.comparingInt(GameMenu::getGame);
		
		for(DflFixture dflFixture : dflFixtures) {
			boolean homeTeamSelected = dflSelectedPlayerRepository.selectedTeamExists(dflFixture.getHomeTeam(), dflFixture.getRound());
			boolean awayTeamSelected = dflSelectedPlayerRepository.selectedTeamExists(dflFixture.getAwayTeam(), dflFixture.getRound());
			
			if(homeTeamSelected || awayTeamSelected) {
				GameMenu gameMenu = new GameMenu();
				
				gameMenu.setGame(dflFixture.getGame());
				gameMenu.setHomeTeam(dflFixture.getHomeTeam());
				gameMenu.setAwayTeam(dflFixture.getAwayTeam());
				
				String resultsUri = "/results/" + dflFixture.getRound() + "/" + dflFixture.getGame();
				gameMenu.setResultsUri(resultsUri);
				
				gameMenu.setActive(dflFixture.getRound() == round && dflFixture.getGame() == game);
				
				if(currentRound == dflFixture.getRound()) {
					games.add(gameMenu);
				} else {
					games.sort(gamesComparator);
					
					roundMenu.setRound(currentRound);
					roundMenu.setGames(games);					
					roundMenu.setActive(currentRound == round);
					
					menu.add(roundMenu);
					
					roundMenu = new RoundMenu();
					games = new ArrayList<>();
					games.add(gameMenu);
					
					currentRound = dflFixture.getRound();				
				}
			}
		}
		
		if(!games.isEmpty()) {
			games.sort(gamesComparator);
			
			roundMenu.setRound(currentRound);
			roundMenu.setGames(games);			
			roundMenu.setActive(currentRound == round);

			menu.add(roundMenu);
		}
		
		Comparator<RoundMenu> roundsComparator = Comparator.comparingInt(RoundMenu::getRound);
		menu.sort(roundsComparator);
		
		return menu;
	}
	
	private TeamResults getTeamResults(int round, String teamCode) {
		
		TeamResults teamResults = new TeamResults();
		
		DflTeam team = dflTeamRepository.findById(teamCode).orElseThrow();
		teamResults.setTeamCode(teamCode);
		teamResults.setTeamName(team.getName());
		
		List<DflSelectedPlayer> selectedTeam = dflSelectedPlayerRepository.findByRoundAndTeamCode(round, teamCode);
				
		List<SelectedPlayer> players = new ArrayList<>();
		List<SelectedPlayer> emergencies = new ArrayList<>();
		
		int currentPredictedScore = 0;
		for(DflSelectedPlayer selectedPlayer : selectedTeam) {
			if(selectedPlayer.isScoreUsed()) {
				SelectedPlayer sp = getSelectedPlayer(selectedPlayer);
				players.add(sp);
				if(sp.isDnp()) {
					currentPredictedScore = currentPredictedScore + 0;
				} else {
					if(sp.getStats().getScore() == 0) {
						currentPredictedScore = currentPredictedScore + sp.getStats().getPredictedScore();
					} else {
						currentPredictedScore = currentPredictedScore + sp.getStats().getScore();
					}
				}
			} else {
				emergencies.add(getSelectedPlayer(selectedPlayer));
			}
		}
		
		teamResults.setPlayers(players);
		
		boolean star = false;
		boolean doubleStar = false;
		
		for(SelectedPlayer emg : emergencies) {
			if(emg.getReplacementInd() != null) {
				if(emg.getReplacementInd().equals("*")) {
					star = true;
				} else if(emg.getReplacementInd().equals("**")) {
					doubleStar = true;
				}
			}
		}
		
		if(star && !doubleStar) {
			teamResults.setEmgInd("*");
		} else if(!star && doubleStar) {
			teamResults.setEmgInd("**");
		} else if(star && doubleStar) {
			teamResults.setEmgInd("*/**");
		}
		
		teamResults.setEmergencies(emergencies);
		
		DflTeamScoresPK dflTeamScoresPK = new DflTeamScoresPK();
		dflTeamScoresPK.setRound(round);
		dflTeamScoresPK.setTeamCode(teamCode);
		DflTeamScores dflTeamScore = dflTeamScoresRepository.findById(dflTeamScoresPK).orElseThrow();
		
		DflTeamPredictedScoresPK dflTeamPredictedScoresPK = new DflTeamPredictedScoresPK();
		dflTeamPredictedScoresPK.setRound(round);
		dflTeamPredictedScoresPK.setTeamCode(teamCode);
		DflTeamPredictedScores dflTeamPredictedScore = dflTeamPredictedScoresRepository.findById(dflTeamPredictedScoresPK).orElseThrow();
		
		if(dflTeamScore != null) {
			teamResults.setScore(dflTeamScore.getScore());
		} else {
			teamResults.setScore(0);
		}
		
		teamResults.setCurrentPredictedScore(currentPredictedScore);
		teamResults.setPredictedScore(dflTeamPredictedScore.getPredictedScore());
		
		int trend = 0;
		if(currentPredictedScore == dflTeamPredictedScore.getPredictedScore()) {
			trend = teamResults.getScore() - dflTeamPredictedScore.getPredictedScore();
		} else {
			trend = currentPredictedScore - dflTeamPredictedScore.getPredictedScore();
		}
		teamResults.setTrend(trend);
		
		return teamResults;
	}
	
	private SelectedPlayer getSelectedPlayer(DflSelectedPlayer selectedPlayer) {
		SelectedPlayer sp = new SelectedPlayer();
		
		sp.setPlayerId(selectedPlayer.getPlayerId());
		sp.setTeamPlayerId(selectedPlayer.getTeamPlayerId());
		
		DflPlayer player = dflPlayerRepository.findById(selectedPlayer.getPlayerId()).orElseThrow();
		
		if(player.getInitial() == null || player.getInitial().isEmpty()) {
			sp.setName(player.getFirstName() + " " + player.getLastName());
		} else {
			sp.setName(player.getFirstName() + " " + player.getInitial() + ". " + player.getLastName());
		}
		
		sp.setPosition(player.getPosition());
		sp.setHasPlayer(selectedPlayer.hasPlayed());
		sp.setScoreUsed(selectedPlayer.isScoreUsed());
		sp.setDnp(selectedPlayer.isDnp());
		sp.setReplacementInd(selectedPlayer.getReplacementInd());
		
		if(selectedPlayer.getReplacementInd() != null && selectedPlayer.getReplacementInd().equals("*")) {
			sp.setEmgSort(1);
		} else if(selectedPlayer.getReplacementInd() != null && selectedPlayer.getReplacementInd().equals("**")) {
			sp.setEmgSort(2);
		} else {
			sp.setEmgSort(selectedPlayer.isEmergency());
		}
		
		sp.setStats(getPlayerStats(selectedPlayer.getRound(), selectedPlayer.getPlayerId()));
		
		return sp;
	}
	
	private PlayerStats getPlayerStats(int round, int playerId) {
		PlayerStats playerStats = new PlayerStats();
		
		AflPlayer aflPlayer = aflPlayerRepository.findByDflPlayerId(playerId);
				
		RawPlayerStats rawPlayerStats = rawPlayerStatsRepository.findByRoundAndTeamAndJumperNo(round, aflPlayer.getTeamId(), aflPlayer.getJumperNo());
		
		if(rawPlayerStats != null) {
			playerStats.setKicks(rawPlayerStats.getKicks());
			playerStats.setHandballs(rawPlayerStats.getHandballs());
			playerStats.setDisposals(rawPlayerStats.getDisposals());
			playerStats.setMarks(rawPlayerStats.getMarks());
			playerStats.setHitouts(rawPlayerStats.getHitouts());
			playerStats.setFreesFor(rawPlayerStats.getFreesFor());
			playerStats.setFreesAgainst(rawPlayerStats.getFreesAgainst());
			playerStats.setTackles(rawPlayerStats.getTackles());
			playerStats.setGoals(rawPlayerStats.getGoals());
			playerStats.setBehinds(rawPlayerStats.getBehinds());
			playerStats.setScrapingStatus(rawPlayerStats.getScrapingStatus());
		}
		
		DflPlayerScoresPK dflPlayerScoresPK = new DflPlayerScoresPK();
		dflPlayerScoresPK.setPlayerId(playerId);
		dflPlayerScoresPK.setRound(round);
		
		DflPlayerScores dflPlayerScores = dflPlayerScoresRepository.findById(dflPlayerScoresPK).orElseThrow();
		
		DflPlayerPredictedScoresPK dflPlayerPredictedScoresPK = new DflPlayerPredictedScoresPK();
		dflPlayerPredictedScoresPK.setPlayerId(playerId);
		dflPlayerPredictedScoresPK.setRound(round);
		
		Optional<DflPlayerPredictedScores> dflPlayerPredictedScores = dflPlayerPredictedScoresRepository.findById(dflPlayerPredictedScoresPK);
		
		if(dflPlayerPredictedScores.isPresent()) {
			playerStats.setPredictedScore(dflPlayerPredictedScores.get().getPredictedScore());
		} else {
			playerStats.setPredictedScore(25);
		}
		
		int trend = 0;
		if(dflPlayerScores != null) {
			playerStats.setScore(dflPlayerScores.getScore());
			trend = dflPlayerScores.getScore() - playerStats.getPredictedScore();
		} else {
			trend = trend - playerStats.getPredictedScore();
		}
		
		playerStats.setTrend(trend);
		
		return playerStats;
	}
		
	private DflFixture getFixture(int round, int game) {
		DflFixturePK pk = new DflFixturePK();
		pk.setRound(round);
		pk.setGame(game);
		
		DflFixture fixture = dflFixtureRepository.findById(pk).orElseThrow();
		
		return fixture;
	}
	
	

}
