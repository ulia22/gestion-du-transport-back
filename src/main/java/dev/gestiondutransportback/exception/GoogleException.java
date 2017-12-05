package dev.gestiondutransportback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST) //400
public class GoogleException extends Exception {

	/** serialVersionUID : long */
	private static final long serialVersionUID = -8050388846586162722L;

	public GoogleException(String exception){

		super(exception);

	}
}
