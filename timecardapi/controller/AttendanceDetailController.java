package com.cg.timecardapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.timecardapi.dto.AttendanceDto;
import com.cg.timecardapi.entity.AttendanceDetail;
import com.cg.timecardapi.exception.AttendanceIDException;
import com.cg.timecardapi.service.AttendanceDetailService;
import com.cg.timecardapi.service.MapValidationErrorService;



/**
 * This java class handle all  the web requests of the Attendance Detail endpoint
 * @author Suparna Arya
 *
 */
@CrossOrigin
@RestController
public class AttendanceDetailController {

	@Autowired
	private AttendanceDetailService attendanceService;

	@Autowired
	private MapValidationErrorService mapValidateErrorService;

	@GetMapping
	@RequestMapping("/attendance/{id}")
	public ResponseEntity<?> viewAttendanceById(@PathVariable String id) {
		return new ResponseEntity<AttendanceDetail>(attendanceService.viewAttendanceByAttendanceId(id), HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping("/attendance/all")
	public List<AttendanceDto> viewAttendances(){
				
		return attendanceService.viewAttendances();
	}
	
	
	@PostMapping("/attendance/add")
	public ResponseEntity<?> addNewAttendance(@Valid @RequestBody AttendanceDto attendance, BindingResult result)
			throws AttendanceIDException {
		ResponseEntity<?> errorMap = mapValidateErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		AttendanceDetail newAttendance = attendanceService.addAttendanceDetail(attendance);
		return new ResponseEntity<AttendanceDetail>(newAttendance, HttpStatus.CREATED);

	}

	@PutMapping("/attendance/update/{id}/{updateType}")
	public ResponseEntity<?> updateAttendanceByStatus(@PathVariable String id, @PathVariable String updateType)  {
		return new ResponseEntity<AttendanceDetail>(attendanceService.updateAttendanceStatus(id, updateType), HttpStatus.OK);

	}

}