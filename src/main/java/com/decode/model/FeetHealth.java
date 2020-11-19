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
@Table(name = "feet_health")
public class FeetHealth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feet_health_id")
	private int id;
	@Column(name = "right_feet_condition")
	private String rightFeetCondition;
	@Column(name = "left_feet_condition")
	private String leftFeetCondition;
	@Column(name = "right_feet_observation")
	private String rightFeetObservation;
	@Column(name = "left_feet_observation")
	private String leftFeetObservation;
	@Column(name = "right_feet_ulceration")
	private String rightFeetUlceration;
	@Column(name = "left_feet_ulceration")
	private String leftFeetUlceration;
	@Column(name = "right_feet_vibration")
	private String rightFeetVibration;
	@Column(name = "left_feet_vibration")
	private String leftFeetVibration;
	@Column(name = "right_feet_counter")
	private String rightFeetCounter;
	@Column(name = "left_feet_counter")
	private String leftFeetCounter;
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
	public String getRightFeetCondition() {
		return rightFeetCondition;
	}
	public void setRightFeetCondition(String rightFeetCondition) {
		this.rightFeetCondition = rightFeetCondition;
	}
	public String getLeftFeetCondition() {
		return leftFeetCondition;
	}
	public void setLeftFeetCondition(String leftFeetCondition) {
		this.leftFeetCondition = leftFeetCondition;
	}
	public String getRightFeetObservation() {
		return rightFeetObservation;
	}
	public void setRightFeetObservation(String rightFeetObservation) {
		this.rightFeetObservation = rightFeetObservation;
	}
	public String getLeftFeetObservation() {
		return leftFeetObservation;
	}
	public void setLeftFeetObservation(String leftFeetObservation) {
		this.leftFeetObservation = leftFeetObservation;
	}
	public String getRightFeetUlceration() {
		return rightFeetUlceration;
	}
	public void setRightFeetUlceration(String rightFeetUlceration) {
		this.rightFeetUlceration = rightFeetUlceration;
	}
	public String getLeftFeetUlceration() {
		return leftFeetUlceration;
	}
	public void setLeftFeetUlceration(String leftFeetUlceration) {
		this.leftFeetUlceration = leftFeetUlceration;
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
	public String getRightFeetVibration() {
		return rightFeetVibration;
	}
	public void setRightFeetVibration(String rightFeetVibration) {
		this.rightFeetVibration = rightFeetVibration;
	}
	public String getRightFeetCounter() {
		return rightFeetCounter;
	}
	public void setRightFeetCounter(String rightFeetCounter) {
		this.rightFeetCounter = rightFeetCounter;
	}
	public String getLeftFeetCounter() {
		return leftFeetCounter;
	}
	public void setLeftFeetCounter(String leftFeetCounter) {
		this.leftFeetCounter = leftFeetCounter;
	}
	public String getLeftFeetVibration() {
		return leftFeetVibration;
	}
	public void setLeftFeetVibration(String leftFeetVibration) {
		this.leftFeetVibration = leftFeetVibration;
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
}
