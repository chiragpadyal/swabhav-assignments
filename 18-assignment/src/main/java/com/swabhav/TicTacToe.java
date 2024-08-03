package com.swabhav;

import java.util.Scanner;

public class TicTacToe {
	private Players playerData;
	private int totalTurns = 1;
	private boolean isWon= false;
	private final Board board;
	private final Scanner scanner;

	public TicTacToe() {
		board = new Board();
		scanner = new Scanner(System.in);
		playerData = new Players(PlayerTypes.X);
	}
	
	public void playGame() {
		drawBoard();
		while (totalTurns <= 9 && !isWon) {
			Position getPos = getPosition();
			Position playedPosition = playTurn(getPos);
			isWon = checkWon(playedPosition);
			drawBoard();
			totalTurns++;
		}
		if (isWon) {
			System.out.println("Player " + playerData.next().print() + " has won!");
			return;
		}
		System.out.println("It's a draw!");
	}


	private boolean checkWon(Position position) {
		return checkLine(position) || checkDiagonal(position);
	}

	private boolean compareThree(int number1, int number2, int number3) {
		if (number1 == number2 && number2 == number3)
			return true;
		return false;
	}

	private boolean checkLine(Position position) {
		// horizontal
		int value = board.getValue(position);

		boolean horizontal = compareThree(value,
				board.getValue(new Position(position.getX(), incrementInRange(position.getY(), 3))),
				board.getValue(new Position(position.getX(), incrementInRange(position.getY() + 1, 3))));

		// Check vertical line
		boolean vertical = compareThree(value,
				board.getValue(new Position(incrementInRange(position.getX(), 3), position.getY())),
				board.getValue(new Position(incrementInRange(position.getX() + 1, 3), position.getY())));

		return horizontal || vertical;
	}

	private boolean checkDiagonal(Position position) {
		int value = board.getValue(position);

		// Check first diagonal \
		boolean diagonal1 = position.getX() == position.getY()
				&& compareThree(value, board.getValue(new Position(0, 0)), board.getValue(new Position(2, 2)));

		// Check second diagonal /
		boolean diagonal2 = position.getX() + position.getY() == 2
				&& compareThree(value, board.getValue(new Position(0, 2)), board.getValue(new Position(2, 0)));

		return diagonal1 || diagonal2;
	}

	private int incrementInRange(int number, int endRange) {
		if (number < 0)
			throw new IllegalArgumentException("No Negative number");
		if (endRange <= 0)
			throw new IllegalArgumentException("endRange must be positive");
		return (number + 1) % endRange;
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
