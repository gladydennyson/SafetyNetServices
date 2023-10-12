package com.codefest.safetynet.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codefest.safetynet.entity.T_Appointment;

public interface TAppointmentRepo extends CrudRepository<T_Appointment, Integer> {

	List<T_Appointment> findByScheduledStartTimeGreaterThanEqualAndScheduledEndTimeLessThanEqualAndTherapistNameEquals(LocalDateTime scheduledStartTime, LocalDateTime scheduledEndTime, String therapistName);
	
	List<T_Appointment> findByScheduledStartTimeGreaterThanEqualAndScheduledEndTimeLessThanEqual(LocalDateTime scheduledStartTime, LocalDateTime scheduledEndTime);
}
