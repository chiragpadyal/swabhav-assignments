package com.swahav.model;

import java.util.ArrayList;
import java.util.List;

import com.swahav.model.interfaces.IRegion;

public class CountryList {
	private List<IRegion> regions;
	private List<Country> countrys;
	public CountryList() {
		this.regions = new ArrayList<IRegion>();
		this.countrys = new ArrayList<Country>();
	}

	public void addRegion(IRegion region) {
		regions.add(region);
	}
	
	public void addCountry(Country country) {
		countrys.add(country);
	}

	public List<IRegion> getRegions() {
		return regions;
	}

	public List<Country> getCountrys() {
		return countrys;
	}
}
