package com.swabhav.main;

import java.util.Random;
import java.util.Scanner;

public class PigGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int totalScore = 0;
		int turnScore = 0;
		int turnCount = 1;
		
		System.out.println("Let's Play PIG!");
		
		while(totalScore < 20) {
			turnScore = 0;
			boolean turnOverFlag = false;
			
			System.out.println("\nTURN " + turnCount + "\n");
			
			while(!turnOverFlag) {
				System.out.println("Roll or hold ? (r/h): ");
				char choice = scanner.next().toLowerCase().charAt(0);
				
				if(choice == 'r') {
					int die = random.nextInt(6) + 1;
					System.out.println("Die: " + die);
					
					if(die == 1) {
						System.out.println("Score turns to zero");
						turnOverFlag = true;
						turnScore = 0;
					} else {
						turnScore += die;
						if(turnScore > 20) {
							totalScore += turnScore;
							System.out.println("Score for turn " + turnScore);
							System.out.println("Total score " + totalScore);
							turnOverFlag = true;
						}
					}
				} else if(choice == 'h') {
					totalScore += turnScore;
					System.out.println("Score for turn " + turnScore);
					System.out.println("Total score " + totalScore);
					turnOverFlag = true;
				} else {
					System.out.println("Invalid input");
				}
			}
			turnCount++;
		}
		System.out.println("You have finished in " + (turnCount - 1) + " turns!");
		System.out.println("Game Over");
		scanner.close();
	}

}