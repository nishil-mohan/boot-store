package com.ew.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ew.flight.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	@Query("SELECT f from Flight f where f.carrierCode like :#{#carrierCode==null || #carrierCode.isEmpty() ? '%' : #carrierCode}"
			+ " and f.flightNumber like :#{#flightNumber==null || #flightNumber.isEmpty() ? '%' : #flightNumber}"
			+ " and f.departureTime like :#{#departureTime==null || #departureTime.isEmpty() ? '%' : #departureTime}")
	public List<Flight> findByCarrierCodeAndFlightNumberAndDepartureTime(String carrierCode, String flightNumber,String departureTime);
		
	//public List<Flight> findByCarrierCodeAndFlightNumberAndDepartureTime(String carrierCode, String flightNumber,String departureTime);

}
