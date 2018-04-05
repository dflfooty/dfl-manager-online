package net.dflmngr.model.web;

public class Fixture {

	int round;
	int game;
	String homeTeam;
	String awayTeam;
	int homeTeamScore;
	int awayTeamScore;
	String homeTeamDisplayName;
	String awayTeamDisplayName;
	String resultsUri;
	
	public Fixture(){}
	
	public Fixture(int round, int game, String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore,
			String homeTeamDisplayName, String awayTeamDisplayName, String resultsUri) {
		this.round = round;
		this.game = game;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.homeTeamDisplayName = homeTeamDisplayName;
		this.awayTeamDisplayName = awayTeamDisplayName;
		this.resultsUri = resultsUri;
	}
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	public String getHomeTeamDisplayName() {
		return homeTeamDisplayName;
	}
	public void setHomeTeamDisplayName(String homeTeamDisplayName) {
		this.homeTeamDisplayName = homeTeamDisplayName;
	}
	public String getAwayTeamDisplayName() {
		return awayTeamDisplayName;
	}
	public void setAwayTeamDisplayName(String awayTeamDisplayName) {
		this.awayTeamDisplayName = awayTeamDisplayName;
	}
	public String getResultsUri() {
		return resultsUri;
	}
	public void setResultsUri(String resultsUri) {
		this.resultsUri = resultsUri;
	}
	
	@Override
	public String toString() {
		return "Fixture [round=" + round + ", game=" + game + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ ", homeTeamScore=" + homeTeamScore + ", awayTeamScore=" + awayTeamScore + ", resultsUri=" + resultsUri
				+ "]";
	}
}
