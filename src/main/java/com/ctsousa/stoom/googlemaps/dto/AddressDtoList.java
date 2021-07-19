package com.ctsousa.stoom.googlemaps.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressDtoList {
	
	private List<AddressDto> results;
	
	public AddressDtoList() {
		this.results = new ArrayList<>();
	}

	public List<AddressDto> getResults() {
		return results;
	}

	public void setResults(List<AddressDto> results) {
		this.results = results;
	}
}
