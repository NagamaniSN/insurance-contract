package com.nagamani.integration;


//Utility class to handle app constants
public class Utility {

	public static final String BACKEND_SYSTEM_URI = "http://localhost:8080/insurance-contract/rest/backend";
	public static final String LETTER_SERVICE_URI = "http://localhost:8080/insurance-contract/rest/letter-service";
	public static final String CREATE_CUSTOMER_URI = "create-customer-number";
	public static final String CREATE_NEW_CONTRACT_URI = "create-new-contract";
	public static final String LETTER_DISPATCH_URI = "update-dispatch-status";
	public static final String UPDATE_CONTRACT_STATUS = "update-contract-status";
	public static final int TYPE_HEALTH = 0;
	public static final int TYPE_LIFE = 1;
	public static final int TYPE_PROPERTY = 2;
	public static final int TYPE_VEHICLE = 3;
	public static final int STATUS_CREATED = 0;
	public static final int STATUS_SENT = 1;
	public static final int STATUS_ACTIVE = 2;
	public static final int STATUS_EXPIRED = 3;
	public static final int STATUS_ERROR = 4;
	public static final int HTTP_STATUS_SUCCESS = 200;
	public static final int ONE_YEAR = 1;
	public static final int RESPONSE_ERROR = 0;
	

}
