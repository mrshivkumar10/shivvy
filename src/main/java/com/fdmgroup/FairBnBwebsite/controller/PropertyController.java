package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.FairBnBwebsite.model.Property;
import com.fdmgroup.FairBnBwebsite.service.PropertyService;

@Controller
public class PropertyController {
	
	private final PropertyService propertyService;
	
	@Autowired
	public PropertyController(PropertyService propertyService) {
		this.propertyService = propertyService;	
	}
	
	@GetMapping("/propertyindex")
	public String propertyIndex(Model model) {
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		return "index-property";
	}

	@GetMapping("/propertysignup")
	public String propertySignupForm(Model model) {
		model.addAttribute("propertyAttr", propertyService.createProperty());
		return "add-property";
	}

	@PostMapping("/addproperty")
	public String addProperty(@Valid Property propertyAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-property";
		}

		propertyService.saveProperty(propertyAttr);
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		return "index-property";
	}

	@GetMapping("/editproperty/{id}")
	public String propertyUpdateForm(@PathVariable("id") int propertyId, Model model) {
		Property property = propertyService.getPropertyById(propertyId);
		model.addAttribute("propertyAttr", property);
		return "update-property";
	}

	@PostMapping("/updateproperty/{id}")
	public String updateProperty(@PathVariable("id") int propertyId, @Valid Property property,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-property";
		}

		property.setPropertyId(propertyId);
		propertyService.editProperty(property);
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		return "index-property";
	}

	@GetMapping("/deleteproperty/{id}")
	public String deleteProperty(@PathVariable("id") int propertyId, Model model) {
		propertyService.deletePropertyById(propertyId);
		model.addAttribute("propertyAttr", propertyService.getAllPropertys());
		return "index-property";
	}
	
	

}
