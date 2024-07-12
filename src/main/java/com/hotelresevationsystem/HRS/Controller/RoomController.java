package com.hotelresevationsystem.HRS.Controller;

import com.hotelresevationsystem.HRS.Entity.Room;
import com.hotelresevationsystem.HRS.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Endpoint to display all rooms
    @GetMapping
    public String getRooms(Model model) {
        List<Room> rooms = roomService.findAllRooms();
        model.addAttribute("rooms", rooms);
        return "room";
    }

    // Endpoint to display room details
    @GetMapping("/viewroom/{roomId}")
    public String viewRoomDetails(@PathVariable Long roomId, Model model) {
        Room room = roomService.getRoomById(roomId);
        model.addAttribute("room", room);
        return "viewroom";
    }

    @GetMapping("/bookroom/{id}")
    public String bookRoom(@PathVariable("id") Long id, Model model) {
        // Add attributes to the model if needed
        model.addAttribute("roomId", id);
        return "bookroom"; // This should match the name of your Thymeleaf template
    }

}

