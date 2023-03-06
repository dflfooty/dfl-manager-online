package net.dflmngr.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dfl_player")
public class DflPlayer {
	
	@Id
	@Column(name = "player_id")
	private int playerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String initial;
	private String status;
	
	@Column(name = "afl_club")
	private String aflClub;
	private String position;
	
	@Column(name = "afl_player_id")
	private String aflPlayerId;
	
	@Column(name = "is_first_year")
	private boolean isFirstYear;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAflClub() {
		return aflClub;
	}

	public void setAflClub(String aflClub) {
		this.aflClub = aflClub;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAflPlayerId() {
		return aflPlayerId;
	}

	public void setAflPlayerId(String aflPlayerId) {
		this.aflPlayerId = aflPlayerId;
	}
	public boolean isFirstYear() {
		return isFirstYear;
	}

	public void setFirstYear(boolean isFirstYear) {
		this.isFirstYear = isFirstYear;
	}

	@Override
	public String toString() {
		return "DflPlayer [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", inital="
				+ initial + ", status=" + status + ", aflClub=" + aflClub + ", position=" + position + ", aflPlayerId="
				+ aflPlayerId + ", isFirstYear=" + isFirstYear + "]";
	}
}