package com.ctsousa.stoom.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ctsousa.stoom.controller.dto.AddressDto;
import com.ctsousa.stoom.controller.dto.builder.AddressDtoBuilder;
import com.ctsousa.stoom.entity.Address;

@Component
public class AddressAssembler {
	
	public AddressDto to(Address address) {
		return new AddressDtoBuilder()
				.withID(address.getId())
				.withCity(address.getCity())
				.withComplement(address.getComplement())
				.withCountry(address.getCountry())
				.withLatitude(address.getLatitude())
				.withLongitute(address.getLongitute())
				.withNeighbourhood(address.getNeighbourhood())
				.withNumber(address.getNumber())
				.withState(address.getState())
				.withStreetName(address.getStreetName())
				.withZipCode(address.getZipCode())
				.build();
	}
	
	public List<AddressDto> to(List<Address> addressList) {
		return addressList.stream()
					.map(address -> to(address))
					.collect(Collectors.toList());
	}
}
