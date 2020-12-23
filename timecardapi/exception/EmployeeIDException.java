package com.cg.timecardapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
/**
 *  This is EmpId custom exception class
 * @author Suparna Arya
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeIDException() {
		super();
	}

	public EmployeeIDException(String errMsg) {
		super(errMsg);
	}
}