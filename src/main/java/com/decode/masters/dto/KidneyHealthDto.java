package com.decode.masters.dto;

import java.util.Date;
import java.util.List;

public class KidneyHealthDto {
	private int id;
	private List<String> suggestedInterventionForKidney;
	private String suggestedKidneyMonitoring;
	private String sugar;
	private String protien;
	private String microAlbumin;
	private String bloodUrea;
	private String serumCreatinine;
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
	
	public List<String> getSuggestedInterventionForKidney() {
		return suggestedInterventionForKidney;
	}
	public void setSuggestedInterventionForKidney(List<String> suggestedInterventionForKidney) {
		this.suggestedInterventionForKidney = suggestedInterventionForKidney;
	}
	public String getSuggestedKidneyMonitoring() {
		return suggestedKidneyMonitoring;
	}
	public void setSuggestedKidneyMonitoring(String suggestedKidneyMonitoring) {
		this.suggestedKidneyMonitoring = suggestedKidneyMonitoring;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	public String getProtien() {
		return protien;
	}
	public void setProtien(String protien) {
		this.protien = protien;
	}
	public String getMicroAlbumin() {
		return microAlbumin;
	}
	public void setMicroAlbumin(String microAlbumin) {
		this.microAlbumin = microAlbumin;
	}
	public String getBloodUrea() {
		return bloodUrea;
	}
	public void setBloodUrea(String bloodUrea) {
		this.bloodUrea = bloodUrea;
	}
	public String getSerumCreatinine() {
		return serumCreatinine;
	}
	public void setSerumCreatinine(String serumCreatinine) {
		this.serumCreatinine = serumCreatinine;
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
	@Override
	public String toString() {
		return "KidneyHealthDto [id=" + id + ", suggestedInterventionForKidney=" + suggestedInterventionForKidney
				+ ", suggestedKidneyMonitoring=" + suggestedKidneyMonitoring + ", sugar=" + sugar + ", protien="
				+ protien + ", microAlbumin=" + microAlbumin + ", bloodUrea=" + bloodUrea + ", serumCreatinine="
				+ serumCreatinine + ", createduser=" + createduser + ", createdDate=" + createdDate
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedUser=" + lastUpdatedUser + "]";
	}
	
}
