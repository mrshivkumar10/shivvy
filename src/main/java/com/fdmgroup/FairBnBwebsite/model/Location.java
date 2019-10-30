package com.fdmgroup.FairBnBwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id", unique = true, nullable = false)
	private int locationId;
	@Column(name = "city")
	private String city;
	@Column(name = "county")
	private String county;
	
	public Location () {}

	public Location(int locationId, String city, String county) {
		super();
		this.locationId = locationId;
		this.city = city;
		this.county = county;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", county=" + county + "]";
	}
	

}
