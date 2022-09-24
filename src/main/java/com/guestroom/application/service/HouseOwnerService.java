package com.guestroom.application.service;


import com.guestroom.application.model.entity.BookingEntity;
import com.guestroom.application.model.entity.HouseOwnerEntity;
import com.guestroom.application.repository.BookingRepository;
import com.guestroom.application.repository.HouseOwnerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class HouseOwnerService {

    @Autowired
    private HouseOwnerRepository houseOwnerRepository;


    @Autowired
    private BookingRepository bookingRepository;

    private final Path root = Paths.get("upload");

    /** delete **/

    public String delete(String roomArea) {
        if(houseOwnerRepository.findById(roomArea).isPresent()){
            houseOwnerRepository.deleteById(roomArea);
            return "Deleted Success";
        }
        return "Fail to delete not Account Available";
    }

    /** Update **/

    public String update(String roomArea, HouseOwnerEntity houseOwnerEntity) {
        if(houseOwnerRepository.findById(roomArea).isPresent()){
            HouseOwnerEntity entity = new HouseOwnerEntity();
            BeanUtils.copyProperties(houseOwnerEntity,entity);
            houseOwnerRepository.save(entity);
            return "Updated Successfully";
        }
        return "account not exist";
    }

    /** Save **/

    public HouseOwnerEntity save(HouseOwnerEntity houseOwnerEntity /*, MultipartFile file*/)  {

        //Below Command is a Location is URL based on the Host System setting .....

        //** file.transferTo(new File("Location" + file.getOriginalFilename())); **//

        // Set the photo link .....
        houseOwnerEntity.setPhotoLink("Location" /*+ file.getOriginalFilename()*/);
        houseOwnerRepository.save(houseOwnerEntity);
        return houseOwnerEntity;
    }

    /** Get the Booking Room  Details**/
    public BookingEntity findById(String roomName) {
        if(bookingRepository.findById(roomName).isPresent()){
            BookingEntity entity;
            entity = bookingRepository.findById(roomName).get();
            return entity;
        }
        return null;
    }

    /** Get All House Owner Details**/
    public HouseOwnerEntity findByHouseDetails(String roomName) {
        if(houseOwnerRepository.existsById(roomName)){
            HouseOwnerEntity entity;
            entity =houseOwnerRepository.findById(roomName).get();
            return entity;
        }
        return null;
    }

    public String dailyUpdate(String roomName) {
        if(bookingRepository.existsById(roomName)){
            BookingEntity bookingEntity = bookingRepository.findById(roomName).get();
            if(bookingEntity.getPeriodOfDate()>0){
                bookingEntity.setPeriodOfDate(bookingEntity.getPeriodOfDate()-1);
                bookingRepository.save(bookingEntity);
                return "Daily Update Successfully , Remaining Period Days " + bookingEntity.getPeriodOfDate();
            }
            else if(bookingEntity.getPeriodOfDate()==0){
                HouseOwnerEntity entity = houseOwnerRepository.findById(roomName).get();
                BookingEntity bookingEntityNew =bookingRepository.findById(roomName).get();
                entity.setNoOfRooms(entity.getNoOfRooms() + bookingEntityNew.getBookedNoOfRoom());
                houseOwnerRepository.save(entity);
                bookingRepository.deleteById(roomName);
                return "Deleted the room Record Successfully , Because the time of the period is completed...... , Guest Room Count Updated.......:)";
            }
        }
        return "Wrong Room Name Check the Room Name ...... :)";

    }
}


