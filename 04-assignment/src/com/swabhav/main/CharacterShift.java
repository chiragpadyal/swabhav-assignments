package com.swabhav.main;
import java.util.Scanner;

public class CharacterShift {
	private static int loop(int val, int min, int max)
	{
	    return ((val-min) % 26) + min;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the word");
		String word = scanner.next();
		String newWord = "";
		System.out.println("Enter number to shift character by :");
		int shift = scanner.nextInt();
		
		// negative shift
		if(shift < 0) {
			shift += 26;
		}
		
		// loop characters
		for (int i = 0; i < word.length(); i++) {
			int ascii = (int) word.charAt(i);
			// add shift to ASCII
			int asciiShift = ascii + shift;
			if (ascii <= 90) {
				// lower case shift
				asciiShift = loop(asciiShift, 65, 90);
			}else {
				// upper case shift
				asciiShift = loop(asciiShift, 97, 122);
			}
			// type cast back
			char newChar = (char) (asciiShift );
			newWord += newChar;
		}
		
		System.out.println("Shifted word: "+ newWord);
		
		
		
		scanner.close();
	}
}
