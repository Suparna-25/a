package com.cg.timecardapi.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AttendanceDto {
    private Long id;
	private String employeeId;

	private String inTime;

	private String outTime;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(unique=true,updatable=false)
	private Date attendanceDate;

	private String reason;

	private String typeId;

	private String status;

	public AttendanceDto() {

	}

	public AttendanceDto(Long id,String employeeId, String inTime, String outTime, Date attendanceDate, String reason,
			String typeId, String status) {
		super();
		this.id=id;
		this.employeeId = employeeId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.attendanceDate = attendanceDate;
		this.reason = reason;
		this.typeId = typeId;
		this.status = status;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the inTime
	 */
	public String getInTime() {
		return inTime;
	}

	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	/**
	 * @return the outTime
	 */
	public String getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime the outTime to set
	 */
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	/**
	 * @return the attendanceDate
	 */
	public Date getAttendanceDate() {
		return attendanceDate;
	}

	/**
	 * @param attendanceDate the attendanceDate to set
	 */
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
