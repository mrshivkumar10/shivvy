package com.fdmgroup.FairBnBwebsite.model;

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
@Table(name="properties")
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "property_id", unique = true, nullable = false)
	private int propertyId;
	
	@Column(name="host_id")
	private int hostId;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "host_id")
//	private Host hostProperty;
	
	
}

