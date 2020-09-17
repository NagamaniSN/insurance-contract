package com.nagamani.backend;

import com.nagamani.integration.model.Contract;
import com.nagamani.integration.model.Customer;

public interface BackendSystem {

	public int generateCustomerNumber(Customer customer);

	public Contract generateNewContract(Customer customer, Long customerNumber, int insuranceType,
			int contractPeriodInYears);

	public int updateContractStatus(Contract contract, int status);

}
