package com.codefest.safetynet.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class T_Appointment {
  
@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

	@Column(name = "scheduled_start_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime scheduledStartTime;
	
	@Column(name = "scheduled_end_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime scheduledEndTime;
	
	@Column(name = "appointment_status")
	private String appointmentStatus;
	
	private Integer delay;
	
	@Column(name = "escalation_status")
	private String escalationStatus;
	
	@Column(name = "alert_code")
	private String alertCode;
	
	@Column(name = "therapist_name")
	private String therapistName;
	
	@Column(name = "therapist_number")
	private String therapistNumber;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "risk_code")
	private String riskCode;
	
	@Column(name = "therapist_emergency")
	private String therapistEmergency;

	public Integer getId() {
		return id;
	}

	public LocalDateTime getScheduledStartTime() {
		return scheduledStartTime;
	}

	public LocalDateTime getScheduledEndTime() {
		return scheduledEndTime;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public Integer getDelay() {
		return delay;
	}

	public String getEscalationStatus() {
		return escalationStatus;
	}

	public String getAlertCode() {
		return alertCode;
	}

	public String getTherapistName() {
		return therapistName;
	}

	public String getTherapistNumber() {
		return therapistNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public String getTherapistEmergency() {
		return therapistEmergency;
	}
	
}