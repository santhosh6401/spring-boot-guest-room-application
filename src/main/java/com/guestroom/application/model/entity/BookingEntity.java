package com.guestroom.application.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "booking")
public class BookingEntity {

    //must
    @Id
    private String bookedRoomName;

    //must
    private String customerName;

    private String bookedRoomOwnerName;

    //must
    private int bookedNoOfRoom;

    private LocalDateTime bookingDate;

    // must
    private int periodOfDate;

    private int amount;

    private String customerMobile;

    private String customerEmail;


}
