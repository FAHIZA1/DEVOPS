package com.telecom.tel.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "CSA")
public class CustomerSupportAgent {

	@Id
	@NotNull(message = "Id cannot be Null")
	private int id;
	
	@NotNull(message="customer support agent name cannot be Null")
	private String csaName;
	
	@NotNull(message="CSA Location cannot be Null")
	private String location;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCsaName() {
		return csaName;
	}

	public void setCsaName(String csaName) {
		this.csaName = csaName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
