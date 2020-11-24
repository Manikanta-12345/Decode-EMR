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
@Table(name = "kidney_health")
public class KidneyHealth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kidney_health_id")
	private int id;
	@Column(name="suggested_kidney_intervention")
	private String suggestedInterventionForKidney;
	@Column(name="suggested_kideny_monitoring")
	private String suggestedKidneyMonitoring;
	@Column(name = "sugar")
	private String sugar;
	@Column(name = "protien")
	private String protien;
	@Column(name = "micro_albumin")
	private String microAlbumin;
	@Column(name = "blood_urea")
	private String bloodUrea;
	@Column(name = "serum_creatinine")
	private String serumCreatinine;
	@Column(name = "created_user")
	private String createduser;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "last_update_date")
	private Date lastUpdateDate;
	@Column(name = "last_update_user")
	private String lastUpdatedUser;
	@OneToOne
	@JoinColumn(name = "episode_id")
    private Episode episode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuggestedInterventionForKidney() {
		return suggestedInterventionForKidney;
	}
	public void setSuggestedInterventionForKidney(String suggestedInterventionForKidney) {
		this.suggestedInterventionForKidney = suggestedInterventionForKidney;
	}
	public String getSuggestedKidneyMonitoring() {
		return suggestedKidneyMonitoring;
	}
	public void setSuggestedKidneyMonitoring(String suggestedKidneyMonitoring) {
		this.suggestedKidneyMonitoring = suggestedKidneyMonitoring;
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
	@Override
	public String toString() {
		return "KidneyHealth [id=" + id + ", suggestedInterventionForKidney=" + suggestedInterventionForKidney
				+ ", suggestedKidneyMonitoring=" + suggestedKidneyMonitoring + ", sugar=" + sugar + ", protien="
				+ protien + ", microAlbumin=" + microAlbumin + ", bloodUrea=" + bloodUrea + ", serumCreatinine="
				+ serumCreatinine + "]";
	}
	
	
}
