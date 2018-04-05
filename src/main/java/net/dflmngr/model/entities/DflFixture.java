package net.dflmngr.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import net.dflmngr.model.entities.keys.DflFixturePK;

@Entity
@Table(name="dfl_fixture")
@IdClass(DflFixturePK.class)
public class DflFixture {
	
	@Id
	private int round;
	
	@Id
	private int game;
	
	@Column(name="home_team")
	private String homeTeam;
	
	@Column(name="away_team")
	private String awayTeam;
	
	public DflFixture() {}
	
	public DflFixture(int round, int game, String homeTeam, String awayTeam) {
		this.round = round;
		this.game = game;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
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
	
	@Override
	public String toString() {
		return "DflFixture [round=" + round + ", game=" + game + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ "]";
	}
}