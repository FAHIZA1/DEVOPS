package com.telecom.tel.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.telecom.tel.bills.Bills;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@NotNull(message="Id cannot be Null")
	private int govtID;
	
	@NotNull(message="customer name cannot be Null")
	private String custName;
	
	@NotNull(message="Telecom Circle cannot be Null")
	private String telecomCircle;
	
	private String vas;
	private int pBills;
	
	@NotNull(message="Customer Type cannot be Null")
	private String custType;
	
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Bills> bills;


	public List<Bills> getBills() {
		return bills;
	}

	public void setBills(List<Bills> bills) {
		this.bills = bills;
	}

	public int getGovtID() {
		return govtID;
	}
	
	public void setGovtID(int govtID) {
		this.govtID = govtID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTelecomCircle() {
		return telecomCircle;
	}

	public void setTelecomCircle(String telecomCircle) {
		this.telecomCircle = telecomCircle;
	}

	public String getVas() {
		return vas;
	}

	public void setVas(String vas) {
		this.vas = vas;
	}

	public int getPBills() {
		return pBills;
	}

	public void setPBills(int pBills) {
		this.pBills = pBills;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	public int getColumnCount() {
        return getClass().getDeclaredFields().length-1;
	}
	
	
	
}
