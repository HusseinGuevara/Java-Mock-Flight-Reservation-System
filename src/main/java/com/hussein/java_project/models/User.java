package com.hussein.java_project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Username is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String userName;
    
    @NotEmpty(message="First Name is required!")
    private String firstName;
    
    @NotEmpty(message="Last Name is required!")
    private String lastName;
    
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
     
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    // Relationships: Many to Many
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "passengers_flights", 
        joinColumns = @JoinColumn(name = "passenger_id"), 
        inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<Flight> flights;
    
    // A user could only have one fligth booked
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="flight_id")
    private Flight bookedFlight;
    
    // One to One
    @OneToOne(mappedBy="cardUser", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Card card;
    
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
    
    // Contructers
    public User() {
    }
    
    public User(String userName, String firstName, String lastName, Date dob, String email, String password, String confirm) {
    	this.userName = userName;
    	this.email = email;
    	this.password = password;
    	this.confirm = confirm;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.dob = dob;
    }
    
    // User Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	// Fligths Getters and Setters
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight getBookedFlight() {
		return bookedFlight;
	}

	public void setBookedFlight(Flight bookedFlight) {
		this.bookedFlight = bookedFlight;
	}
	
	// Card Getters and Setters
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}
