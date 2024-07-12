package com.hotelresevationsystem.HRS.Controller;

import com.hotelresevationsystem.HRS.Entity.Room;
import com.hotelresevationsystem.HRS.Services.RoomService;
import com.hotelresevationsystem.HRS.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public String viewRooms(Model model) {
        return "login";
    }

    @GetMapping("/reservation2")
    public String viewReservations() {
        return "reservation";
    }

    @GetMapping("/signup")
    public String viewSignup() {
        return "signup";
    }

    @GetMapping("/viewroom/{roomId}")
    public String viewRoomDetails(@PathVariable Long roomId, Model model) {
        Room room = roomService.getRoomById(roomId);
        model.addAttribute("room", room);
        return "viewroom";
    }


    @GetMapping("/bookroom/{id}")
    public String showBookRoom(@PathVariable("id") Long id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "bookroom";
    }
    @PostMapping("/room/book")
    public String bookRoom(@RequestParam Long roomId,
                           @RequestParam String checkInDate,
                           @RequestParam String checkOutDate,
                           @RequestParam int guests,
                           Model model) {
        // Process the booking
        boolean isBooked = roomService.bookRoom(roomId, checkInDate, checkOutDate, guests);

        if (isBooked) {
            model.addAttribute("message", "Room booked successfully!");
            return "booking-success";
        } else {
            model.addAttribute("message", "Failed to book the room. Please try again.");
            return "booking-failure";
        }
    }
}
