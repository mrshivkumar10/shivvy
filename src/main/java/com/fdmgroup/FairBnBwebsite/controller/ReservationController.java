package com.fdmgroup.FairBnBwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/editreservation/{id}")
	public String reservationUpdateForm(@PathVariable("id") int reservationId, Model model) {
		Reservation reservation = reservationService.getReservationById(reservationId);
		model.addAttribute("reservationAttr", reservation);
		return "update-reservation";

	}

	@PostMapping("/updatereservation/{id}")
	public String updateReservation(@PathVariable("id") int reservationId,
			@Valid Reservation reservation, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "update-reservation";
		}
		reservation.setReservationId(reservationId);
		reservationService.editReservation(reservation);
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		return "index-reservations";
	}
	
	
	@GetMapping("/deletereservation/{id}")
	public String deleteReservation(@PathVariable("id") int reservationId, Model model) {
		reservationService.deleteRedervationById(reservationId);
		model.addAttribute("reservationAttr", reservationService.getAllReservations());
		return "index-reservations";
	}

}
