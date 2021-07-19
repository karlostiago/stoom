package com.ctsousa.stoom.entity.builder;

import com.ctsousa.stoom.entity.Address;

public class AddressBuilder {
	
	private Address instance = new Address();
	
	public AddressBuilder withStreetName(String streetName) {
		instance.setStreetName(streetName);
		return this;
	}
	
	public AddressBuilder withNumber(String number) {
		instance.setNumber(number);
		return this;
	}
	
	public AddressBuilder withComplement(String complement) {
		instance.setComplement(complement);
		return this;
	}
	
	public AddressBuilder withNeighbourhood(String neighbourhood) {
		instance.setNeighbourhood(neighbourhood);
		return this;
	}
	
	public AddressBuilder withCity(String city) {
		instance.setCity(city);
		return this;
	}
	
	public AddressBuilder withState(String state) {
		instance.setState(state);
		return this;
	}
	
	public AddressBuilder withCountry(String country) {
		instance.setCountry(country);
		return this;
	}
	
	public AddressBuilder withZipCode(String zipCode) {
		instance.setZipCode(zipCode);
		return this;
	}
	
	public AddressBuilder withLatitude(Double latitude) {
		instance.setLatitude(latitude);
		return this;
	}
	
	public AddressBuilder withLongitute(Double longitute) {
		instance.setLongitute(longitute);
		return this;
	}
	
	public Address build() {
		return instance;
	}
}
