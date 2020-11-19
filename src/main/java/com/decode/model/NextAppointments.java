package com.decode.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "next_appointments")
public class NextAppointments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "next_appointments_id")
	private int id;
	@Column(name = "blood_pressure_date")
	private Date bloodPressureDate;
	@Column(name = "hbA1c_monitoring_date")
	private Date hbA1cMonitoring;
	@Column(name = "neuropathy_screening_date")
	private Date neuropathyScreening;
	@Column(name = "cholestrol_monitoring_date")
	private Date cholestrolMonitoring;
	@Column(name = "kidney_functions_date")
	private Date kidneyFunctions;
	@Column(name = "plasma_monitoring_date")
	private Date plasmaMonitoring;
	@Column(name = "retinal_examinastion_date")
	private Date retinalExaminastion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBloodPressureDate() {
		return bloodPressureDate;
	}

	public void setBloodPressureDate(Date bloodPressureDate) {
		this.bloodPressureDate = bloodPressureDate;
	}

	public Date getHbA1cMonitoring() {
		return hbA1cMonitoring;
	}

	public void setHbA1cMonitoring(Date hbA1cMonitoring) {
		this.hbA1cMonitoring = hbA1cMonitoring;
	}

	public Date getNeuropathyScreening() {
		return neuropathyScreening;
	}

	public void setNeuropathyScreening(Date neuropathyScreening) {
		this.neuropathyScreening = neuropathyScreening;
	}

	public Date getCholestrolMonitoring() {
		return cholestrolMonitoring;
	}

	public void setCholestrolMonitoring(Date cholestrolMonitoring) {
		this.cholestrolMonitoring = cholestrolMonitoring;
	}

	public Date getKidneyFunctions() {
		return kidneyFunctions;
	}

	public void setKidneyFunctions(Date kidneyFunctions) {
		this.kidneyFunctions = kidneyFunctions;
	}

	public Date getPlasmaMonitoring() {
		return plasmaMonitoring;
	}

	public void setPlasmaMonitoring(Date plasmaMonitoring) {
		this.plasmaMonitoring = plasmaMonitoring;
	}

	public Date getRetinalExaminastion() {
		return retinalExaminastion;
	}

	public void setRetinalExaminastion(Date retinalExaminastion) {
		this.retinalExaminastion = retinalExaminastion;
	}

}
