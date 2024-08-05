package com.swahav.model.interfaces;

public class AmericasRegion implements IRegion {
	private int id = 2;
	private String region = "Americas";

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getRegion() {
		return this.region;
	}
	
}
