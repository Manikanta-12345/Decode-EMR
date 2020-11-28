package com.decode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="decode_employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
	private String employeeId;
    @Column(name = "locations")
	private String empLocations;
    @Column(name = "org_id")
	private int empOrgid;
    
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpLocations() {
		return empLocations;
	}
	public void setEmpLocations(String empLocations) {
		this.empLocations = empLocations;
	}
	public int getEmpOrgid() {
		return empOrgid;
	}
	public void setEmpOrgid(int empOrgid) {
		this.empOrgid = empOrgid;
	}
}
