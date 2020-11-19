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
@Table(name="disease_history")
public class DiseaseHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="disease_id")
	private int id;
    @Column(name="disease_name")
	private String diseaseName;
    @Column(name="disease_type")
	private String diseaseType;
    @Column(name="duration")
	private String duration;
    @Column(name="lsm")
	private String lsm;
    @Column(name="medication")
	private String medication;
    @Column(name="type_of_oral_medication")
	private String typeOfOralMedication;
    @Column(name="comorbidities")
	private String comorBidities;
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
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseaseType() {
		return diseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLsm() {
		return lsm;
	}
	public void setLsm(String lsm) {
		this.lsm = lsm;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getTypeOfOralMedication() {
		return typeOfOralMedication;
	}
	public void setTypeOfOralMedication(String typeOfOralMedication) {
		this.typeOfOralMedication = typeOfOralMedication;
	}
	
	public String getComorBidities() {
		return comorBidities;
	}
	public void setComorBidities(String comorBidities) {
		this.comorBidities = comorBidities;
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
