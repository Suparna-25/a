package com.cg.timecardapi.exception;
/**
 * This class only retrieve SupervisiorId and throws exception for it.
 * @author Suparna Arya
 *
 */
public class SupervisiorIdExceptionResponse {

	private String supervisiorId;

	public SupervisiorIdExceptionResponse(String supervisiorId) {
		super();
		this.supervisiorId = supervisiorId;
	}

	public String getSupervisiorId() {
		return supervisiorId;
	}

	public void setSupervisiorId(String supervisiorId) {
		this.supervisiorId = supervisiorId;
	}


}