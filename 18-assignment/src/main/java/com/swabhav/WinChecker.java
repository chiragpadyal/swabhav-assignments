package com.swabhav;

import java.util.ArrayList;
import java.util.List;

public class WinChecker {
	public static boolean checkDiagonal(Position pos, Players player, Board board) {
		player.next();
		int boardSize = 4;
		boolean diagonal = false;
		boolean antiDiagonal = false;
		
		
		// diagonal "/"
		for( int k = 0 ; k < boardSize ; k++ ) {
			List<Position> positions = new ArrayList<Position>();
			boolean isTheLine = false;
		    for( int j = 0 ; j <= k ; j++ ) {
		        int i = k - j;
		        positions.add(new Position(i, j));
		        if(pos.getX() == i && pos.getY() == j) isTheLine = true;
		    }
		    if(isTheLine) {
//		    	positions.stream().forEach(position->System.out.print( "(" + position.getX() + " " + position.getY()  + ") " ));
		    	diagonal = checkIfAllSame(player, positions, board);
		    	break;
		    }
		}
		
		for( int k = boardSize - 2 ; k >= 0 ; k-- ) {
			List<Position> positions = new ArrayList<Position>();
			boolean isTheLine = false;
		    for( int j = 0 ; j <= k ; j++ ) {
		        int i = k - j;
		        int row =(boardSize - j - 1);
		        int col = (boardSize - i - 1);
		        positions.add(new Position(row, col));
		        if(pos.getX() == row && pos.getY() == col) isTheLine = true;
		    }
		    if(isTheLine) {
//		    	positions.stream().forEach(position->System.out.print( "(" + position.getX() + " " + position.getY()  + ") " ));
		    	diagonal = checkIfAllSame(player, positions, board);
		    	break;
		    }
		}
		
        // Anti Diagonal "\"
        for (int col = boardSize - 1; col >= 0; col--) {
            int startCol = col;
            int startRow = 0;
			List<Position> positions = new ArrayList<Position>();
			boolean isTheLine = false;
            while (startCol < boardSize && startRow < boardSize) {
                //System.out.print( "(" + startRow + " " + startCol  + ") ");
		        positions.add(new Position(startRow, startCol));
		        if(pos.getX() == startRow && pos.getY() == startCol) isTheLine = true;
                startCol++;
                startRow++;
            }
		    if(isTheLine) {
//		    	positions.stream().forEach(position->System.out.print( "(" + position.getX() + " " + position.getY()  + ") " ));
		    	antiDiagonal = checkIfAllSame(player, positions, board);
		    	break;
		    }
        }
        
        for (int row = 1; row < boardSize; row++) {
            int startRow = row;
            int startCol = 0;
			List<Position> positions = new ArrayList<Position>();
			boolean isTheLine = false;
            while (startRow < boardSize && startCol < boardSize) {
                //System.out.print( "(" + startRow + " " + startCol  + ") ");
		        positions.add(new Position(startRow, startCol));
		        if(pos.getX() == startRow && pos.getY() == startCol) isTheLine = true;
                startCol++;
                startRow++;
            }
		    if(isTheLine) {
		    	antiDiagonal = checkIfAllSame(player, positions, board);
		    	break;
		    }
		    
        }
        player.next();
		return diagonal || antiDiagonal;
	}
	
	private static boolean checkIfAllSame(Players player, List<Position> positions, Board board) {
		if(positions.size() < 3) return false;
		for (Position position : positions) {
			if(board.getValue(position) != player.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkLine(Position position, Board board) {
		// horizontal
		int value = board.getValue(position);

		boolean horizontal = compareThree(value,
				board.getValue(new Position(position.getX(), incrementInRange(position.getY(), board.getBoardSize()))),
				board.getValue(new Position(position.getX(), incrementInRange(position.getY() + 1, board.getBoardSize()))));

		// Check vertical line
		boolean vertical = compareThree(value,
				board.getValue(new Position(incrementInRange(position.getX(), board.getBoardSize()), position.getY())),
				board.getValue(new Position(incrementInRange(position.getX() + 1, board.getBoardSize()), position.getY())));

		return horizontal || vertical;
	}
	
	private static boolean compareThree(int number1, int number2, int number3) {
		if (number1 == number2 && number2 == number3)
			return true;
		return false;
	}



	private static int incrementInRange(int number, int endRange) {
		if (number < 0)
			throw new IllegalArgumentException("No Negative number");
		if (endRange <= 0)
			throw new IllegalArgumentException("endRange must be positive");
		return (number + 1) % endRange;
	}

}
