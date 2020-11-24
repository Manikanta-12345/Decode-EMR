package com.decode.masters.dto;

import java.io.Serializable;
import java.util.Date;

public class StateDto implements Serializable {

    private int id;
    private String name;

    private int countryId;

    private Date createdOn;
    private String createdBy;

    public StateDto(int id, String name, int countryId) {
        super();
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public StateDto() {
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

}
