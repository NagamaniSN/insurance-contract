
package com.nagamani.backend;

import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.nagamani.integration.model.Contract;
import com.nagamani.integration.model.Customer;


//Handles JAX-RS REST queries of Backend System(FagSystem)
@Path(BackendRestAPI.BACKEND_URI)
public class BackendRestAPI {

	static final String BACKEND_URI = "/backend";
	private static final String UPDATE_CONTRACT_STATUS_URI = "update-contract-status";
	private static final String CREATE_NEW_CONTRACT_URI = "create-new-contract";
	private static final String CREATE_CUSTOMER_NUMBER_URI = "create-customer-number";
	private static final BackendSystemImpl backendSystem; // TODO - pass through dependency injection

	static {
		backendSystem = new BackendSystemImpl(new ConcurrentHashMap<>(), new ConcurrentHashMap<>());
	}

	@Path(CREATE_CUSTOMER_NUMBER_URI)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int createCustomer(Customer customer) {

		return backendSystem.generateCustomerNumber(customer);
	}

	@Path(CREATE_NEW_CONTRACT_URI)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contract createNewContract(Customer customer, @QueryParam("number") Long customerNumber,
			@QueryParam("type") int insuranceType, @QueryParam("period") int contractPeriodInYears) {

		return backendSystem.generateNewContract(customer, customerNumber, insuranceType, contractPeriodInYears);
	}

	@Path(UPDATE_CONTRACT_STATUS_URI)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int updateContractStatus(Contract contract, @QueryParam("status") int status) {

		return backendSystem.updateContractStatus(contract, status);

	}
}
