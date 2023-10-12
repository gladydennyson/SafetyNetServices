package com.codefest.safetynet.domain;

import java.util.List;

public class ServiceSpecific {

	String status;
	List<Alert> alerts;
	List<Alert> escalatedAlerts;
	Person therapistDetails;
	String clientName;
	String startTime;
	String endTime;
	String riskScore;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Alert> getAlerts() {
		return alerts;
	}
	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}
	public List<Alert> getEscalatedAlerts() {
		return escalatedAlerts;
	}
	public void setEscalatedAlerts(List<Alert> escalatedAlerts) {
		this.escalatedAlerts = escalatedAlerts;
	}
	public Person getTherapistDetails() {
		return therapistDetails;
	}
	public void setTherapistDetails(Person therapistDetails) {
		this.therapistDetails = therapistDetails;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(String riskScore) {
		this.riskScore = riskScore;
	}
}
