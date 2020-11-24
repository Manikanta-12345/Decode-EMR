package com.decode.masters.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;



public class NextAppointmentsDto {
	private int id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date bloodPressureDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date hbA1cMonitoring;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date neuropathyScreening;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date cholestrolMonitoring;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date kidneyFunctions;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date plasmaMonitoring;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date retinalExaminastion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String createduser;
	private Date createdDate;
	private Date lastUpdateDate;
	private String lastUpdatedUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBloodPressureDate() {
		return bloodPressureDate;
	}
	public void setBloodPressureDate(Date bloodPressureDate) {
		this.bloodPressureDate = bloodPressureDate;
	}
	public Date getHbA1cMonitoring() {
		return hbA1cMonitoring;
	}
	public void setHbA1cMonitoring(Date hbA1cMonitoring) {
		this.hbA1cMonitoring = hbA1cMonitoring;
	}
	public Date getNeuropathyScreening() {
		return neuropathyScreening;
	}
	public void setNeuropathyScreening(Date neuropathyScreening) {
		this.neuropathyScreening = neuropathyScreening;
	}
	public Date getCholestrolMonitoring() {
		return cholestrolMonitoring;
	}
	public void setCholestrolMonitoring(Date cholestrolMonitoring) {
		this.cholestrolMonitoring = cholestrolMonitoring;
	}
	public Date getKidneyFunctions() {
		return kidneyFunctions;
	}
	public void setKidneyFunctions(Date kidneyFunctions) {
		this.kidneyFunctions = kidneyFunctions;
	}
	public Date getPlasmaMonitoring() {
		return plasmaMonitoring;
	}
	public void setPlasmaMonitoring(Date plasmaMonitoring) {
		this.plasmaMonitoring = plasmaMonitoring;
	}
	public Date getRetinalExaminastion() {
		return retinalExaminastion;
	}
	public void setRetinalExaminastion(Date retinalExaminastion) {
		this.retinalExaminastion = retinalExaminastion;
	}
	public String getCreateduser() {
		return createduser;
	}
	public void setCreateduser(String createduser) {
		this.createduser = createduser;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdatedUser() {
		return lastUpdatedUser;
	}
	public void setLastUpdatedUser(String lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}
	
}
