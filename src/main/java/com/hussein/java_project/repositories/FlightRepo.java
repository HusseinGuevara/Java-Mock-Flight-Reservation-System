package com.hussein.java_project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hussein.java_project.models.Flight;

public interface FlightRepo extends CrudRepository<Flight, Long> {

}
