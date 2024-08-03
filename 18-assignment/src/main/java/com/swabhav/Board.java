package com.swabhav;

public class Board implements IBoard {
	private final int[][] board;

	public Board() {
		this.board = new int[3][3];
	}

	public int getValue(Position position) {
		return board[position.getX()][position.getY()];
	}

	public boolean setValue(Position position, Integer value) {
		if (position.getX() >= 3 || position.getY() >= 3)
			return false;
		if (board[position.getX()][position.getY()] != 0)
			return false;
		board[position.getX()][position.getY()] = value;
		return true;
	}

	public String drawBoard() {
		String output = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int value = this.getValue(new Position(i, j));
				output += (value == 0 ? "  " : (value == 1 ? " X" : " O"));
				if (j != 2)
					output += (" | ");
			}
			;
			if (i != 2)
				output += ("\n--------------\n");
		}
		return output;
	}

}
