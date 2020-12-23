package com.cg.timecardapi.exception;
/**
 * This class only retrieve EmpId and throws exception for it.
 * @author Suparna Arya
 *
 */
public class EmployeeIdExceptionResponse {

	private String empId;

	public EmployeeIdExceptionResponse(String empId) {
		super();
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}


}