package com.guestroom.application.service;

import com.guestroom.application.model.entity.BookingEntity;
import com.guestroom.application.model.entity.CustomerEntity;
import com.guestroom.application.model.entity.HouseOwnerEntity;
import com.guestroom.application.repository.BookingRepository;
import com.guestroom.application.repository.CustomerRepository;
import com.guestroom.application.repository.HouseOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private HouseOwnerRepository houseOwnerRepository;


    public String save(String bookRoomName,String customerName, int bookedNoOfRoom, int periodDate) {
        BookingEntity entity = new BookingEntity();
        CustomerEntity customerEntity = customerRepository.findById(customerName).get();
        HouseOwnerEntity houseOwnerEntity = houseOwnerRepository.findById(bookRoomName).get();
        //Booking Entity ......
        entity.setBookedRoomName(bookRoomName);
        entity.setCustomerName(customerName);
        entity.setBookedRoomOwnerName(houseOwnerEntity.getFirstName()+" "+houseOwnerEntity.getLastName());

        // No of Room Condition...
        if(houseOwnerEntity.getNoOfRooms()>bookedNoOfRoom){
            entity.setBookedNoOfRoom(bookedNoOfRoom);
        }
        else{
            return "Rooms Not Available";
        }


        entity.setBookingDate(LocalDateTime.now());
        entity.setPeriodOfDate(periodDate);

        //Period of Time ......
        if((houseOwnerEntity.getMinimumPeriod() <= periodDate) && (houseOwnerEntity.getMaximumPeriod() >= periodDate)){
            entity.setAmount(houseOwnerEntity.getAmountPerDay()*bookedNoOfRoom*periodDate);
        }
        else{
            return "Period of date Not Valid";
        }

        entity.setCustomerMobile(customerEntity.getMobileNumber());
        entity.setCustomerEmail(customerEntity.getEmail());
        bookingRepository.save(entity);

        //House Owner Entity ......
        houseOwnerEntity.setNoOfRooms(houseOwnerEntity.getNoOfRooms()-bookedNoOfRoom);
        houseOwnerRepository.save(houseOwnerEntity);


        return entity.toString();
    }


}
