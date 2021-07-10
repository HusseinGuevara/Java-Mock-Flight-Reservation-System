package com.hussein.java_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hussein.java_project.models.Flight;
import com.hussein.java_project.repositories.FlightRepo;

@Service
public class FlightService {
	private final FlightRepo flightRepo;
	
	public FlightService(FlightRepo flightRepo) {
		this.flightRepo = flightRepo;
	}
	
	// Return All Fights
	public List<Flight> allFlights() {
		return (List<Flight>) flightRepo.findAll();
	}
	
	// Create Flight
	public Flight createFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	
	// Get Fligth by ID
	public Flight findFlightById(Long id) {
		Optional<Flight> optFlight = flightRepo.findById(id);
		if(optFlight.isPresent()) {
			return optFlight.get();
		} else {
			return null;
		}
	}
	
	// Update Event 
	public Flight updateFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	
	// Delete Flight
	public void deleteFlight(Long id) {
		Optional<Flight> optFlight = flightRepo.findById(id);
		if(optFlight.isPresent()) {
			flightRepo.deleteById(id);
		}
	}
}
