package com.decode.masters.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientDto {
	
	private String patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private int years;
	private int months;
	private int days;
	private String gender;
	private String title;
	private int countryId;
	private int stateId;
	private int districtId;
	private String email;
	private String mobile;
	private String nextKin;
	private String createduser;
	private String contact;
	private AddressDto patientAddress;
	
	private List<EpisodeDto> episodes;
    private int orgId;
	public String getPatientId() {
		return patientId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNextKin() {
		return nextKin;
	}

	public void setNextKin(String nextKin) {
		this.nextKin = nextKin;
	}

	public String getCreateduser() {
		return createduser;
	}

	public void setCreateduser(String createduser) {
		this.createduser = createduser;
	}

	public AddressDto getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(AddressDto patientAddress) {
		this.patientAddress = patientAddress;
	}

	public List<EpisodeDto> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<EpisodeDto> episodes) {
		this.episodes = episodes;
	}

	

	
	
}
