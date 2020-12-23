package com.cg.timecardapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.timecardapi.entity.AttendanceDetail;
import com.cg.timecardapi.entity.Employee;
import com.cg.timecardapi.exception.EmployeeIDException;
import com.cg.timecardapi.exception.SupervisiorIDException;
import com.cg.timecardapi.repository.EmployeeRepository;

/**
 * This class implement all the Employee Service Interface methods
 * @author Suparna Arya
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee viewEmployeeByEmpId(String empId) {
		Employee emp = empRepo.findByEmpId(empId);
		if (emp == null) {
			throw new EmployeeIDException("No employee with such id " + empId);
		}
		return emp;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp=null;
		try {
			if (employee.getEmpId().equals(employee.getSupervisiorId())) {
				throw new SupervisiorIDException("Employee can't be its own Supervisior");
			}
					 emp= empRepo.save(employee);
						return emp;
		} catch (SupervisiorIDException e) {
			throw new SupervisiorIDException("Employee can't be its own Supervisior");
		} catch (Exception e) {
			throw new EmployeeIDException("Employee id " + employee.getEmpId() + " already available");
		}
	}
	@Override
	public List<Employee> viewEmployeesUnderSupervisior(String supervisiorId) {
		List<Employee> employee = empRepo.findEmployeesUnderSupervisior(supervisiorId);
		if (employee == null) {
			throw new SupervisiorIDException("No employee works under supervisior whose id is " + supervisiorId);
		}
		return employee;
	}
	public Iterable<Employee> findAllEmployees() {
		return empRepo.findAll();
	}
	public void deleteEmployeeByEmployeeId(String empId) {
		Employee emp = viewEmployeeByEmpId(empId);
		if (emp == null) {
		throw new EmployeeIDException("No attendance with employee id as " + empId + " exists");
	}
		empRepo.delete(emp);
	}
	@Override
	public List<AttendanceDetail> viewAttendanceByEmpId(String empId) {
		Employee emp = viewEmployeeByEmpId(empId);
			if (emp == null) {
			throw new EmployeeIDException("No attendance with employee id as " + empId + " exists");
		}
		 
		  
		  
		return emp.getAttendance();
	}
}