package com.swabhav.main.timeconverter;


public class TimeConverterArgs {
	public static void main(String[] args) {		
		int minutes = Integer.parseInt(args[0]);
		int hours = minutes / 60;
		int remainingMinutes = minutes % 60;
		
		System.out.println(minutes + " minutes is " + hours + " hours and " + remainingMinutes  +" minutes ");
	}
}
