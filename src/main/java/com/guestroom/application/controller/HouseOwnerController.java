package com.guestroom.application.controller;

import com.guestroom.application.model.entity.BookingEntity;
import com.guestroom.application.model.entity.HouseOwnerEntity;
import com.guestroom.application.service.HouseOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/house-owner")
public class HouseOwnerController {
    @Autowired
    private HouseOwnerService houseOwnerService;

    @PostMapping("/create")
    public HouseOwnerEntity create(@RequestBody HouseOwnerEntity houseOwnerEntity
                                   /*@RequestPart("upload photo") MultipartFile file*/){
        return houseOwnerService.save(houseOwnerEntity);
        /*return houseOwnerService.save(houseOwnerEntity,file);*/
    }

    @PutMapping("/edit/{roomArea}")
    public String update(@PathVariable("roomArea") String roomArea, @RequestBody HouseOwnerEntity houseOwnerEntity) {
        return houseOwnerService.update(roomArea,houseOwnerEntity);
    }

    @DeleteMapping("/delete/{roomArea}")
    public String delete(@PathVariable("roomArea") String roomArea) {
        return houseOwnerService.delete(roomArea);
    }

    @GetMapping("/get-room/{roomName}")
    public HouseOwnerEntity findByHouseDetails(String roomName) {
        return houseOwnerService.findByHouseDetails(roomName);
    }

    @GetMapping("/get-booked/{roomName}")
    public BookingEntity findByCustomerDetails(@PathVariable String roomName){
        return houseOwnerService.findById(roomName);
    }

    @PutMapping("/re-set/{roomName}")
    public String dailyResetTheRoom(String roomName){
        return houseOwnerService.dailyUpdate(roomName);
    }

}
