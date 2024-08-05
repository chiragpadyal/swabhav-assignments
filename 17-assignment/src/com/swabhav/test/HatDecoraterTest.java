package com.swabhav.test;

import com.swabhav.model.GoldenHat;
import com.swabhav.model.IHat;
import com.swabhav.model.PremiumHat;
import com.swabhav.model.RibonedHat;
import com.swabhav.model.StandardHat;

public class HatDecoraterTest {

	public static void main(String[] args) {
		IHat standardHat = new StandardHat();
		standardHat = new GoldenHat(standardHat);
		System.out.println(standardHat.getName());
		System.out.println(standardHat.getPrice());
		System.out.println(standardHat.getDescription());
		
		
		IHat premiumHat = new PremiumHat();
		premiumHat = new RibonedHat(premiumHat);
		System.out.println(premiumHat.getName());
		System.out.println(premiumHat.getPrice());
		System.out.println(premiumHat.getDescription());
		

	}

}
