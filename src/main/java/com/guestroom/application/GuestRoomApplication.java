package com.guestroom.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.guestroom.application.repository")
public class GuestRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestRoomApplication.class, args);
	}

}
