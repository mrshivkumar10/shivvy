package com.fdmgroup.FairBnBwebsite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hosts")
public class Host {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "host_id", unique = true, nullable = false)
	private int hostId;
	
	@Column(name="contact_id")
	private int contactId;
	
	public Host(int hostId, int contactId) {
		super();
		this.hostId = hostId;
		this.contactId = contactId;
	}
	
	public Host(){}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "Host [hostId=" + hostId + ", contactId=" + contactId + "]";
	}	

}
