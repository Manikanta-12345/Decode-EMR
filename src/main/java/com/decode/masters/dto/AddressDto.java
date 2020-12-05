package com.decode.masters.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.decode.model.Patient;

public class AddressDto {
	private int id;
	private String address;
	private String location;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
