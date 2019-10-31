package com.fdmgroup.FairBnBwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdmgroup.FairBnBwebsite.model.Reservation;

@Repository
public interface ReservationRespository extends JpaRepository<Reservation, Integer>{
}
