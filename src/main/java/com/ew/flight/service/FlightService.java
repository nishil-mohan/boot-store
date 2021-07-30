package com.ew.flight.service;

import java.util.List;

import com.ew.flight.dto.FlightRequest;
import com.ew.flight.dto.FlightResponse;

public interface FlightService {
	
	public List<FlightResponse> findByCarrierCodeAndFlightNumberAndDepartureTime(FlightRequest flightRequest) ;

}
