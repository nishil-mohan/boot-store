package com.ew.flight.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ew.flight.dto.FlightRequest;
import com.ew.flight.dto.FlightResponse;
import com.ew.flight.service.FlightService;

@RestController
public class FlightResource {	
	
	@Autowired
	FlightService flightService;
		
	@PostMapping("/flights")
	@ResponseStatus(HttpStatus.OK)
	public List<FlightResponse> getFlightStatus(@RequestHeader HttpHeaders httpHeaders, @RequestBody FlightRequest flightRequest) {
		
		List<FlightResponse> flightResponses = flightService.findByCarrierCodeAndFlightNumberAndDepartureTime(flightRequest);				
		return flightResponses;		
	}	

}
