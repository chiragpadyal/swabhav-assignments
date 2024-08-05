package com.swahav.model.interfaces;

public class AsiaRegion implements IRegion {
	private int id = 3;
	private String region = "Asia";

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getRegion() {
		return this.region;
	}
	
}
