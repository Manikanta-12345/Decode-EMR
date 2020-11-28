package com.decode.masters.dto;

public class PatientSearchDto {
private String patientId;
private String patientName;
private String mobileNo;

public PatientSearchDto(String patientId, String patientName, String mobileNo) {
	this.patientId = patientId;
	this.patientName = patientName;
	this.mobileNo = mobileNo;
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
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getMatchedPatient() {
	String patientid=this.patientId+"_"+this.patientName+"_"+(this.mobileNo!=null?this.mobileNo:"");
	System.out.println("p "+patientid);
	return patientid;
}

}
