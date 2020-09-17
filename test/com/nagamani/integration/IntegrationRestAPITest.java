package com.nagamani.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.nagamani.integration.model.Customer;

public class IntegrationRestAPITest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(IntegrationRestAPI.class);
	}


	@Test
	public void givenClientRequest_whenCorrectRequest_thenResponseIsOkAndContainsContractDetails() {
		Customer customer = new Customer("Maria", 12478213L, "maria@gmail.com", "oslo", 14785203);
		
		String requestUri = IntegrationRestAPI.CREATE_NEW_AGREEMENT_URI + "?type=1&period=3";

		Response response = target(requestUri)
				.request(MediaType.APPLICATION_JSON).post(Entity.entity(customer, MediaType.APPLICATION_JSON));

		assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response.getStatus());
		assertEquals("Http Content-Type should be: ", MediaType.TEXT_PLAIN,
				response.getHeaderString(HttpHeaders.CONTENT_TYPE));

		ClientContractResponse content = response.readEntity(ClientContractResponse.class);
		assertNotNull("Content of ressponse is: ", content.getAgreementNumber());
	}

}
