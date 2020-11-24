package com.decode.masters.dto;

import java.util.Date;
import java.util.List;

public class EyeHealthDto {
	private int id;
	private List<String> suggestedInterventionForEye;
	private List<String> suggestedDilatedEyeExamination;
	
	private String leftEyeNotes;
	private String rightEyeNotes;
	private String createduser;
	private Date createdDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<String> getSuggestedInterventionForEye() {
		return suggestedInterventionForEye;
	}
	public void setSuggestedInterventionForEye(List<String> suggestedInterventionForEye) {
		this.suggestedInterventionForEye = suggestedInterventionForEye;
	}
	public List<String> getSuggestedDilatedEyeExamination() {
		return suggestedDilatedEyeExamination;
	}
	public void setSuggestedDilatedEyeExamination(List<String> suggestedDilatedEyeExamination) {
		this.suggestedDilatedEyeExamination = suggestedDilatedEyeExamination;
	}
	public String getLeftEyeNotes() {
		return leftEyeNotes;
	}
	public void setLeftEyeNotes(String leftEyeNotes) {
		this.leftEyeNotes = leftEyeNotes;
	}
	public String getRightEyeNotes() {
		return rightEyeNotes;
	}
	public void setRightEyeNotes(String rightEyeNotes) {
		this.rightEyeNotes = rightEyeNotes;
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
	private Date lastUpdateDate;
	@Override
	public String toString() {
		return "EyeHealthDto [id=" + id + ", suggestedInterventionForEye=" + suggestedInterventionForEye
				+ ", suggestedDilatedEyeExamination=" + suggestedDilatedEyeExamination + ", leftEyeNotes="
				+ leftEyeNotes + ", rightEyeNotes=" + rightEyeNotes + ", createduser=" + createduser + ", createdDate="
				+ createdDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdatedUser=" + lastUpdatedUser + "]";
	}
	private String lastUpdatedUser;
}
