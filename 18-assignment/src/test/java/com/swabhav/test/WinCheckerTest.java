package com.swabhav.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.swabhav.Board;
import com.swabhav.PlayerTypes;
import com.swabhav.Players;
import com.swabhav.Position;
import com.swabhav.WinChecker;

class WinCheckerTest {
	private Board board;
	private Players player;

	void makeWinBoard() {
		board = new Board(4);
		board.setValue(new Position(0, 2), 1);
		board.setValue(new Position(1, 1), 1);
		board.setValue(new Position(2, 0), 1);
		board.setValue(new Position(2, 2), -1);
		board.setValue(new Position(3, 3), -1);
	}

	
	void makeNotWinBoard() {
		board = new Board(4);
		board.setValue(new Position(0, 2), 1);
		board.setValue(new Position(1, 1), 1);
		board.setValue(new Position(2, 0), -1);
		board.setValue(new Position(2, 2), -1);
		board.setValue(new Position(3, 3), -1);
	}
	
	void makeWinBoardLine() {
		board = new Board(4);
		board.setValue(new Position(0, 1), 1);
		board.setValue(new Position(0, 2), 1);
		board.setValue(new Position(0, 0), -1);
		board.setValue(new Position(0, 3), -1);
		board.setValue(new Position(3, 3), -1);
	}
	
	@Test
	void fourMatrixDiagonalTest() {
		Position currentPlacedPosition = new Position(1, 1);
		player = new Players(PlayerTypes.O);
		makeWinBoard();
		boolean isWin = WinChecker.checkDiagonal(currentPlacedPosition,player, board);
		assertEquals(true, isWin);
		makeNotWinBoard();
		boolean isNotWin = WinChecker.checkDiagonal(currentPlacedPosition, player, board );
		assertEquals(false, isNotWin);
	}
	
	@Test
	void fourMatrixLineTest() {
		Position currentPlacedPosition = new Position(1, 1);
		player = new Players(PlayerTypes.O);
		makeWinBoardLine();
		boolean isWin = WinChecker.checkLine(currentPlacedPosition, board);
		assertEquals(true, isWin);
		makeNotWinBoard();
		boolean isNotWin = WinChecker.checkLine(currentPlacedPosition, board);
		assertEquals(false, isNotWin);
	}
}
