package com.ctsousa.stoom.controller.input;

import javax.validation.constraints.NotBlank;

public class AddressInput {

	@NotBlank
	private String streetName;

	@NotBlank
	private String number;
	
	private String complement;

	@NotBlank
	private String neighbourhood;

	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@NotBlank
	private String country;

	@NotBlank
	private String zipCode;

	private Double latitude;

	private Double longitute;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitute() {
		return longitute;
	}

	public void setLongitute(Double longitute) {
		this.longitute = longitute;
	}
}
