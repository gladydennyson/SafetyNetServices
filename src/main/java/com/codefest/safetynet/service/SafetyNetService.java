package com.codefest.safetynet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.codefest.safetynet.domain.Alert;
import com.codefest.safetynet.domain.Person;
import com.codefest.safetynet.domain.ServiceDetails;
import com.codefest.safetynet.domain.ServiceSpecific;
import com.codefest.safetynet.entity.T_Appointment;
import com.codefest.safetynet.repository.TAppointmentRepo;

@Service
public class SafetyNetService {
	
	@Autowired
	TAppointmentRepo repo;

	public List<ServiceSpecific> getDetailsForTherapist(String date) throws ParseException {
		List<T_Appointment> appointments1 = (List<T_Appointment>) repo.findAll();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateObj = formatter.parse(date);
		LocalDateTime dateTime = dateObj.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
		List<T_Appointment> appointments = (List<T_Appointment>) repo.findByScheduledStartTimeGreaterThanEqualAndScheduledEndTimeLessThanEqual(dateTime, dateTime);
		
		return createSreviceSpecific(appointments);
    }
	
	public List<ServiceSpecific> getDetailsForAdmin(String date,
    		String therapistName) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateObj = formatter.parse(date);
		LocalDateTime dateTime = dateObj.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
		
		List<T_Appointment> appointments = (List<T_Appointment>) repo.findByScheduledStartTimeGreaterThanEqualAndScheduledEndTimeLessThanEqualAndTherapistNameEquals(dateTime, dateTime, therapistName);
	
		
        return createSreviceSpecific(appointments);
    }
	
	private List<ServiceSpecific> createSreviceSpecific(List<T_Appointment> appointments) {
		DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<ServiceSpecific> specifics = new ArrayList<ServiceSpecific>();
		for(T_Appointment appointment: appointments) {
			ServiceSpecific specific = new ServiceSpecific();
			specific.setStatus(appointment.getAppointmentStatus());
			specific.setClientName(appointment.getClientName());
			specific.setStartTime(appointment.getScheduledStartTime() != null ? appointment.getScheduledStartTime().format(CUSTOM_FORMATTER):"");
			specific.setEndTime(appointment.getScheduledEndTime() != null ? appointment.getScheduledEndTime().format(CUSTOM_FORMATTER):"");
			specific.setRiskScore(appointment.getRiskCode());
			Person therapist = new Person();
			therapist.setName(appointment.getTherapistName());
			therapist.setPhone(appointment.getTherapistNumber());
			therapist.setContact1(appointment.getTherapistEmergency());
			specific.setTherapistDetails(therapist);
			if(appointment.getAlertCode() != null && !"".equalsIgnoreCase(appointment.getAlertCode())) {
				Alert alert = new Alert();
				alert.setActionWith(appointment.getEscalationStatus());
				alert.setDelayInMins(appointment.getDelay());
				alert.setAlertCode(appointment.getAlertCode());
				if(appointment.getEscalationStatus() != null && !"".equalsIgnoreCase(appointment.getEscalationStatus())) {
					specific.setEscalatedAlerts(new ArrayList());
					specific.getEscalatedAlerts().add(alert);
				}else {
					specific.setAlerts(new ArrayList());
					specific.getAlerts().add(alert);
				}
			}
			specifics.add(specific);	
		}
		
		return specifics;
	}
	
	
}
