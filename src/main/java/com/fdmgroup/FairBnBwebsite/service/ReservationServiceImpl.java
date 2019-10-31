package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.Reservation;
import com.fdmgroup.FairBnBwebsite.repository.ReservationRespository;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRespository reservationRespository;
	

	@Override
	public Reservation getReservationById(int reservationId) {
		return reservationRespository.findById(reservationId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid Reservation ID: " + reservationId));
	}

	@Override
	public Reservation createReservation() {
		Reservation reservation = new Reservation();
		return reservation;
	}

	@Override
	public Reservation editReservation(Reservation reservation) {
		return reservationRespository.save(reservation);
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRespository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRespository.findAll();
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		reservationRespository.delete(reservation);
		
	}

	@Override
	public void deleteRedervationById(int reservationId) {
		reservationRespository.deleteById(reservationId);
		
	}

}
