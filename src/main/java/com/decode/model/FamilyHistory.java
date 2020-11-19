package com.decode.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class FamilyHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private int id;
	@Column(name = "relation")
	private String relation;
	@Column(name = "alcohol_consumption")
	private String alcoholConsumption;
	@Column(name = "habitual_pattern")
	private String habitualPattern;
	@Column(name = "history_of_smoking")
	private String historyOfSmoking;
	@Column(name = "emotional_stress")
	private String emotionalStress;
	@Column(name = "sleep")
	private String sleep;
	@Column(name = "created_user")
	private String createduser;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "last_update_date")
	private Date lastUpdateDate;
	@Column(name = "last_update_user")
	private String lastUpdatedUser;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "episode_id")
	private Episode episode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Episode getEpisode() {
		return episode;
	}
	public void setEpisode(Episode episode) {
		this.episode = episode;
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
}
