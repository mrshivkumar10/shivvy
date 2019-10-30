package com.fdmgroup.FairBnBwebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property_types")
public class PropertyType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "property_type_id", unique = true, nullable = false)
	private int propertyTypeId;
	
	@Column(name="property_type")
	private String propertyTypeName;

	public PropertyType() {}

	public PropertyType(int propertyTypeId, String propertyTypeName) {
		super();
		this.propertyTypeId = propertyTypeId;
		this.propertyTypeName = propertyTypeName;
	}

	public int getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(int propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	@Override
	public String toString() {
		return "PropertyType [propertyTypeId=" + propertyTypeId + ", propertyTypeName=" + propertyTypeName + "]";
	}

	
	

}
