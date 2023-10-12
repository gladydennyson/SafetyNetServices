package com.codefest.safetynet.domain;

import java.util.List;
import java.util.Objects;

public class ServiceDetails {

	String dateOfRequest;
	String therapistID;
	List<ServiceSpecific> serviceSpcifics;
	
	public String getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getTherapistID() {
		return therapistID;
	}
	public void setTherapistID(String therapistID) {
		this.therapistID = therapistID;
	}
	public List<ServiceSpecific> getServiceSpcifics() {
		return serviceSpcifics;
	}
	public void setServiceSpcifics(List<ServiceSpecific> serviceSpcifics) {
		this.serviceSpcifics = serviceSpcifics;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateOfRequest, serviceSpcifics, therapistID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceDetails other = (ServiceDetails) obj;
		return Objects.equals(dateOfRequest, other.dateOfRequest)
				&& Objects.equals(serviceSpcifics, other.serviceSpcifics)
				&& Objects.equals(therapistID, other.therapistID);
	}
	@Override
	public String toString() {
		return "ServiceDetails [dateOfRequest=" + dateOfRequest + ", therapistID=" + therapistID + ", serviceSpcifics="
				+ serviceSpcifics + "]";
	}
}
