package com.cg.timecardapi.exception;
/**
 * This class only retrieve Attendance Id and throws exception for it.
 * @author Suparna Arya
 *
 */
public class AttendanceIdExceptionResponse {

	private String attendanceId;
	
	public AttendanceIdExceptionResponse(String attendanceId) {
		super();
		this.attendanceId=attendanceId;
	}

	public String getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}


}