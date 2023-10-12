package com.codefest.safetynet.domain;


public class Alert {
	String alertCode;
	Integer delayInMins;
	String actionWith;
	public String getAlertCode() {
		return alertCode;
	}
	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}
	public Integer getDelayInMins() {
		return delayInMins;
	}
	public void setDelayInMins(Integer delayInMins) {
		this.delayInMins = delayInMins;
	}
	public String getActionWith() {
		return actionWith;
	}
	public void setActionWith(String actionWith) {
		this.actionWith = actionWith;
	}
}
