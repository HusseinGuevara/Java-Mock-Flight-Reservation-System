package com.hussein.java_project.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="flights")
public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	private Long flightNumber;
	
	@NotEmpty(message="Flight Name is required!")
	private String flightName;
	
	@NotEmpty(message="Departing City is required!")
	private String departingCity;
	
	@NotEmpty(message="Arrival City is required!")
	private String arrivalCity;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date flightDate;
	
	@NotNull
//	@DateTimeFormat(pattern="hh:mm a")
	private String departureTime;
	
	@NotNull
	private String flightDuration;
	
	@NotEmpty(message="Arriving Airport name is required!")
	private String arrivingAirportName;
	
	@NotEmpty(message="Departing Airport name is required!")
	private String departingAirportName;
	
	@NotNull
	private Double ticketPrice;
	
	@NotEmpty(message="Description is required!")
	private String flightDescription;
	
	// Relationships: Many to Many
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "passengers_flights", 
        joinColumns = @JoinColumn(name = "flight_id"), 
        inverseJoinColumns = @JoinColumn(name = "passenger_id"))
	private List<User> passengers;
	
	// A flight could have many booked passengers
	@OneToMany(mappedBy="bookedFlight", fetch = FetchType.LAZY)
	private List<User> bookedPassengers;
	
	// Date Created
    @Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	private Date updatedAt;
    
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	
	// Constructer
	public Flight() {
	}
	
	public Flight(Long flightNumber, String flightName, String departingCity, String arrivalCity, 
			Date flightDate, String departureTime, String flightDuration, String departingAirportName, String arrivingAirportName,
			Double ticketPrice, String flightDescription) {
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.departingCity = departingCity;
		this.arrivalCity = arrivalCity;
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.flightDuration = flightDuration;
		this.departingAirportName = departingAirportName;
		this.arrivingAirportName = arrivingAirportName;
		this.ticketPrice = ticketPrice;
		this.flightDescription = flightDescription;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepartingCity() {
		return departingCity;
	}

	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getFlightDescription() {
		return flightDescription;
	}

	public void setFlightDescription(String flightDescription) {
		this.flightDescription = flightDescription;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}

	public List<User> getBookedPassengers() {
		return bookedPassengers;
	}

	public void setBookedPassengers(List<User> bookedPassengers) {
		this.bookedPassengers = bookedPassengers;
	}

	public String getArrivingAirportName() {
		return arrivingAirportName;
	}

	public void setArrivingAirportName(String arrivingAirportName) {
		this.arrivingAirportName = arrivingAirportName;
	}

	public String getDepartingAirportName() {
		return departingAirportName;
	}

	public void setDepartingAirportName(String departingAirportName) {
		this.departingAirportName = departingAirportName;
	}
	
	
}
