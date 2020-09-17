
package com.nagamani.integration;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nagamani.exception.AppException;
import com.nagamani.integration.model.Contract;
import com.nagamani.integration.model.Customer;


//Handles JAX-RS REST queries of Integration System
@Path(IntegrationRestAPI.INTEGRATION_URI)
public class IntegrationRestAPI {

	static final String CREATE_NEW_AGREEMENT_URI = "/create-new-agreement";
	static final String INTEGRATION_URI = "/integration";
	private final IntegrationSystem integrationSystem = new IntegrationSystemImpl();
	private String responseMessage;
	Contract contract;

	@Path(CREATE_NEW_AGREEMENT_URI)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewContract(Customer customer, @QueryParam("type") int insuranceType,
			@QueryParam("period") int contractPeriodInYears) throws AppException {

		// validate input from customer
		validateCustomer(customer);

		// call from Integration System to Bankend System
		int customerNumber = integrationSystem.createCustomer(customer);

		if (customerNumber == 0) {
			throw new AppException("Error creating customer. Try Again!");
		}

		contract = integrationSystem.createContract(customer, customerNumber, insuranceType, contractPeriodInYears);

		if (contract == null) {
			throw new AppException("Error creating the contract. Try Again!");
		}

		int letterDispatchStatus = integrationSystem.dispatchLetter(contract);

		if (letterDispatchStatus == Utility.STATUS_ERROR) {
			if (contract.getStatus() == Utility.STATUS_CREATED) {
				// retry - backoff mechanism
			} else {
				throw new AppException("Error creating the contract. Try Again!");
			}
		}

		int status = integrationSystem.updateContractStatus(contract);

		if (status == Utility.STATUS_ERROR) {
			throw new AppException("Error creating the contract. Try Again!");
		}

		responseMessage = "Contract Created Successfully";

		ClientContractResponse response = new ClientContractResponse(contract.getContractNumber(), "ACTIVE",
				responseMessage);
		Response responseWrapper = Response.ok(response).build();
		return responseWrapper;
	}

	public void validateCustomer(Customer customer) throws AppException {

		if (customer.getName() == null || customer.getName().isEmpty())
			throw new AppException("Customer Name should not be Empty");
		if (customer.getPersonalNumber() == null) {
			throw new AppException("Personal Number should not be Empty");
		}
		if (customer.getAddress() == null || customer.getAddress().isEmpty()) {
			throw new AppException("Customer Address required. Adress should not be Empty");
		}

	}

}
