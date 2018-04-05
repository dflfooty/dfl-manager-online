package net.dflmngr.model.entities.keys;

import java.io.Serializable;

public class DflSelectedPlayerPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int round;
	private int playerId;
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public String toString() {
		return "DflSelectedTeamPK [round=" + round + ", playerId=" + playerId + "]";
	}
}
