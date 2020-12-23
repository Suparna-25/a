package com.cg.timecardapi.service;

import java.util.List;

import com.cg.timecardapi.dto.AttendanceDto;
import com.cg.timecardapi.entity.AttendanceDetail;

/**
 * This Interface holds the structure for AttendanceDetailsService class
 * @author Suparna Arya
 *
 */

public interface IAttendanceDetailService {
	/**
	 * This method is used to add attendance details
	 * @param attendance
	 * @return AttendanceDetail object
	 */
	public AttendanceDetail addAttendanceDetail(AttendanceDto attendance);
    /**
     * This method is used to update AttendanceDetails status from pending to approve/reject using attendance id
     * @param attendance
     * @param status
     * @return AttendanceDetail object
     */
	public AttendanceDetail updateAttendanceStatus(String attendanceId,String updateType);
	/**
	 * This method will show attendance details for the provided attendanceId
	 * @param attendanceId
	 * @return AttendanceDetail object
	 */
    public AttendanceDetail viewAttendanceByAttendanceId(String attendanceId);
    /**
	 * This method will show all attendance details 
	 * @return AttendanceDetail object
	 */
	 public List<AttendanceDto> viewAttendances();
    
    
}