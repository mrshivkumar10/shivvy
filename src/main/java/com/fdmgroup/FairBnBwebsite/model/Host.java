package com.fdmgroup.FairBnBwebsite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "hosts")
public class Host {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "host_id", unique = true, nullable = false)
	private int hostId;
	
	@JoinColumn(name="contact_id")
	private int contactId;
	
	public Host(){}

	
	
//	public int getHostId() {
//		return hostId;
//	}
//
//	public void setHostId(int hostId) {
//		this.hostId = hostId;
//	}
//
//	public int getContactId() {
//		return contactId;
//	}
//
//	public void setContactId(int contactId) {
//		this.contactId = contactId;
//	}
//	

}
