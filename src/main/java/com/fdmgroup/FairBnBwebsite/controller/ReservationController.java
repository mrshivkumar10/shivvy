package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.FairBnBwebsite.model.Customer;
import com.fdmgroup.FairBnBwebsite.model.Reservation;
import com.fdmgroup.FairBnBwebsite.service.ReservationService;

@Controller
public class ReservationController {
	
	private final ReservationService reservationService;
	
	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/reservationindex")
	public String reservationIndex(Model model) {
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		return "index-reservations";
	}
	
	@GetMapping("/reservationsignup")
	public String reservationSignupForm(Model model) {
		model.addAttribute("reservationAttr", reservationService.createReservation());
		return "add-reservation";
	}
	
	@PostMapping("addreservation")
	public String addReservation(@Valid Reservation reservationAttr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-reservation";
		}
		
		reservationService.saveReservation(reservationAttr);
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		return "index-reservations";
	}
	
}
