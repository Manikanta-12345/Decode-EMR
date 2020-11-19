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
@Table(name = "disease_severity")
public class DiseaseSeverityAndControlStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "severity_id")
	private int id;
	@Column(name="hbA1c")
	private String hbA1c;
	@Column(name="blood_sugar_levels")
	private String bloodSugarLevels;
	@Column(name="suggested_disease_intervention")
	private String suggestedInterventionForDisease;
	@Column(name="suggested_hba1c_monitoring")
	private String suggestedHba1cMonitoring;
	@Column(name="suggested_plasma")
	private String suggestedPlasma;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "episode_id")
	private Episode episode;
	@Column(name = "created_user")
	private String createduser;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "last_update_date")
	private Date lastUpdateDate;
	@Column(name = "last_update_user")
	private String lastUpdatedUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Episode getEpisode() {
		return episode;
	}
	public void setEpisode(Episode episode) {
		this.episode = episode;
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
	public String getSuggestedInterventionForDisease() {
		return suggestedInterventionForDisease;
	}
	public void setSuggestedInterventionForDisease(String suggestedInterventionForDisease) {
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
}
