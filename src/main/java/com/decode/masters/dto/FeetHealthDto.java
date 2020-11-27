package com.decode.masters.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class FeetHealthDto {
	private int id;
	private String rightFeetCondition;
	private String leftFeetCondition;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String> rightFeetObservation;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String>  leftFeetObservation;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String>  rightFeetUlceration;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String>  leftFeetUlceration;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String>  rightFeetVibration;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<String>  leftFeetVibration;
	private String rightFeetCounter;
	private String leftFeetCounter;
	private String createduser;
	private Date createdDate;
	private Date lastUpdateDate;
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
	
	public List<String> getRightFeetObservation() {
		return rightFeetObservation;
	}
	public void setRightFeetObservation(List<String> rightFeetObservation) {
		this.rightFeetObservation = rightFeetObservation;
	}
	public List<String> getLeftFeetObservation() {
		return leftFeetObservation;
	}
	public void setLeftFeetObservation(List<String> leftFeetObservation) {
		this.leftFeetObservation = leftFeetObservation;
	}
	public List<String> getRightFeetUlceration() {
		return rightFeetUlceration;
	}
	public void setRightFeetUlceration(List<String> rightFeetUlceration) {
		this.rightFeetUlceration = rightFeetUlceration;
	}
	public List<String> getLeftFeetUlceration() {
		return leftFeetUlceration;
	}
	public void setLeftFeetUlceration(List<String> leftFeetUlceration) {
		this.leftFeetUlceration = leftFeetUlceration;
	}
	public List<String> getRightFeetVibration() {
		return rightFeetVibration;
	}
	public void setRightFeetVibration(List<String> rightFeetVibration) {
		this.rightFeetVibration = rightFeetVibration;
	}
	public List<String> getLeftFeetVibration() {
		return leftFeetVibration;
	}
	public void setLeftFeetVibration(List<String> leftFeetVibration) {
		this.leftFeetVibration = leftFeetVibration;
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
	private String lastUpdatedUser;
	@Override
	public String toString() {
		return "FeetHealthDto [id=" + id + ", rightFeetCondition=" + rightFeetCondition + ", leftFeetCondition="
				+ leftFeetCondition + ", rightFeetObservation=" + rightFeetObservation + ", leftFeetObservation="
				+ leftFeetObservation + ", rightFeetUlceration=" + rightFeetUlceration + ", leftFeetUlceration="
				+ leftFeetUlceration + ", rightFeetVibration=" + rightFeetVibration + ", leftFeetVibration="
				+ leftFeetVibration + ", rightFeetCounter=" + rightFeetCounter + ", leftFeetCounter=" + leftFeetCounter
				+ ", createduser=" + createduser + ", createdDate=" + createdDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", lastUpdatedUser=" + lastUpdatedUser + "]";
	}
}
