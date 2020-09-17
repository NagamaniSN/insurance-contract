package com.nagamani.integration.model;

import java.time.LocalDate;

//Dao class for Contract
public class Contract {

	private String contractNumber;
	private String customerName;
	private Long personalNumber;
	private Long customerNumber;
	private int insuranceType;  // TODO: can be made as Enum in future
	private int status; 		// TODO: can be made as Enum in future
	private LocalDate startDate;
	private LocalDate endDate;

	public Contract() {

	}

	public Contract(String contractNumber, String customerName, Long personalNumber, Long customerNumber,
			int insuranceType, int status, LocalDate startDate, LocalDate endDate) {
		this.contractNumber = contractNumber;
		this.customerName = customerName;
		this.personalNumber = personalNumber;
		this.customerNumber = customerNumber;
		this.insuranceType = insuranceType;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Contract [contractNumber=" + contractNumber + ", customerName=" + customerName + ", personalNumber="
				+ personalNumber + ", customerNumber=" + customerNumber + ", insuranceType=" + insuranceType
				+ ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public int getInsuranceType() {
		return insuranceType;
	}

	public int getStatus() {
		return status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
