package com.nagamani.integration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nagamani.integration.model.Contract;
import com.nagamani.integration.model.Customer;


//Implementation class of REST query-response of Integration System
public class IntegrationSystemImpl implements IntegrationSystem {

	Client client = ClientBuilder.newClient();

	@Override
	public int createCustomer(Customer customer) {

		Response response = client.target(Utility.BACKEND_SYSTEM_URI).path(Utility.CREATE_CUSTOMER_URI)
				.request(MediaType.TEXT_PLAIN).post(Entity.entity(customer, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Utility.HTTP_STATUS_SUCCESS) {
			return Utility.RESPONSE_ERROR;
		}

		return response.readEntity(Integer.class);
	}

	@Override
	public Contract createContract(Customer customer, int customerNumber, int insuranceType,
			int contractPeriodInYears) {

		Response response = client.target(Utility.BACKEND_SYSTEM_URI).path(Utility.CREATE_NEW_CONTRACT_URI)
				.queryParam("type", Utility.TYPE_HEALTH).queryParam("number", 135498714)
				.queryParam("period", Utility.ONE_YEAR).request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(customer, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Utility.HTTP_STATUS_SUCCESS) {
			return null;
		}
		return response.readEntity(Contract.class);
	}

	@Override
	public int dispatchLetter(Contract contract) {

		Response response = client.target(Utility.LETTER_SERVICE_URI).path(Utility.LETTER_DISPATCH_URI)
				.request(MediaType.TEXT_PLAIN).post(Entity.entity(contract, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Utility.HTTP_STATUS_SUCCESS) {
			return Utility.STATUS_ERROR;
		}

		return response.readEntity(Integer.class);
	}

	@Override
	public int updateContractStatus(Contract contract) {

		Response response = client.target(Utility.BACKEND_SYSTEM_URI).path(Utility.UPDATE_CONTRACT_STATUS)
				.queryParam("status", Utility.STATUS_ACTIVE).request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(contract, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Utility.HTTP_STATUS_SUCCESS) {
			return Utility.STATUS_ERROR;
		}

		return response.readEntity(Integer.class);
	}

}
