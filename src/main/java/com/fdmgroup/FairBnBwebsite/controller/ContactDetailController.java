package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.FairBnBwebsite.model.ContactDetail;
import com.fdmgroup.FairBnBwebsite.model.PropertyType;
import com.fdmgroup.FairBnBwebsite.service.ContactDetailService;

@Controller
public class ContactDetailController {
	
	private final ContactDetailService contactDetailService;
	
	@Autowired
	public ContactDetailController(ContactDetailService contactDetailService) {
		this.contactDetailService = contactDetailService;
	}

	@GetMapping("/contactdetailindex")
	public String ContactDetailIndex(Model model) {
		model.addAttribute("contactDetailAttr", contactDetailService.getAllContactDetails());
		return "index-contactdetails";
	}
	
	@GetMapping("/contactdetailsignup")
	public String propertyTypeSignupForm(Model model) {
		model.addAttribute("contactDetailAttr", contactDetailService.createContactDetail());
		return "add-contactdetail";
	}
	
	@PostMapping("/addcontacttype")
	public String addContactDetail(@Valid ContactDetail contactDetailAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-contactdetail";
		}

		contactDetailService.saveContactDetail(contactDetailAttr);
		model.addAttribute("contactDetailAttr", contactDetailService.getAllContactDetails());
		return "index-contactdetails";
	}
	
	
}
