package com.decode.masters.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HeartHealthDto {
	private int id;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String> suggestedInterventionForheart;
	private String suggestedCholestrolMonitoring;
	private String suggestePressureMonitoring;

	private String bloodPressure;
	private String height;
	private String weight;
	private String bmi;
	private String totalCholestrol;
	private String triglycerides;
	private String ldlCholestrol;
	private String vldlCholestrol;
	private String hdlCholestrol;
	private String hdlRatio;

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
	
	public String getSuggestedCholestrolMonitoring() {
		return suggestedCholestrolMonitoring;
	}
	public void setSuggestedCholestrolMonitoring(String suggestedCholestrolMonitoring) {
		this.suggestedCholestrolMonitoring = suggestedCholestrolMonitoring;
	}
	public String getSuggestePressureMonitoring() {
		return suggestePressureMonitoring;
	}
	public void setSuggestePressureMonitoring(String suggestePressureMonitoring) {
		this.suggestePressureMonitoring = suggestePressureMonitoring;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getTotalCholestrol() {
		return totalCholestrol;
	}
	public void setTotalCholestrol(String totalCholestrol) {
		this.totalCholestrol = totalCholestrol;
	}
	public String getTriglycerides() {
		return triglycerides;
	}
	public void setTriglycerides(String triglycerides) {
		this.triglycerides = triglycerides;
	}
	public String getLdlCholestrol() {
		return ldlCholestrol;
	}
	public void setLdlCholestrol(String ldlCholestrol) {
		this.ldlCholestrol = ldlCholestrol;
	}
	public String getVldlCholestrol() {
		return vldlCholestrol;
	}
	public void setVldlCholestrol(String vldlCholestrol) {
		this.vldlCholestrol = vldlCholestrol;
	}
	public String getHdlCholestrol() {
		return hdlCholestrol;
	}
	public void setHdlCholestrol(String hdlCholestrol) {
		this.hdlCholestrol = hdlCholestrol;
	}
	public String getHdlRatio() {
		return hdlRatio;
	}
	public void setHdlRatio(String hdlRatio) {
		this.hdlRatio = hdlRatio;
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
		return "HeartHealthDto [id=" + id + ", suggestedInterventionForheart=" + suggestedInterventionForheart
				+ ", suggestedCholestrolMonitoring=" + suggestedCholestrolMonitoring + ", suggestePressureMonitoring="
				+ suggestePressureMonitoring + ", bloodPressure=" + bloodPressure + ", height=" + height + ", weight="
				+ weight + ", bmi=" + bmi + ", totalCholestrol=" + totalCholestrol + ", triglycerides=" + triglycerides
				+ ", ldlCholestrol=" + ldlCholestrol + ", vldlCholestrol=" + vldlCholestrol + ", hdlCholestrol="
				+ hdlCholestrol + ", hdlRatio=" + hdlRatio + ", createduser=" + createduser + ", createdDate="
				+ createdDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedUser=" + lastUpdatedUser + "]";
	}
}
