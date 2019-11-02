package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.fdmgroup.FairBnBwebsite.model.Host;
import com.fdmgroup.FairBnBwebsite.service.HostService;

@Controller
public class HostController {
	
	private final HostService hostService;
	
	@Autowired
	public HostController(HostService hostService) {
		this.hostService = hostService;
	}
	
	@GetMapping("/hostindex")
	public String HostIndex(Model model){
		model.addAttribute("hostAttr", hostService.getAllHosts());
		System.out.println("host getAllHosts: " + model.addAttribute("hostAttr", hostService.getAllHosts()));
		return "index-hosts";
	}
	
	@GetMapping("/hostsignup")
	public String HostSignupForm(Model model) {
		model.addAttribute("hostAttr", hostService.createHost());
		return "add-host";
	}
	
	@PostMapping("/addhost")
	public String addContactDetail(@Valid Host hostAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-host";
		}
		hostService.saveHost(hostAttr);
		model.addAttribute("hostAttr", hostService.getAllHosts());
		return "index-hosts";
	}
	
	@GetMapping("/edithost/{id}")
	public String HostUpdateForm(@PathVariable("id") int hostId, Model model) {
		Host host = hostService.getHostById(hostId);
		model.addAttribute("hostAttr", host);
		return "update-host";
	}
	
	@PostMapping("/updatehost/{id}")
	public String updateContactDetail(@PathVariable("id") int hostId,
			@Valid Host host, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-host";
		}
		
		host.setHostId(hostId);
		hostService.editHost(host);
		model.addAttribute("hostAttr", hostService.getAllHosts());
		return "index-hosts";
	}
	
	@GetMapping("/deletehost/{id}")
	public String deletePropertyType(@PathVariable("id") int hostId, Model model) {
		hostService.deleteHostById(hostId);
		model.addAttribute("hostAttr", hostService.getAllHosts());
		return "index-hosts";
	}
}
