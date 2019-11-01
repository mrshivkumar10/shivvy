package com.fdmgroup.FairBnBwebsite.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "property_id", unique = true, nullable = false)
	private int propertyId;
	
	@OneToMany(mappedBy="reservationProperty")
	private List <Reservation> reservation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "host_id") //hostId
	private Host propertyHost;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "location_id") //locationId
	private Property propertyLocation;	
	
	@Column(name = "property_type_id")
	private int propertyTypeId;
	
	@Column(name = "nightly_rate")
	private int nightlyRate;

	//default constructor
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

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Property getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Property propertyLocation) {
		this.propertyLocation = propertyLocation;
	}
	
}
