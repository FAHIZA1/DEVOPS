package com.telecom.tel.bills;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.telecom.tel.Model.Customer;

@Entity
@Table(name="Bills")
public class Bills {
	
	@Id
	private int bid;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate bstart;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate bend;
	
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate bpay;
	
	private String bstatus;
	
	private int Amount;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public LocalDate getBstart() {
		return bstart;
	}

	public void setBstart(LocalDate bstart) {
		this.bstart = bstart;
	}

	public LocalDate getBend() {
		return bend;
	}

	public void setBend(LocalDate bend) {
		this.bend = bend;
	}

	public LocalDate getBpay() {
		return bpay;
	}

	public void setBpay(LocalDate bpay) {
		this.bpay = bpay;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
	

}
