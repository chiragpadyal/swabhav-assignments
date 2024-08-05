package com.swabhav;

public class Board implements IBoard {
	private final int[][] board;
	private int boardSize;

	public int getBoardSize() {
		return boardSize;
	}

	public Board(int boardSize) {
		this.board = new int[boardSize][boardSize];
		this.boardSize = boardSize;
	}

	public int getValue(Position position) {
		return board[position.getX()][position.getY()];
	}

	public boolean setValue(Position position, Integer value) {
		if (position.getX() >= this.boardSize || position.getY() >= this.boardSize)
			return false;
		if (board[position.getX()][position.getY()] != 0)
			return false;
		board[position.getX()][position.getY()] = value;
		return true;
	}

	public String drawBoard() {
		String output = "";
		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {
				int value = this.getValue(new Position(i, j));
				output += (value == 0 ? "  " : (value == 1 ? " X" : " O"));
				if (j != this.boardSize - 1)
					output += (" | ");
			}
			;
			if (i != this.boardSize - 1)
				output += ("\n------------------------\n");
		}
		return output;
	}
	


}
