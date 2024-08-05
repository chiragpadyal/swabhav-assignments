package com.swabhav.model;

public class GoldenHat extends HatDecorater{

	public GoldenHat(IHat hat) {
		super(hat);
	}

	@Override
	public String getName() {
		return "Golden Hat of " + super.getName();
	}

	@Override
	public double getPrice() {
		return 2000 + super.getPrice();
	}

	@Override
	public String getDescription() {
		return "This is the golden hat of " + super.getDescription();
	}
	
	

}
