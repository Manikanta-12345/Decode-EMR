package com.decode.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "decode_episode")
public class Episode {
	@Id
	@Column(name = "episode_id")
	private String episodeId;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@Column(name = "created_user")
	private String createdUser;
	@Column(name = "last_updated_user")
	private String lastUpdatedUser;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "last_updated_date")
	private Date lastUpdateDate;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="episode")
	private DiseaseHistory diseaseHistory;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="episode")
	private DiseaseSeverityAndControlStatus diseaseSeverity;

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(String lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
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

	public DiseaseHistory getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(DiseaseHistory diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public DiseaseSeverityAndControlStatus getDiseaseSeverity() {
		return diseaseSeverity;
	}

	public void setDiseaseSeverity(DiseaseSeverityAndControlStatus diseaseSeverity) {
		this.diseaseSeverity = diseaseSeverity;
	}

}
