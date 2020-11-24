package com.decode.masters.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.decode.model.Episode;

public class FamilyHistoryDto {
	private int id;
	private String relation;
	private String alcoholConsumption;
	private String habitualPattern;
	private String historyOfSmoking;
	private String emotionalStress;
	private String sleep;
	private String createduser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAlcoholConsumption() {
		return alcoholConsumption;
	}
	public void setAlcoholConsumption(String alcoholConsumption) {
		this.alcoholConsumption = alcoholConsumption;
	}
	public String getHabitualPattern() {
		return habitualPattern;
	}
	public void setHabitualPattern(String habitualPattern) {
		this.habitualPattern = habitualPattern;
	}
	public String getHistoryOfSmoking() {
		return historyOfSmoking;
	}
	public void setHistoryOfSmoking(String historyOfSmoking) {
		this.historyOfSmoking = historyOfSmoking;
	}
	public String getEmotionalStress() {
		return emotionalStress;
	}
	public void setEmotionalStress(String emotionalStress) {
		this.emotionalStress = emotionalStress;
	}
	public String getSleep() {
		return sleep;
	}
	public void setSleep(String sleep) {
		this.sleep = sleep;
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
	private Date createdDate;
	private Date lastUpdateDate;
	private String lastUpdatedUser;
	@Override
	public String toString() {
		return "FamilyHistoryDto [id=" + id + ", relation=" + relation + ", alcoholConsumption=" + alcoholConsumption
				+ ", habitualPattern=" + habitualPattern + ", historyOfSmoking=" + historyOfSmoking
				+ ", emotionalStress=" + emotionalStress + ", sleep=" + sleep + ", createduser=" + createduser
				+ ", createdDate=" + createdDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedUser="
				+ lastUpdatedUser + "]";
	}
}
