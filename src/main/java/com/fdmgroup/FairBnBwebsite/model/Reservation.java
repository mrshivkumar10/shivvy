package com.fdmgroup.FairBnBwebsite.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation {
	
//	@OneToMany(mappedBy="gameGenre")
//	private List <Videogame> videogames;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reservation_id", unique = true, nullable = false)
	private int reservationId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "property_id")
	private Property reservationProperty;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customerReservation;
	
	@Column(name="check_in_date")
	private LocalDate checkInDate;
	
	@Column(name="check_out_date")
	private LocalDate checkOutDate;
	
	//default constructor
	public Reservation() {
	}
	
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	
	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Customer getCustomerReservation() {
		return customerReservation;
	}

	public void setCustomerReservation(Customer customerReservation) {
		this.customerReservation = customerReservation;
	}

	public Property getReservationProperty() {
		return reservationProperty;
	}

	public void setReservationProperty(Property reservationProperty) {
		this.reservationProperty = reservationProperty;
	}

}
