package com.ew.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ew.flight.dto.FlightRequest;
import com.ew.flight.dto.FlightResponse;
import com.ew.flight.exception.NoFlightFoundException;
import com.ew.flight.model.Flight;
import com.ew.flight.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightRepository flightRepository;	
	
	@Override
	public List<FlightResponse> findByCarrierCodeAndFlightNumberAndDepartureTime(FlightRequest flightRequest) {
		
		List<FlightResponse> responses = new ArrayList<FlightResponse>();
		
		List<Flight> flights = flightRepository.findByCarrierCodeAndFlightNumberAndDepartureTime(flightRequest.getCarrierCode(),
				flightRequest.getFlightNumber(),flightRequest.getDepartureTime());
		
		if(CollectionUtils.isEmpty(flights)) {
			throw new NoFlightFoundException("No such flight exists");
		}		
		
		flights.forEach(flight->{
			FlightResponse response = new FlightResponse();
			response.setCarrierCode(flight.getCarrierCode());
			response.setFlightNumber(flight.getFlightNumber());
			response.setOrigin(flight.getOrigin());
			response.setDestination(flight.getDestination());
			response.setDepartureTime(flight.getDepartureTime());
			response.setArrivalTime(flight.getArrivalTime());
			response.setStatus(flight.getStatus());
			
			responses.add(response);
		});
		
		return responses;
	}

}
