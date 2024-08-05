package com.swabhav;

import java.util.ArrayList;
import java.util.List;

public class WinChecker {
	
	public static boolean isDiagonal(Position pos, Players player, Board board) {
		int boardSize = 4;
		// diagonal "/"
		for( int k = 0 ; k < boardSize ; k++ ) {
			List<Boolean> positions = new ArrayList<Boolean>();
			boolean isTheLine = false;
		    for( int j = 0 ; j <= k ; j++ ) {
		        int i = k - j;
		        positions.add(board.getValue(new Position(i, j)) != player.getValue());
		        if(pos.getX() == i && pos.getY() == j) isTheLine = true;
		    }
		    if(isTheLine) {
		    	System.out.println("" + positions);
		    	 if (positions.size() > board.getBoardSize() - 1)return positions.contains(false);
		    }
		}
		
		
		for( int k = boardSize - 2 ; k >= 0 ; k-- ) {
			List<Boolean> positions = new ArrayList<Boolean>();
			boolean isTheLine = false;
		    for( int j = 0 ; j <= k ; j++ ) {
		        int i = k - j;
		        int row =(boardSize - j - 1);
		        int col = (boardSize - i - 1);
		        positions.add(board.getValue(new Position(row, col)) != player.getValue());
		        if(pos.getX() == row && pos.getY() == col) isTheLine = true;
		    }
		    if(isTheLine) {
		    	System.out.println("" + positions);
//		    	positions.stream().forEach(position->System.out.print( "(" + position.getX() + " " + position.getY()  + ") " ));
		    	 if (positions.size() > board.getBoardSize() - 1)return positions.contains(false);
		    }
		}
		return false;
	}
	
	public static boolean isAntiDiagonal(Position pos, Players player, Board board) {
		int boardSize = 4;
        // Anti Diagonal "\"
        for (int col = boardSize - 1; col >= 0; col--) {
            int startCol = col;
            int startRow = 0;
			List<Boolean> positions = new ArrayList<Boolean>();
			boolean isTheLine = false;
            while (startCol < boardSize && startRow < boardSize) {
                //System.out.print( "(" + startRow + " " + startCol  + ") ");
		        positions.add(board.getValue(new Position(startRow, startRow)) != player.getValue());
		        if(pos.getX() == startRow && pos.getY() == startCol) isTheLine = true;
                startCol++;
                startRow++;
            }
		    if(isTheLine) {
		    	System.out.println("" + positions);

//		    	positions.stream().forEach(position->System.out.print( "(" + position.getX() + " " + position.getY()  + ") " ));
		    	 if (positions.size() > board.getBoardSize() - 1)return positions.contains(false);
		    }
        }
        
        for (int row = 1; row < boardSize; row++) {
            int startRow = row;
            int startCol = 0;
			List<Boolean> positions = new ArrayList<Boolean>();
			boolean isTheLine = false;
            while (startRow < boardSize && startCol < boardSize) {
		        positions.add(board.getValue(new Position(startRow, startRow)) != player.getValue());
		        if(pos.getX() == startRow && pos.getY() == startCol) isTheLine = true;
                startCol++;
                startRow++;
            }
		    if(isTheLine) {
		    	System.out.println("" + positions);

		    	 if (positions.size() > board.getBoardSize() - 1)return positions.contains(false);
		    }
		    
        }
		return false;
	}
	
	public static boolean checkDiagonal(Position pos, Players player, Board board) {
		player.next();
		boolean diagonal = isDiagonal(pos, player, board);
		boolean antiDiagonal = isAntiDiagonal(pos, player, board);
        player.next();
		return diagonal || antiDiagonal;
	}
	
	private static boolean checkIfAllSame(Players player, List<Position> positions, Board board) {
		if(positions.size() < 3) return false;
		System.out.println("player value : "  + player.getValue());
		System.out.println("array: " + positions);
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
