package com.swahav.model.interfaces;

public class MiddleEastAndAfricaRegion implements IRegion {
	private int id = 4;
	private String region = "Middle East and Africa";

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getRegion() {
		return this.region;
	}
	
}
