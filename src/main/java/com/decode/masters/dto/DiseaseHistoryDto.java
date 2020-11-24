package com.decode.masters.dto;

import java.util.Date;
import java.util.List;

public class DiseaseHistoryDto {
		private int id;
		private String diseaseName;
		private String diseaseType;
		private String duration;
		private String lsm;
		private String medication;
		private String typeOfOralMedication;
		private List<String> comorBidities;
		private String createduser;
		private Date createdDate;
		private Date lastUpdateDate;
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
		
		public List<String> getComorBidities() {
			return comorBidities;
		}
		public void setComorBidities(List<String> comorBidities) {
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
		@Override
		public String toString() {
			return "DiseaseHistoryDto [id=" + id + ", diseaseName=" + diseaseName + ", diseaseType=" + diseaseType
					+ ", duration=" + duration + ", lsm=" + lsm + ", medication=" + medication
					+ ", typeOfOralMedication=" + typeOfOralMedication + ", comorBidities=" + comorBidities
					+ ", createduser=" + createduser + ", createdDate=" + createdDate + ", lastUpdateDate="
					+ lastUpdateDate + ", lastUpdatedUser=" + lastUpdatedUser + "]";
		}
}
