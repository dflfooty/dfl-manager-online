package net.dflmngr.model.entities;

import java.util.Comparator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import net.dflmngr.model.entities.keys.DflLadderPK;

@Entity
@Table(name="dfl_ladder")
@IdClass(DflLadderPK.class)
public class DflLadder implements Comparator<DflLadder>, Comparable<DflLadder> {

	@Id
	private int round;
	
	@Id
	@Column(name="team_code")
	private String teamCode;
	
	private int wins;
	private int losses;
	private int draws;
	
	@Column(name="points_for")
	private int pointsFor;
	
	@Column(name="points_against")
	private int pointsAgainst;
	
	@Column(name="average_for")
	private float averageFor;
	
	@Column(name="average_against")
	private float averageAgainst;
	
	private int pts;
	private float percentage;
	private boolean live;
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getPointsFor() {
		return pointsFor;
	}
	public void setPointsFor(int pointsFor) {
		this.pointsFor = pointsFor;
	}
	public int getPointsAgainst() {
		return pointsAgainst;
	}
	public void setPointsAgainst(int pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}
	public float getAverageFor() {
		return averageFor;
	}
	public void setAverageFor(float averageFor) {
		this.averageFor = averageFor;
	}
	public float getAverageAgainst() {
		return averageAgainst;
	}
	public void setAverageAgainst(float averageAgainst) {
		this.averageAgainst = averageAgainst;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	@Override
	public String toString() {
		return "DflLadder [round=" + round + ", teamCode=" + teamCode + ", wins=" + wins + ", losses=" + losses
				+ ", draws=" + draws + ", pointsFor=" + pointsFor + ", pointsAgainst=" + pointsAgainst + ", averageFor="
				+ averageFor + ", averageAgainst=" + averageAgainst + ", pts=" + pts + ", percentage=" + percentage
				+ ", live=" + live + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + round;
		result = prime * result + ((teamCode == null) ? 0 : teamCode.hashCode());
		result = prime * result + wins;
		result = prime * result + losses;
		result = prime * result + draws;
		result = prime * result + pointsFor;
		result = prime * result + pointsAgainst;
		result = prime * result + Float.floatToIntBits(averageFor);
		result = prime * result + Float.floatToIntBits(averageAgainst);
		result = prime * result + pts;
		result = prime * result + Float.floatToIntBits(percentage);
		result = prime * result + (live ? 1231 : 1237);
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
		DflLadder other = (DflLadder) obj;
		if (round != other.round)
			return false;
		if (teamCode == null) {
			if (other.teamCode != null)
				return false;
		} else if (!teamCode.equals(other.teamCode))
			return false;
		if (wins != other.wins)
			return false;
		if (losses != other.losses)
			return false;
		if (draws != other.draws)
			return false;
		if (pointsFor != other.pointsFor)
			return false;
		if (pointsAgainst != other.pointsAgainst)
			return false;
		if (Float.floatToIntBits(averageFor) != Float.floatToIntBits(other.averageFor))
			return false;
		if (Float.floatToIntBits(averageAgainst) != Float.floatToIntBits(other.averageAgainst))
			return false;
		if (pts != other.pts)
			return false;
		if (Float.floatToIntBits(percentage) != Float.floatToIntBits(other.percentage))
			return false;
		if (live != other.live)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(DflLadder o) {
		
		int equal = 0;
		int less = -1;
		int greater = 1;
		

		int oPts = o.getPts();		
		if(this.getPts() > oPts) {
			return greater;
		}
		if(this.getPts() < oPts) {
			return less;
		}

		float oPercentage = o.getPercentage();		
		if(this.getPercentage() > oPercentage) {
			return greater;
		}
		if(this.getPercentage() < oPercentage) {
			return less;
		}
		
		int oPointsFor = o.getPointsFor();		
		if(this.getPointsFor() > oPointsFor) {
			return greater;
		}
		if(this.getPointsFor() < oPointsFor) {
			return less;
		}
		
		return equal;
	}
	
	@Override
	public int compare(DflLadder o1, DflLadder o2) {

		int equal = 0;
		int less = -1;
		int greater = 1;
		
		int o1Pts = o1.getPts();
		int o2Pts = o2.getPts();
		
		if(o1Pts > o2Pts) {
			return greater;
		}
		if(o1Pts < o2Pts) {
			return less;
		}
		
		float o1Percentage = o1.getPercentage();
		float o2Percentage = o2.getPercentage();
		
		if(o1Percentage > o2Percentage) {
			return greater;
		}
		if(o1Percentage < o2Percentage) {
			return less;
		}
		
		int o1PointsFor = o1.getPointsFor();
		int o2PointsFor = o2.getPointsFor();
		
		if(o1PointsFor > o2PointsFor) {
			return greater;
		}
		if(o1PointsFor < o2PointsFor) {
			return less;
		}
		
		return equal;
	}
}