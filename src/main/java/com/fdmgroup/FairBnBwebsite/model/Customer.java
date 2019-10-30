package com.fdmgroup.FairBnBwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", unique = true, nullable = false)
	private int customerId;

	@Column(name = "contact_id")
	private String contactId;

	public Customer(int customerId, String contactId) {
		super();
		this.customerId = customerId;
		this.contactId = contactId;
	}

	public Customer() {
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contactId=" + contactId + "]";
	}

}
