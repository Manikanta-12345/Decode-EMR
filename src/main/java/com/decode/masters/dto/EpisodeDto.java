package com.decode.masters.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



public class EpisodeDto {
	@Override
	public String toString() {
		return "EpisodeDto [episodeId=" + episodeId + ", createdUser=" + createdUser + ", lastUpdatedUser="
				+ lastUpdatedUser + ", createdDate=" + createdDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", diseaseHistory=" + diseaseHistory + ", diseaseSeverity=" + diseaseSeverity + ", eyeHealth="
				+ eyeHealth + ", kidneyHealth=" + kidneyHealth + ", heartHealth=" + heartHealth + ", familyHistory="
				+ familyHistory + ", feetHealth=" + feetHealth + ", nextAppointments=" + nextAppointments + "]";
	}

	private String episodeId;
	private String createdUser;
	private String lastUpdatedUser;
	private Date createdDate;
	private Date lastUpdateDate;
	private DiseaseHistoryDto diseaseHistory;
	private DiseaseSeverityAndControlStatusDto diseaseSeverity;

	private EyeHealthDto eyeHealth;

	private KidneyHealthDto kidneyHealth;

	private HeartHealthDto heartHealth;

	private FamilyHistoryDto familyHistory;
	private FeetHealthDto feetHealth;
	private int orgId;
    private int locationId;
    private String leftFileName;
    private String rightFileName;
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
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

	public DiseaseHistoryDto getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(DiseaseHistoryDto diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public DiseaseSeverityAndControlStatusDto getDiseaseSeverity() {
		return diseaseSeverity;
	}

	public void setDiseaseSeverity(DiseaseSeverityAndControlStatusDto diseaseSeverity) {
		this.diseaseSeverity = diseaseSeverity;
	}

	public EyeHealthDto getEyeHealth() {
		return eyeHealth;
	}

	public void setEyeHealth(EyeHealthDto eyeHealth) {
		this.eyeHealth = eyeHealth;
	}

	public KidneyHealthDto getKidneyHealth() {
		return kidneyHealth;
	}

	public void setKidneyHealth(KidneyHealthDto kidneyHealth) {
		this.kidneyHealth = kidneyHealth;
	}

	public HeartHealthDto getHeartHealth() {
		return heartHealth;
	}

	public void setHeartHealth(HeartHealthDto heartHealth) {
		this.heartHealth = heartHealth;
	}

	public FamilyHistoryDto getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(FamilyHistoryDto familyHistory) {
		this.familyHistory = familyHistory;
	}

	public FeetHealthDto getFeetHealth() {
		return feetHealth;
	}

	public void setFeetHealth(FeetHealthDto feetHealth) {
		this.feetHealth = feetHealth;
	}

	public NextAppointmentsDto getNextAppointments() {
		return nextAppointments;
	}

	public void setNextAppointments(NextAppointmentsDto nextAppointments) {
		this.nextAppointments = nextAppointments;
	}

	private NextAppointmentsDto nextAppointments;
	

	public String getLeftFileName() {
		return leftFileName;
	}

	public void setLeftFileName(String leftFileName) {
		this.leftFileName = leftFileName;
	}

	public String getRightFileName() {
		return rightFileName;
	}

	public void setRightFileName(String rightFileName) {
		this.rightFileName = rightFileName;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
}
