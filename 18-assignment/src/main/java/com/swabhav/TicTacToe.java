package com.swabhav;

import java.util.Scanner;

public class TicTacToe {
	private Players playerData;
	private int totalTurns = 1;
	private boolean isWon= false;
	private final Board board;
	private final Scanner scanner;

	public TicTacToe(int boardSize) {
		board = new Board(boardSize);
		scanner = new Scanner(System.in);
		playerData = new Players(PlayerTypes.X);
	}
	
	public void playGame() {
		drawBoard();
		while (totalTurns <= Math.pow(board.getBoardSize(), 2) && !isWon) {
			Position getPos = getPosition();
			Position playedPosition = playTurn(getPos);
			isWon = checkWon(playedPosition);
			drawBoard();
			totalTurns++;
		};
		if (isWon) {
			System.out.println("Player " + playerData.next().print() + " has won!");
			return;
		};
		System.out.println("It's a draw!");
	}


	private boolean checkWon(Position position) {
		return WinChecker.checkLine(position, board) || WinChecker.checkDiagonal(position, playerData, board);
	}


	private Position getPosition() {
		System.out.println("Player " + (playerData.print()) + ", enter your move (row[1-3]) (column[1-3]): ");
		int positionX = scanner.nextInt();
		int positionY = scanner.nextInt();
		return new Position(positionX, positionY);
	}
	
	private Position playTurn(Position userPosition) {
		if (!board.setValue(userPosition, playerData.getValue())) playTurn(userPosition);
		playerData.next();
		return userPosition;
	}

	private void drawBoard() {
		System.out.println(board.drawBoard());
	}

}
