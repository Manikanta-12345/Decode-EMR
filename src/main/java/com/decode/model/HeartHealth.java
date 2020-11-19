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
@Table(name = "heart_health")
public class HeartHealth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "heart_health_id")
	private int id;
	@Column(name = "suggested_heart_intervention")
	private String suggestedInterventionForheart;
	@Column(name = "suggested_cholestrol_monitoring")
	private String suggestedCholestrolMonitoring;
	@Column(name = "suggested_pressure_monitoring")
	private String suggestePressureMonitoring;

	@Column(name = "blood_pressure")
	private String bloodPressure;
	@Column(name = "height")
	private String height;
	@Column(name = "weight")
	private String weight;
	@Column(name = "bmi")
	private String bmi;
	@Column(name = "total_cholestrol")
	private String totalCholestrol;
	@Column(name = "triglycerides")
	private String triglycerides;
	@Column(name = "ldl_cholestrol")
	private String ldlCholestrol;
	@Column(name = "vldl_cholestrol")
	private String vldlCholestrol;
	@Column(name = "hdl_cholestrol")
	private String hdlCholestrol;
	@Column(name = "hdl_ratio")
	private String hdlRatio;

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

	public String getSuggestedInterventionForheart() {
		return suggestedInterventionForheart;
	}

	public void setSuggestedInterventionForheart(String suggestedInterventionForheart) {
		this.suggestedInterventionForheart = suggestedInterventionForheart;
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

}
