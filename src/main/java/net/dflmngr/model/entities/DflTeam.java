package net.dflmngr.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dfl_team")
public class DflTeam {
	
	@Id
	@Column(name = "team_code")
	private String teamCode;
	private String name;
	
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "coach_name")
	private String coachName;
	
	@Column(name = "home_ground")
	private String homeGround;
	
	private String colours;
	
	@Column(name = "coach_email")
	private String coachEmail;
	
	public DflTeam() {}
	
	public DflTeam(String teamCode, String name, String shortName, String coachName, String homeGround, String colours,
			String coachEmail) {
		this.teamCode = teamCode;
		this.name = name;
		this.shortName = shortName;
		this.coachName = coachName;
		this.homeGround = homeGround;
		this.colours = colours;
		this.coachEmail = coachEmail;
	}
	
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public String getHomeGround() {
		return homeGround;
	}
	public void setHomeGround(String homeGround) {
		this.homeGround = homeGround;
	}
	public String getColours() {
		return colours;
	}
	public void setColours(String colours) {
		this.colours = colours;
	}
	public String getCoachEmail() {
		return coachEmail;
	}
	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	
	@Override
	public String toString() {
		return "DflTeam [teamCode=" + teamCode + ", name=" + name + ", shortName=" + shortName + ", coachName="
				+ coachName + ", homeGround=" + homeGround + ", colours=" + colours + ", coachEmail=" + coachEmail
				+ "]";
	}
}
