package com.ctsousa.stoom.controller.dto.builder;

import com.ctsousa.stoom.controller.dto.AddressDto;

public class AddressDtoBuilder {
	
	private AddressDto instance = new AddressDto();
	
	public AddressDtoBuilder withID(Long id) {
		instance.setId(id);
		return this;
	}
	
	public AddressDtoBuilder withStreetName(String streetName) {
		instance.setStreetName(streetName);
		return this;
	}
	
	public AddressDtoBuilder withNumber(String number) {
		instance.setNumber(number);
		return this;
	}
	
	public AddressDtoBuilder withComplement(String complement) {
		instance.setComplement(complement);
		return this;
	}
	
	public AddressDtoBuilder withNeighbourhood(String neighbourhood) {
		instance.setNeighbourhood(neighbourhood);
		return this;
	}
	
	public AddressDtoBuilder withCity(String city) {
		instance.setCity(city);
		return this;
	}
	
	public AddressDtoBuilder withState(String state) {
		instance.setState(state);
		return this;
	}
	
	public AddressDtoBuilder withCountry(String country) {
		instance.setCountry(country);
		return this;
	}
	
	public AddressDtoBuilder withZipCode(String zipCode) {
		instance.setZipCode(zipCode);
		return this;
	}
	
	public AddressDtoBuilder withLatitude(Double latitude) {
		instance.setLatitude(latitude);
		return this;
	}
	
	public AddressDtoBuilder withLongitute(Double longitute) {
		instance.setLongitute(longitute);
		return this;
	}
	
	public AddressDto build() {
		return instance;
	}
}
