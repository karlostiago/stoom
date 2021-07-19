package com.ctsousa.stoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctsousa.stoom.entity.Address;
import com.ctsousa.stoom.exception.AddressNotFoundException;
import com.ctsousa.stoom.googlemaps.GoogleMapsClient;
import com.ctsousa.stoom.googlemaps.dto.LocationDto;
import com.ctsousa.stoom.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private GoogleMapsClient googleMapsClient;
	
	@Transactional
	public Address save(Address address) {
		LocationDto locationDto = null;
		
		if(!address.hasLatitude()) {
			locationDto = googleMapsClient.geoCode(address);
			address.setLatitude(locationDto.getLat());
		}
		
		if(!address.hasLongitude()) {
			if(locationDto == null) {
				locationDto = googleMapsClient.geoCode(address);
			}
			address.setLongitute(locationDto.getLng());
		}
		
		return addressRepository.save(address);
	}
	
	public List<Address> searchAll() {
		return addressRepository.findAll();
	}
	
	@Transactional
	public void remove(Long id) {
		Address address = searchById(id);
		addressRepository.delete(address);
	}
	
	public Address searchById(Long id) {
		return addressRepository.findById(id)
				.orElseThrow(() -> new AddressNotFoundException(id));
	}
	
	public void exist(Long id) {
		searchById(id);
	}
}
