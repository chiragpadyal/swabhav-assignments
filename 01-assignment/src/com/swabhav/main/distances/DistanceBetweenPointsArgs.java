package com.swabhav.main.distances;

public class DistanceBetweenPointsArgs {
	
	double calculateDistance(double x1,double x2,double y1,double y2){
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
	
	public static void main(String[] args) {
		double x1 = Double.parseDouble(args[0]);
		double y1 = Double.parseDouble(args[1]);
		double x2 = Double.parseDouble(args[2]);
		double y2 = Double.parseDouble(args[3]);
		
		System.out.println("Point (x1, y1) is  ("+ x1 +","+ y1 +")");
		System.out.println("Point (x2, y2) is  ("+ x2 +","+ y2 +")");
		
		DistanceBetweenPointsArgs dbp = new DistanceBetweenPointsArgs();
		double distance = dbp.calculateDistance(x1,x2,y1,y2);
		System.out.println("Distance between point is : " + distance );
	}
}
