package com.swahav.model.interfaces;

public class EuropeRegion implements IRegion {
	private int id = 1;
	private String region = "Europe";

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getRegion() {
		return this.region;
	}
	
}
