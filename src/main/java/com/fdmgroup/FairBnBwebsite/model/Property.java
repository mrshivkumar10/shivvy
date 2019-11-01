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
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "property_id", unique = true, nullable = false)
	private int propertyId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "host_id")
	private Host propertyHost;
	
	@Column(name = "location_id")
	private int locationId;
	@Column(name = "property_type_id")
	private int propertyTypeId;
	
	@Column(name = "nightly_rate")
	private int nightlyRate;

	public Property(){}

	

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public Host getPropertyHost() {
		return propertyHost;
	}



	public void setPropertyHost(Host propertyHost) {
		this.propertyHost = propertyHost;
	}



	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(int propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public int getNightlyRate() {
		return nightlyRate;
	}

	public void setNightlyRate(int nightlyRate) {
		this.nightlyRate = nightlyRate;
	}


	

}
