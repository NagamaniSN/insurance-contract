package com.nagamani.backend;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

import com.nagamani.integration.Utility;
import com.nagamani.integration.model.Contract;
import com.nagamani.integration.model.Customer;


//Implementation class of REST query-response of Backend System(FagSystem)
public class BackendSystemImpl implements BackendSystem {

	private Map<Integer, Customer> customerDatabase; // TODO - use DB
	private Map<String, Contract> contractDatabase; // TODO - use DB
	private Random random = new Random();

	public BackendSystemImpl(Map<Integer, Customer> customerDatabase, Map<String, Contract> contractDatabase) {
		this.customerDatabase = customerDatabase;
		this.contractDatabase = contractDatabase;
	}

	@Override
	public int generateCustomerNumber(Customer customer) {
		// TODO: check if customer already exists. If so, return existing id
		int id = random.nextInt() & Integer.MAX_VALUE;
		customerDatabase.put(id, customer);

		return id;
	}

	@Override
	public Contract generateNewContract(Customer customer, Long customerNumber, int insuranceType,
			int contractPeriodInYears) {

		// Generating random number, for test purpose.
		final String contractNumber = generateContractNumber();

		final Contract contract = new Contract(contractNumber, customer.getName(), customer.getPersonalNumber(),
				customerNumber, insuranceType, Utility.STATUS_CREATED, LocalDate.now(),
				LocalDate.now().plusYears(contractPeriodInYears));

		contractDatabase.put(contractNumber, contract);

		return contract;
	}

	public String generateContractNumber() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 90; // letter 'z'
		int targetStringLength = 10;

		return random.ints(leftLimit, rightLimit).filter(i -> (i < 58 || i > 64)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}

	@Override
	public int updateContractStatus(Contract contract, int status) {

		contract.setStatus(status);

		return contract.getStatus();
	}

}
