package com.hotelresevationsystem.HRS.Repository_Interfaces;
import com.hotelresevationsystem.HRS.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
