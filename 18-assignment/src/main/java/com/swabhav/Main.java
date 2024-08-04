package com.swabhav;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter board size in integer: ");
		int boardSize = scanner.nextInt();
		TicTacToeFacade tictactoe = new TicTacToeFacade(boardSize);
		tictactoe.startGame();
		} catch(Exception ex) {
			System.out.println("Wrong input");
		}
	}
}
