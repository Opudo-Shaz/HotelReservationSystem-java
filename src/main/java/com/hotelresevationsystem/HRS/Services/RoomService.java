package com.hotelresevationsystem.HRS.Services;

import com.hotelresevationsystem.HRS.Entity.Room;
import com.hotelresevationsystem.HRS.Repository_Interfaces.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room getRoomById(Long roomId) {
        Optional<Room> roomOptional = roomRepository.findById(roomId);
        return roomOptional.orElse(null);
    }

    public boolean bookRoom(Long roomId, String checkInDate, String checkOutDate, int guests) {
        Optional<Room> roomOptional = roomRepository.findById(roomId);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();


            room.setAvailable(false);

            roomRepository.save(room);

            return true;
        }

        return false;
    }
}
