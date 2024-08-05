package com.swabhav;

public class Players {
	private PlayerTypes currentTurn;
	
	public Players(PlayerTypes currentTurn) {
		this.currentTurn = currentTurn;
	}

	public int getValue() {
		switch (this.currentTurn) {
		case X:
			return 1;
		default:
			return -1;
		}
	}
	
	public Players next() {
		switch (this.currentTurn) {
		case X:
			this.currentTurn = PlayerTypes.O;
			break;
		default:
			this.currentTurn = PlayerTypes.X;
		}
		return this;
	}

	public PlayerTypes print() {
		return this.currentTurn;
	}
	
	
}
