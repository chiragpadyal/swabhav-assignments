package com.swabhav.main.distances;

import java.util.Scanner;

public class DistanceBetweenPoints {
	
	double calculateDistance(double x1,double x2,double y1,double y2){
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter x1 and y1: ");
		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();
		System.out.println("Enter x2 and y2: ");
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();
		
		System.out.println("Point (x1, y1) is ("+ x1 +","+ y1 +")");
		System.out.println("Point (x2, y2) is ("+ x2 +","+ y2 +")");
		
		DistanceBetweenPoints dbp = new DistanceBetweenPoints();
		double distance = dbp.calculateDistance(x1,x2,y1,y2);
		System.out.println("Distance between point is : " + distance );
		
		scanner.close();
	}
}
