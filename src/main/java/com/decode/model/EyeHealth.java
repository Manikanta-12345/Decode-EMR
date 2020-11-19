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
@Table(name = "eye_health")
public class EyeHealth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eye_health_id")
	private int id;
	@Column(name="suggested_eye_intervention")
	private String suggestedInterventionForEye;
	@Column(name="suggested_eye_dialated_examination")
	private String suggestedDilatedEyeExamination;
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
	public String getSuggestedInterventionForEye() {
		return suggestedInterventionForEye;
	}
	public void setSuggestedInterventionForEye(String suggestedInterventionForEye) {
		this.suggestedInterventionForEye = suggestedInterventionForEye;
	}
	public String getSuggestedDilatedEyeExamination() {
		return suggestedDilatedEyeExamination;
	}
	public void setSuggestedDilatedEyeExamination(String suggestedDilatedEyeExamination) {
		this.suggestedDilatedEyeExamination = suggestedDilatedEyeExamination;
	}
}
