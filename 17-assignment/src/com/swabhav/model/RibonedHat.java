package com.swabhav.model;

public class RibonedHat extends HatDecorater{

	public RibonedHat(IHat hat) {
		super(hat);
	}

	@Override
	public String getName() {
		return "Riboned Hat " + super.getName();
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 3000 + super.getPrice();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "This is the riboned hat" + super.getDescription();
	}
	
	

}
