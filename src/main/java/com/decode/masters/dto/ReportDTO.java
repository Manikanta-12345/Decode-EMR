package com.decode.masters.dto;

import java.util.Date;

public class ReportDTO {
	
	
public ReportDTO(String patientId, String patientName, String visitId, Date visitDate, int age, String gender,
			String contactNumber,String status) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.visitId = visitId;
		this.visitDate = visitDate;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.status=status;
	}
private String patientId;
private String patientName;
private String visitId;
private Date visitDate;
private int age;
private String gender;
private String contactNumber;
private String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getVisitId() {
	return visitId;
}
public void setVisitId(String visitId) {
	this.visitId = visitId;
}
public Date getVisitDate() {
	return visitDate;
}
public void setVisitDate(Date visitDate) {
	this.visitDate = visitDate;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}


}
