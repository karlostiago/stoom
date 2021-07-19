package com.ctsousa.stoom.googlemaps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ctsousa.stoom.entity.Address;
import com.ctsousa.stoom.googlemaps.dto.AddressDtoList;
import com.ctsousa.stoom.googlemaps.dto.LocationDto;

@Component
public class GoogleMapsClient {
	
	private static final String QUERY_ADDRESS = "address";
	private static final String SCHEME = "https";
	private static final String HOST = "maps.googleapis.com/maps/api";
	private static final String PATH = "geocode/json";
	private static final String KEY_SECRET = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
	private static final String QUERY_KEY = "key";

	@Autowired
	private RestTemplate client;

	public LocationDto geoCode(Address address) {
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme(SCHEME)
			.host(HOST)
			.path(PATH)
			.queryParam(QUERY_ADDRESS, "dsa")
			.queryParam(QUERY_KEY, KEY_SECRET)
			.build();
		
		ResponseEntity<AddressDtoList> response = client.getForEntity(uri.toUriString(), AddressDtoList.class);
		return response.getBody().getResults().get(0).getGeometry().getLocation();
	}
}
