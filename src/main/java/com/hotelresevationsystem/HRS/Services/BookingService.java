package com.hotelresevationsystem.HRS.Services;

import com.hotelresevationsystem.HRS.Entity.Room;
import com.hotelresevationsystem.HRS.Repository_Interfaces.RoomRepository;
import com.hotelresevationsystem.HRS.Repository_Interfaces.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public boolean bookRoom(Long roomId) {
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            if (room.getIsAvailable()) {
                room.setIsAvailable(false);
                roomRepository.save(room);
                // Save booking details using bookingRepository
                // Assuming you have a Booking entity, create and save a new booking here
                return true;
            }
        }
        return false;
    }
}
