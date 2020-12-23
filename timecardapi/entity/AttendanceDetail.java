package com.cg.timecardapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This Java bean contains all the attendance details
 * 
 * @author Aswitha
 *
 */
@Entity
public class AttendanceDetail {

   // attendanceId is primary key for attendance detail entity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Creates auto generated values for attendanceId
	private Long id;
	
	
	@JsonFormat(pattern = "HH:mm")
	private String inTime;
	
	@JsonFormat(pattern = "HH:mm")
	private String outTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(unique=true,updatable=false)
	@NotNull(message = "Date is required")
	private Date attendanceDate;
	private String reason;
	private String typeId;
	@NotNull(message="status must be provided")
	private String status;

	// Attendance details has many to one relationship with Employees entity using
	// empId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	@JsonIgnore
	private Employee employee;

	
	// Default constructor for employee bean
	public AttendanceDetail() {
		super();
	}

	
	// Parameterized constructor for employee bean
	public AttendanceDetail(String inTime, String outTime, Date attendanceDate, String reason, String typeId,
			String status, Employee employee) {
		super();
		this.inTime = inTime;
		this.outTime = outTime;
		this.attendanceDate=attendanceDate;
		this.reason = reason;
		this.typeId = typeId;
		this.status = status;
		this.employee = employee;
	}

	// setters and getters for Attendance details to access outside this class
	

	public String getInTime() {
		return inTime;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}


	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}


	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}
	
}
