package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.PropertyType;
import com.fdmgroup.FairBnBwebsite.repository.PropertyTypeRepository;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {

	@Autowired
	private PropertyTypeRepository propertyTypeRepository;

	@Override
	public PropertyType getPropertyTypeById(int propertyTypeId) {
		PropertyType propertyType = propertyTypeRepository.findById(propertyTypeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid property type ID:" + propertyTypeId));
		return propertyType;
	}

	@Override
	public PropertyType createPropertyType() {
		PropertyType propertyType = new PropertyType();
		return propertyType;
	}

	@Override
	public PropertyType savePropertyType(@Valid PropertyType propertyType) {
		return propertyTypeRepository.save(propertyType);
	}
	
	@Override
	public PropertyType editPropertyType(PropertyType propertyType) {
		return propertyTypeRepository.save(propertyType);
	}

	@Override
	public void deletePropertyTypeById(int propertyTypeId) {
		PropertyType propertyType = propertyTypeRepository.findById(propertyTypeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid property type ID:" + propertyTypeId));
		propertyTypeRepository.delete(propertyType);
	}

	@Override
	public void deletePropertyType(PropertyType propertyType) {
		propertyTypeRepository.delete(propertyType);
	}

	@Override
	public List<PropertyType> getAllPropertyTypes() {
		return propertyTypeRepository.findAll();
	}

	public PropertyTypeRepository getPropertyTypeRepository() {
		return propertyTypeRepository;
	}

	public void setPropertyTypeRepository(PropertyTypeRepository propertyTypeRepository) {
		this.propertyTypeRepository = propertyTypeRepository;
	}

	@Override
	public String toString() {
		return "PropertyTypeServiceImpl [propertyTypeRepository=" + propertyTypeRepository + "]";
	}

	


}
