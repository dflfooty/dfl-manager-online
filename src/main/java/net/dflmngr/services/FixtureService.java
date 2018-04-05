package net.dflmngr.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dflmngr.model.entities.DflFixture;
import net.dflmngr.model.entities.DflTeam;
import net.dflmngr.model.entities.DflTeamScores;
import net.dflmngr.model.web.Fixture;
import net.dflmngr.repositories.DflFixtureRepository;
import net.dflmngr.repositories.DflTeamRepository;
import net.dflmngr.repositories.DflTeamScoresRepository;

@Service
public class FixtureService {
	
	private static final Logger logger = LoggerFactory.getLogger(FixtureService.class);
	
	private final DflFixtureRepository dflFixtureRepository;
	private final DflTeamScoresRepository dflTeamScoresRepository;
	private final DflTeamRepository dflTeamRepository;
	
	@Autowired
	public FixtureService(DflFixtureRepository dflFixtureRepository, DflTeamScoresRepository dflTeamScoresRepository, DflTeamRepository dflTeamRepository) {
		this.dflFixtureRepository = dflFixtureRepository;
		this.dflTeamScoresRepository = dflTeamScoresRepository;
		this.dflTeamRepository = dflTeamRepository;
	}
	
	public List<Fixture> getFixtures() {
		
		List<Fixture> fixtures = new ArrayList<>();
		
		List<DflFixture> dflFixtures = dflFixtureRepository.findAll();
		
		logger.debug("DFL Fixtures: " + dflFixtures);
				
		List<DflTeamScores> dflTeamScoresList = dflTeamScoresRepository.findAll();
		List<DflTeam> dflTeamsList = dflTeamRepository.findAll();
		
		Map<String, DflTeamScores> dflTeamScores = dflTeamScoresList.stream().collect(Collectors.toMap(
												  teamScore -> teamScore.getTeamCode() + ":" + teamScore.getRound(), teamScore -> teamScore));
		Map<String, DflTeam> dflTeams = dflTeamsList.stream().collect(Collectors.toMap(team -> team.getTeamCode(), team -> team));
		
		for(DflFixture dflFixture : dflFixtures) {
			Fixture fixture = new Fixture();
			
			fixture.setRound(dflFixture.getRound());
			fixture.setGame(dflFixture.getGame());
			fixture.setHomeTeam(dflFixture.getHomeTeam());
			fixture.setAwayTeam(dflFixture.getAwayTeam());
			
			String homeHashKey = dflFixture.getHomeTeam() + ":" + dflFixture.getRound();
			String awayHashKey = dflFixture.getAwayTeam() + ":" + dflFixture.getRound();
			
			if(dflTeamScores.containsKey(homeHashKey) && dflTeamScores.containsKey(awayHashKey)) {
			
				fixture.setHomeTeamScore(dflTeamScores.get(homeHashKey).getScore());
				fixture.setAwayTeamScore(dflTeamScores.get(awayHashKey).getScore());
				
				String resultsUri = "/results/" + dflFixture.getRound() + "/" + dflFixture.getGame();
	 			
				fixture.setResultsUri(resultsUri);
			}
			
			fixture.setHomeTeamDisplayName(dflTeams.get(fixture.getHomeTeam()).getName());
			fixture.setAwayTeamDisplayName(dflTeams.get(fixture.getAwayTeam()).getName());
			
			fixtures.add(fixture);
		}
		
		Comparator<Fixture> comparator = Comparator.comparingInt(Fixture::getRound).thenComparingInt(Fixture::getGame);
		fixtures.sort(comparator);
		
		return fixtures;
	}
}
