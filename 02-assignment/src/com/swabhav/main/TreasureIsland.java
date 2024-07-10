package com.swabhav.main;

import java.util.Scanner;



public class TreasureIsland {
	
	void gameStart(String choice, Scanner scanner) {
		System.out.println("Choose, Left or Right?");
		choice = scanner.next();
		if(choice.equalsIgnoreCase("Left")) {
			System.out.println("Choose, Wait or Swim?");
			choice = scanner.next();
			if(choice.equalsIgnoreCase("Wait")) {
				System.out.println("Choose, Red or Yellow or Blue?");
				choice = scanner.next();
				switch (choice.toLowerCase()) {
				case "red":
					System.out.println("Burned by fire.");
					System.out.println("Game Over.");
					break;
				case "blue":
					System.out.println("Eaten by beasts.");
					System.out.println("Game Over.");
					break;
				case "yellow":
					System.out.println("You Win!");
					break;
				default:
					System.out.println("Game Over.");
					break;
				}
			}else {
				System.out.println("Attacked by trout.");
				System.out.println("Game Over.");
			}
		} else {
			System.out.println("Fall int a hole");
			System.out.println("Game Over.");
			return;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Treasure Island.");
		System.out.println("Your mission is to find the treasure.");
		
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		
		TreasureIsland treasureIsland = new TreasureIsland();
		treasureIsland.gameStart(choice, scanner);
		scanner.close();

		
	}
}
