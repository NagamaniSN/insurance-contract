package com.nagamani.letterservice;

import com.nagamani.integration.Utility;
import com.nagamani.integration.model.Contract;


//Implementation class of REST query-response of LetterService
public class LetterServiceImpl implements LetterService {

	@Override
	public int dispatchLetterToCustomer(Contract contract) {

		contract.setStatus(Utility.STATUS_SENT);
		return contract.getStatus();
	}

}
