package com.cg.timecardapi.service;

import java.util.List;

import com.cg.timecardapi.entity.AttendanceDetail;
import com.cg.timecardapi.entity.Employee;

/**
 * This interface is a structure for EmployeeService
 * @author Suparna Arya
 *
 */
public interface IEmployeeService {
	 /**
    * This method is used to view Employee using empId
    * @param employee
    */
	public Employee viewEmployeeByEmpId(String empId);
	/**
	 * This method add employee
	 * @param employee
	 * @return 
	 */
	public Employee addEmployee(Employee employee);
	
	/**
	 * This method is used to view Employees working under a supervisor using supervisor id
	 * @param supervisiorId
	 * @return List of Employees
	 */
	public List<Employee> viewEmployeesUnderSupervisior(String supervisiorId);
	
	/**
	 * This method is used to view AttendanceDetails using employeeId
	 * @param empId
	 * @return List of AttendanceDetails
	 */
	public List<AttendanceDetail> viewAttendanceByEmpId(String empId);
	/**
	 * This method is used to view all Employees
	 * @return List of Employees
	 */
	public Iterable<Employee> findAllEmployees();
	/**
	 * This method is used delete Employee by EmployeeId
	 */
	public void deleteEmployeeByEmployeeId(String empId);
}