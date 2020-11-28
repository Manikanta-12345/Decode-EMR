package com.decode.masters.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DiseaseSeverityAndControlStatusDto {
	private int id;
	private String hbA1c;
	private String bloodSugarLevels;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String> suggestedInterventionForDisease;
	private String suggestedHba1cMonitoring;
	private String suggestedPlasma;
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
	public String getHbA1c() {
		return hbA1c;
	}
	public void setHbA1c(String hbA1c) {
		this.hbA1c = hbA1c;
	}
	public String getBloodSugarLevels() {
		return bloodSugarLevels;
	}
	public void setBloodSugarLevels(String bloodSugarLevels) {
		this.bloodSugarLevels = bloodSugarLevels;
	}
	
	public List<String> getSuggestedInterventionForDisease() {
		return suggestedInterventionForDisease;
	}
	public void setSuggestedInterventionForDisease(List<String> suggestedInterventionForDisease) {
		this.suggestedInterventionForDisease = suggestedInterventionForDisease;
	}
	public String getSuggestedHba1cMonitoring() {
		return suggestedHba1cMonitoring;
	}
	public void setSuggestedHba1cMonitoring(String suggestedHba1cMonitoring) {
		this.suggestedHba1cMonitoring = suggestedHba1cMonitoring;
	}
	public String getSuggestedPlasma() {
		return suggestedPlasma;
	}
	public void setSuggestedPlasma(String suggestedPlasma) {
		this.suggestedPlasma = suggestedPlasma;
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
