package com.hotelresevationsystem.HRS.Services;

import com.hotelresevationsystem.HRS.Entity.Reservation;
import com.hotelresevationsystem.HRS.Repository_Interfaces.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ReservationService {
    @Autowired
    private  ReservationRepository reservationRepository;

    public  List<Reservation> findAll() {
        return reservationRepository.findAll();
    }


    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {

        reservationRepository.deleteById(id);
    }
}
