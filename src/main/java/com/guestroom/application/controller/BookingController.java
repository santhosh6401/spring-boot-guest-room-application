package com.guestroom.application.controller;

import com.guestroom.application.model.entity.BookingEntity;
import com.guestroom.application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/register")
    public String registration(@RequestParam  String bookRoomName,
                               @RequestParam String customerName,
                               @RequestParam int bookedNoOfRoom,
                               int periodDate){
        return  bookingService.save(bookRoomName,customerName,bookedNoOfRoom,periodDate);
    }
}
