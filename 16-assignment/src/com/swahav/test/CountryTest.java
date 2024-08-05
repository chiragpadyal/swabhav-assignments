package com.swahav.test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.swahav.model.Country;
import com.swahav.model.CountryList;
import com.swahav.model.interfaces.AmericasRegion;
import com.swahav.model.interfaces.AsiaRegion;
import com.swahav.model.interfaces.EuropeRegion;
import com.swahav.model.interfaces.IRegion;
import com.swahav.model.interfaces.MiddleEastAndAfricaRegion;

public class CountryTest {
	public static void main(String[] args) {
		IRegion europe = new EuropeRegion();
		IRegion americas = new AmericasRegion();
		IRegion asia = new AsiaRegion();
		IRegion mea = new MiddleEastAndAfricaRegion();

		CountryList manager = new CountryList();

		//adding regions
		manager.addRegion(europe);
		manager.addRegion(americas);
		manager.addRegion(asia);
		manager.addRegion(mea);

		//adding countries
		manager.addCountry(new Country("IT", "Italy", europe));
		manager.addCountry(new Country("JP", "Japan", asia));
		manager.addCountry(new Country("US", "United States of America", americas));
		manager.addCountry(new Country("CA", "Canada", americas));
		manager.addCountry(new Country("CN", "China", asia));
		manager.addCountry(new Country("IN", "India", asia));
		manager.addCountry(new Country("AU", "Australia", asia));
		manager.addCountry(new Country("ZW", "Zimbabwe", mea));
		manager.addCountry(new Country("SG", "Singapore", asia));
		manager.addCountry(new Country("UK", "United Kingdom", europe));
		manager.addCountry(new Country("FR", "France", europe));
		manager.addCountry(new Country("DE", "Germany", europe));
		manager.addCountry(new Country("ZM", "Zambia", mea));
		manager.addCountry(new Country("EG", "Egypt", mea));
		manager.addCountry(new Country("BR", "Brazil", americas));
		manager.addCountry(new Country("CH", "Switzerland", europe));
		manager.addCountry(new Country("NL", "Netherlands", europe));
		manager.addCountry(new Country("MX", "Mexico", americas));
		manager.addCountry(new Country("KW", "Kuwait", mea));
		manager.addCountry(new Country("IL", "Israel", mea));
		manager.addCountry(new Country("DK", "Denmark", europe));
		manager.addCountry(new Country("HK", "Hong Kong", asia));
		manager.addCountry(new Country("NG", "Nigeria", mea));
		manager.addCountry(new Country("AR", "Argentina", americas));
		manager.addCountry(new Country("BE", "Belgium", europe));
		
		// get name of country from country code
		System.out.println("Country name from country code of CN");
		Optional<Country> findCountry = manager.getCountrys()
			   .stream()
			   .filter((country) -> country.getCountryCode().equals("CN")).findFirst();
		
		if(findCountry.isPresent()) System.out.println(findCountry.get().getCountryName());
		System.out.println();
		
		// get all countries in a region by region id
		System.out.println("Country list in id of 1 that of europe");
		List<Country> countryByRegion = manager.getCountrys().stream()
				.filter((country) -> country.getRegion().getId() == europe.getId())
				.collect(Collectors.toList());
		countryByRegion.stream().forEach((country)-> System.out.println(country.getCountryName()));
		System.out.println();
		
		// region count
		Map<IRegion, Long> regionCount = manager.getCountrys().stream().collect(Collectors.groupingBy((country)->country.getRegion(), Collectors.counting()));
		regionCount.forEach((region, count) -> System.out.println(region.getRegion() + " : " + count));
	}
}
