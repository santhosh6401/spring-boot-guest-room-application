package com.guestroom.application.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection = "guest_room")
public class HouseOwnerEntity {
    @Id
    private String roomName;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;

    private String roomArea;

    private int noOfRooms;

    private String roomDescription;

    private int minimumPeriod;

    private int maximumPeriod;

    private int amountPerDay;

    private String photoLink;
}
