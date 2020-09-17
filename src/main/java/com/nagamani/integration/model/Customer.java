package com.nagamani.integration.model;

//Dao class for Contract
//Can use lombak framework to remove setter and getter implementations
public class Customer {

	private String name;
	private Long personalNumber;
	private String emailId;
	private String address;
	private int phoneNumber;
	
	public Customer() {

	}
	
	public Customer(String name, Long personalNumber, String emailId, String address, int phoneNumber) {
		super();
		this.name = name;
		this.personalNumber = personalNumber;
		this.emailId = emailId;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
