package com.nagamani.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


//Handles Server Error Responses
@Provider
public class AppException extends Exception implements ExceptionMapper<AppException> {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public AppException() {
		super();
	}

	public AppException(String message) {
		errorMessage = message;
	}

	@Override
	public Response toResponse(AppException exception) {
		
		return Response.status(404).entity(exception.errorMessage).type(MediaType.TEXT_PLAIN).build();
	}

}
