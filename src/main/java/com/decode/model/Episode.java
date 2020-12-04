package com.decode.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "decode_episode")
public class Episode {
	@Id
	@GenericGenerator(name = "episode_id_generator", strategy = "com.decode.utils.EpisodeSequenceIdGenerator")
	@GeneratedValue(generator = "episode_id_generator")
	@Column(name = "episode_id")
	private String episodeId;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private DiseaseHistory diseaseHistory;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private DiseaseSeverityAndControlStatus diseaseSeverity;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private EyeHealth eyeHealth;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private KidneyHealth kidneyHealth;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private HeartHealth heartHealth;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private FamilyHistory familyHistory;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private FeetHealth feetHealth;
	@OneToOne(mappedBy = "episode", cascade = CascadeType.ALL)
	private NextAppointments nextAppointments;
	@Column(name = "org_id")
	private int orgId;
	@Column(name = "loc_id")
	private int locationId;
	@Column(name = "episode_status")
    private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public EyeHealth getEyeHealth() {
		return eyeHealth;
	}

	public void setEyeHealth(EyeHealth eyeHealth) {
		this.eyeHealth = eyeHealth;
	}

	public KidneyHealth getKidneyHealth() {
		return kidneyHealth;
	}

	public void setKidneyHealth(KidneyHealth kidneyHealth) {
		this.kidneyHealth = kidneyHealth;
	}

	public HeartHealth getHeartHealth() {
		return heartHealth;
	}

	public void setHeartHealth(HeartHealth heartHealth) {
		this.heartHealth = heartHealth;
	}

	public FamilyHistory getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(FamilyHistory familyHistory) {
		this.familyHistory = familyHistory;
	}

	public FeetHealth getFeetHealth() {
		return feetHealth;
	}

	public void setFeetHealth(FeetHealth feetHealth) {
		this.feetHealth = feetHealth;
	}

	public NextAppointments getNextAppointments() {
		return nextAppointments;
	}

	public void setNextAppointments(NextAppointments nextAppointments) {
		this.nextAppointments = nextAppointments;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Episode [episodeId=" + episodeId + ", diseaseHistory=" + diseaseHistory + ", diseaseSeverity="
				+ diseaseSeverity + ", eyeHealth=" + eyeHealth + ", kidneyHealth=" + kidneyHealth + ", heartHealth="
				+ heartHealth + ", familyHistory=" + familyHistory + ", feetHealth=" + feetHealth
				+ ", nextAppointments=" + nextAppointments + "]";
	}

}
