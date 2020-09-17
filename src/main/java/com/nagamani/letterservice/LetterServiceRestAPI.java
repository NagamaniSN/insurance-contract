package com.nagamani.letterservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagamani.integration.model.Contract;


//Mocks JAX-RS REST queries of LetterService
@Path(LetterServiceRestAPI.LETTER_SERVICE_URI)
public class LetterServiceRestAPI {

	private static final String UPDATE_DISPATCH_STATUS_URI = "update-dispatch-status";
	static final String LETTER_SERVICE_URI = "letter-service";
	LetterService service = new LetterServiceImpl();

	@Path(UPDATE_DISPATCH_STATUS_URI)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int dispatchLetter(Contract contract) {

		return service.dispatchLetterToCustomer(contract);
	}

}
