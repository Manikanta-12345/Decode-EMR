package com.decode.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "decode_patient")
public class Patient {
	@Id
	@Column(name = "patient_id")
	private String patientId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_of_name")
	private Date dateOfBirth;
	@Column(name = "age")
	private int years;
	private int months;
	private int days;
	private String gender;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "nextKin")
	private String nextKin;
	@Column(name = "created_user")
	private String createduser;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "last_update_date")
	private Date lastUpdateDate;
	@Column(name = "last_update_user")
	private String lastUpdatedUser;
	@OneToOne(mappedBy="patient")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private Address patientAddress;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
	private Set<Episode> episodes;

	public String getPatientId() {
		return patientId;
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

	public String getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(String lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
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

	public Address getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(Address patientAddress) {
		this.patientAddress = patientAddress;
	}

}
