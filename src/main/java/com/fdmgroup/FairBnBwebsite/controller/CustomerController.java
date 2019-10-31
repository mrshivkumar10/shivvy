package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.FairBnBwebsite.model.Customer;
import com.fdmgroup.FairBnBwebsite.model.Location;
import com.fdmgroup.FairBnBwebsite.service.CustomerService;

@Controller
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customerindex")
	public String customerIndex(Model model) {
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";
	}

	@GetMapping("/customersignup")
	public String customerSignupForm(Model model) {
		model.addAttribute("customerAttr", customerService.createCustomer());
		return "add-customer";
	}

	@PostMapping("/addcustomer")
	public String addCustomer(@Valid Customer customerAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-customer";
		}

		customerService.saveCustomer(customerAttr);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";

	}

	@GetMapping("/editcustomer/{id}")
	public String propertyLocation(@PathVariable("id") Integer customerId, Model model) {
		Customer customer = customerService.getCustomerById(customerId);
		model.addAttribute("customerAttr", customer);
		return "update-customer";

	}

	@PostMapping("/updatecustomer/{id}")
	public String updateLocation(@PathVariable("id") Integer customerId, @Valid Customer customer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-customer";
		}
		customer.setCustomerId(customerId);
		customerService.editCustomer(customer);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";
	}


	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int customerId, Model model) {
		customerService.deleteCustomerById(customerId);
		model.addAttribute("customerAttr", customerService.getAllCustomers());
		return "index-customers";
	}

}