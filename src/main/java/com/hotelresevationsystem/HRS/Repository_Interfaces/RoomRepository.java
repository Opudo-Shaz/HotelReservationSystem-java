package com.hotelresevationsystem.HRS.Repository_Interfaces;

import com.hotelresevationsystem.HRS.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {
}

