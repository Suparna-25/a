package com.cg.timecardapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.timecardapi.dto.AttendanceDto;
import com.cg.timecardapi.entity.AttendanceDetail;
import com.cg.timecardapi.entity.Employee;
import com.cg.timecardapi.exception.AttendanceIDException;
import com.cg.timecardapi.exception.EmployeeIDException;
import com.cg.timecardapi.repository.AttendanceDetailRepository;
/**
 * Attendance Detail Service Interface methods are implemented here.
 * @author Suparna Arya
 *
 */
@Service
public class AttendanceDetailService implements IAttendanceDetailService {

	@Autowired
	private AttendanceDetailRepository attendanceRepo;

	@Autowired
	private EmployeeService empService;

	@Override
	public AttendanceDetail addAttendanceDetail(AttendanceDto attendanceDto) {
		try {

			Employee emp = empService.viewEmployeeByEmpId(attendanceDto.getEmployeeId());
            if(emp==null)
            {
            	throw new EmployeeIDException("No employee exist with id "+attendanceDto.getEmployeeId());
            }
			AttendanceDetail attendance = new AttendanceDetail(attendanceDto.getInTime(), attendanceDto.getOutTime(),
					attendanceDto.getAttendanceDate(), attendanceDto.getReason(), attendanceDto.getTypeId(),
					attendanceDto.getStatus(), emp);

			return attendanceRepo.save(attendance);
		}catch(EmployeeIDException ex)
		{
			throw new EmployeeIDException("No employee exist with id "+attendanceDto.getEmployeeId());
		}
		catch (Exception ex) {
			throw new AttendanceIDException("attendance id  is already present");
		}

	}

	@Override
	public AttendanceDetail updateAttendanceStatus(String attendanceId, String updateType) {
		Optional<AttendanceDetail> detail = attendanceRepo.findById(Long.valueOf(attendanceId));
		if (!detail.isPresent()) {

			throw new AttendanceIDException("No attendance is present for attendance id " + attendanceId);
		}

		AttendanceDetail attendance = detail.get();
		if (attendance.getStatus().equalsIgnoreCase("APPLIED")) {
			attendance.setStatus(updateType);
		}
		return attendanceRepo.save(attendance);

	}

	@Override
	public AttendanceDetail viewAttendanceByAttendanceId(String attendanceId) {

		Optional<AttendanceDetail> detail = attendanceRepo.findById(Long.valueOf(attendanceId));
		if (!detail.isPresent()) {

			throw new AttendanceIDException("No attendance is present for attendance id " + attendanceId);
		}

		AttendanceDetail attendance = detail.get();
		return attendance;
	}
	@Override
	public List<AttendanceDto> viewAttendances() {

		List<AttendanceDetail> attendanceDetail = (List<AttendanceDetail>) attendanceRepo.findAll();

		List<AttendanceDto> dtoList = new ArrayList<>();

		for (AttendanceDetail att : attendanceDetail) {

			AttendanceDto dto = new AttendanceDto();
            dto.setId(att.getId());
			dto.setEmployeeId(att.getEmployee().getEmpId());
			dto.setAttendanceDate(att.getAttendanceDate());
			dto.setInTime(att.getInTime());
			dto.setOutTime(att.getOutTime());
			dto.setReason(att.getReason());
			dto.setTypeId(att.getTypeId());
			dto.setStatus(att.getStatus());

			dtoList.add(dto);

		}

		
		return dtoList;
		
	}

}