/**
 * 
 */
package dev.gestiondutransportback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ETY9
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST) //400
public class ReservationException extends Exception{

	private static final long serialVersionUID = 8572602492922226304L;

	public ReservationException(String exception){
		super(exception);
	}
}
