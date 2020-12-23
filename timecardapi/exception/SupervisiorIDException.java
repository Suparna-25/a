package com.cg.timecardapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
/**
 *  This is Supervisior Id custom exception class
 * @author Suparna Arya
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SupervisiorIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SupervisiorIDException() {
		super();
	}

	public SupervisiorIDException(String errMsg) {
		super(errMsg);
	}
}