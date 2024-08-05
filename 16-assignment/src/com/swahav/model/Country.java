package com.swahav.model;

import com.swahav.model.interfaces.IRegion;

public class Country {
	private String countryCode;
	private String countryName;
	private IRegion region;
	
	public Country(String countryCode, String countryName, IRegion region) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.region = region;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public IRegion getRegion() {
		return region;
	}
	
	public void setRegion(IRegion region) {
		this.region = region;
	}
	
	
	
	
}
