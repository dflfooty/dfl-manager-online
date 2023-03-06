package net.dflmngr.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import net.dflmngr.model.entities.keys.RawPlayerStatsPK;

@Entity
@Table(name="raw_player_stats")
@IdClass(RawPlayerStatsPK.class)
public class RawPlayerStats implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int round;
	@Id
	private String name;
	@Id
	String team;
	
	@Column(name="jumper_no")
	private int jumperNo;
	
	private int kicks;
	private int handballs;
	private int disposals;
	private int marks;
	private int hitouts;
	
	@Column(name="frees_for")
	private int freesFor;
	
	@Column(name="frees_against")
	private int freesAgainst;
	
	private int tackles;
	private int goals;
	private int behinds;
	
	@Column(name="scraping_status")
	private String scrapingStatus;
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getJumperNo() {
		return jumperNo;
	}
	public void setJumperNo(int jumperNo) {
		this.jumperNo = jumperNo;
	}
	public int getKicks() {
		return kicks;
	}
	public void setKicks(int kicks) {
		this.kicks = kicks;
	}
	public int getHandballs() {
		return handballs;
	}
	public void setHandballs(int handballs) {
		this.handballs = handballs;
	}
	public int getDisposals() {
		return disposals;
	}
	public void setDisposals(int disposals) {
		this.disposals = disposals;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getHitouts() {
		return hitouts;
	}
	public void setHitouts(int hitouts) {
		this.hitouts = hitouts;
	}
	public int getFreesFor() {
		return freesFor;
	}
	public void setFreesFor(int freesFor) {
		this.freesFor = freesFor;
	}
	public int getFreesAgainst() {
		return freesAgainst;
	}
	public void setFreesAgainst(int freesAgainst) {
		this.freesAgainst = freesAgainst;
	}
	public int getTackles() {
		return tackles;
	}
	public void setTackles(int tackles) {
		this.tackles = tackles;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getBehinds() {
		return behinds;
	}
	public void setBehinds(int behinds) {
		this.behinds = behinds;
	}
	public String getScrapingStatus() {
		return scrapingStatus;
	}
	public void setScrapingStatus(String scrapingStatus) {
		this.scrapingStatus = scrapingStatus;
	}
	
	@Override
	public String toString() {
		return "RawPlayerStats [round=" + round + ", name=" + name + ", team=" + team + ", jumperNo=" + jumperNo
				+ ", kicks=" + kicks + ", handballs=" + handballs + ", disposals=" + disposals + ", marks=" + marks
				+ ", hitouts=" + hitouts + ", freesFor=" + freesFor + ", freesAgainst=" + freesAgainst + ", tackles="
				+ tackles + ", goals=" + goals + ", behinds=" + behinds + ", scrapingStatus=" + scrapingStatus + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + behinds;
		result = prime * result + disposals;
		result = prime * result + freesAgainst;
		result = prime * result + freesFor;
		result = prime * result + goals;
		result = prime * result + handballs;
		result = prime * result + hitouts;
		result = prime * result + jumperNo;
		result = prime * result + kicks;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + round;
		result = prime * result + ((scrapingStatus == null) ? 0 : scrapingStatus.hashCode());
		result = prime * result + tackles;
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		RawPlayerStats other = (RawPlayerStats) obj;
		if (behinds != other.behinds)
			return false;
		if (disposals != other.disposals)
			return false;
		if (freesAgainst != other.freesAgainst)
			return false;
		if (freesFor != other.freesFor)
			return false;
		if (goals != other.goals)
			return false;
		if (handballs != other.handballs)
			return false;
		if (hitouts != other.hitouts)
			return false;
		if (jumperNo != other.jumperNo)
			return false;
		if (kicks != other.kicks)
			return false;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (round != other.round)
			return false;
		if (scrapingStatus == null) {
			if (other.scrapingStatus != null)
				return false;
		} else if (!scrapingStatus.equals(other.scrapingStatus))
			return false;
		if (tackles != other.tackles)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}
}
