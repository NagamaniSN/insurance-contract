package com.nagamani.integration;

import javax.ws.rs.QueryParam;

import com.nagamani.integration.model.Contract;
import com.nagamani.integration.model.Customer;

public interface IntegrationSystem {

	public int createCustomer(Customer customer);

	
	public Contract createContract(Customer customer, int customerNumber, int insuranceType, int contractPeriodInYears);

	public int dispatchLetter(Contract contract);

	public int updateContractStatus(Contract contract);

}
