package com.cg.timecardapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.timecardapi.entity.AttendanceDetail;
import com.cg.timecardapi.entity.Employee;
import com.cg.timecardapi.service.EmployeeService;
import com.cg.timecardapi.service.MapValidationErrorService;
@CrossOrigin
@RestController
public class EmployeeController {
	/**
	 * This java class handle all  the web requests of the Attendance Detail endpoint
	 * @author Suparna Arya
	 *
	 */
	@Autowired
	private EmployeeService empService;
	@Autowired
	private MapValidationErrorService mapValidateErrorService;

	@PostMapping("/employee/add")
	public ResponseEntity<?> addNewEmployee(@Valid @RequestBody Employee employee, BindingResult result) throws Exception {
		ResponseEntity<?> errorMap = mapValidateErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Employee newEmployee = empService.addEmployee(employee);

		return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);

	}

	@GetMapping
	@RequestMapping("/employee/{empId}")
	public ResponseEntity<?> getEmployeeByEmpId(@PathVariable String empId) {
		return new ResponseEntity<Employee>(empService.viewEmployeeByEmpId(empId), HttpStatus.OK);
	}
	@GetMapping
	@RequestMapping("/employee/all")
	public Iterable<Employee> viewAllEmployees() {
		return empService.findAllEmployees();
	}
	
	@GetMapping
	@RequestMapping("/employee/attendance/{empId}")
	public ResponseEntity<List<AttendanceDetail>> getAttendanceByEmpId(@PathVariable String empId) {

		List<AttendanceDetail> attendanceList = empService.viewAttendanceByEmpId(empId);

		return new ResponseEntity<List<AttendanceDetail>>(attendanceList, HttpStatus.OK);
	}

	
	
	@GetMapping
	@RequestMapping("/supervisior/{supervisiorId}")
	public ResponseEntity<List<Employee>> getEmployeeUnderSupervisior(@PathVariable String supervisiorId) {
		return new ResponseEntity<List<Employee>>(empService.viewEmployeesUnderSupervisior(supervisiorId),
				HttpStatus.OK);
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEmployeeByEmployeeId(@PathVariable String empId){
		empService.deleteEmployeeByEmployeeId(empId);
		return new ResponseEntity<String> ("Employee with Id : "+empId.toUpperCase()+" Deleted!",HttpStatus.OK);
	}

}