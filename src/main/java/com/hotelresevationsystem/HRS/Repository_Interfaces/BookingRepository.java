package com.hotelresevationsystem.HRS.Repository_Interfaces;

import com.hotelresevationsystem.HRS.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);

    List<Booking> findByRoomId(Long roomId);

}
