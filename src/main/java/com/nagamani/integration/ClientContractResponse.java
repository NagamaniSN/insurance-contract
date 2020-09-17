package com.nagamani.integration;


//Response class from Integration System to Client
public class ClientContractResponse {

	private String agreementNumber;
	private String status;
	private String reponseString;

	public ClientContractResponse(String agreementNumber, String status, String reponseString) {
		super();
		this.agreementNumber = agreementNumber;
		this.status = status;
		this.reponseString = reponseString;
	}

	public String getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReponseString() {
		return reponseString;
	}

	public void setReponseString(String reponseString) {
		this.reponseString = reponseString;
	}

}
