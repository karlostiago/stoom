package com.ctsousa.stoom.assembler;

import org.springframework.stereotype.Component;

import com.ctsousa.stoom.controller.input.AddressInput;
import com.ctsousa.stoom.entity.Address;
import com.ctsousa.stoom.entity.builder.AddressBuilder;

@Component
public class AddressDisassembler {
	
	public Address toAddress(AddressInput input) {
		return new AddressBuilder()
				.withCity(input.getCity())
				.withComplement(input.getComplement())
				.withCountry(input.getCountry())
				.withLatitude(input.getLatitude())
				.withLongitute(input.getLongitute())
				.withNeighbourhood(input.getNeighbourhood())
				.withNumber(input.getNumber())
				.withState(input.getState())
				.withStreetName(input.getStreetName())
				.withZipCode(input.getZipCode())
				.build();
	}
}
