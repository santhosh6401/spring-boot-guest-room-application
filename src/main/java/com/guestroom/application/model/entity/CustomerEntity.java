package com.guestroom.application.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customer")
public class CustomerEntity {
    @Id
    private String customerName;

    private String email;

    private String mobileNumber;

    private String customerDescription;


}
