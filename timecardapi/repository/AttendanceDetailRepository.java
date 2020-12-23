package com.cg.timecardapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.timecardapi.entity.AttendanceDetail;

/**
 * This a Attendance Details repository that performs all the crud operation on
 * employee attendance details
 * 
 * @author Aswitha
 *
 */
@Repository
public interface AttendanceDetailRepository extends CrudRepository<AttendanceDetail, Long> {

	

}