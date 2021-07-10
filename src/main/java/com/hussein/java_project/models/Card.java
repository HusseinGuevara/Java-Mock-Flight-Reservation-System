package com.hussein.java_project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cards")
public class Card {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="First Name is required!")
	private String firstName;
	
	@NotEmpty(message="Last Name is required!")
	private String lastName;
	
	@NotNull
	private Long cardNumber;
	
	@NotEmpty(message="Expiration date is required!")
	private String expirationDate;
	
	@NotNull
	private Integer cvvNumber;
	
	@NotEmpty(message="Address is required!")
	private String streetAddress;
	
	@NotEmpty(message="City is required!")
	private String cityName;
	
	@NotEmpty(message="State is required!")
	private String stateName;
	
	@NotNull
	private Integer zipcode;
	
	// One to One
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cardUser_id")
    private User cardUser;
	
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
	
	// Constructers
	public Card() {
	}
	
	public Card(String firstName, String lastName, Long cardNumber, String expirationDate, Integer cvvNumber, String streetAddress, String cityName, String stateName, Integer zipcode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.cityName = cityName;
		this.stateName = stateName;
		this.streetAddress = streetAddress;
		this.expirationDate = expirationDate;
		this.cvvNumber = cvvNumber;
		this.zipcode = zipcode;
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(Integer cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public User getCardUser() {
		return cardUser;
	}

	public void setCardUser(User cardUser) {
		this.cardUser = cardUser;
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
	
}
