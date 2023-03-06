package net.dflmngr.model.entities;

import java.util.Comparator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import net.dflmngr.model.entities.keys.DflPlayerScoresPK;

@Entity
@Table(name="dfl_player_scores")
@IdClass(DflPlayerScoresPK.class)
public class DflPlayerScores implements Comparator<DflPlayerScores>, Comparable<DflPlayerScores> {
	
	@Id
	@Column(name="player_id")
	private int playerId;
	
	@Id
	private int round;
	
	@Column(name="afl_player_id")
	private String aflPlayerId;
	
	@Column(name="team_code")
	private String teamCode;
	
	@Column(name="team_player_id")
	private int teamPlayerId;
	private int score;
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getAflPlayerId() {
		return aflPlayerId;
	}
	public void setAflPlayerId(String aflPlayerId) {
		this.aflPlayerId = aflPlayerId;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public int getTeamPlayerId() {
		return teamPlayerId;
	}
	public void setTeamPlayerId(int teamPlayerId) {
		this.teamPlayerId = teamPlayerId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "DflPlayerScores [playerId=" + playerId + ", round=" + round + ", aflPlayerId=" + aflPlayerId
				+ ", teamCode=" + teamCode + ", teamPlayerId=" + teamPlayerId + ", score=" + score + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aflPlayerId == null) ? 0 : aflPlayerId.hashCode());
		result = prime * result + playerId;
		result = prime * result + round;
		result = prime * result + score;
		result = prime * result + ((teamCode == null) ? 0 : teamCode.hashCode());
		result = prime * result + teamPlayerId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DflPlayerScores other = (DflPlayerScores) obj;
		if (aflPlayerId == null) {
			if (other.aflPlayerId != null)
				return false;
		} else if (!aflPlayerId.equals(other.aflPlayerId))
			return false;
		if (playerId != other.playerId)
			return false;
		if (round != other.round)
			return false;
		if (score != other.score)
			return false;
		if (teamCode == null) {
			if (other.teamCode != null)
				return false;
		} else if (!teamCode.equals(other.teamCode))
			return false;
		if (teamPlayerId != other.teamPlayerId)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(DflPlayerScores o) {
		int equal = 0;
		if(this.score > o.score) {
			equal = 1;
		} else if(this.score < o.score) {
			equal = -1;
		}
		return equal;
	}
	
	@Override
	public int compare(DflPlayerScores o1, DflPlayerScores o2) {
		int equal = 0;
		if(o1.score > o2.score) {
			equal = 1;
		} else if(o1.score < o2.score) {
			equal = -1;
		}
		return equal;
	}
}
