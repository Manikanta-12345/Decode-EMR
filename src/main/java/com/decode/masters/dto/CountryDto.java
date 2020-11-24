package com.decode.masters.dto;

import java.io.Serializable;
import java.util.Date;


public class CountryDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date createdOn;
	private String createdBy;
	private String port;
	public CountryDto(){
		
	}
	public CountryDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	
}
