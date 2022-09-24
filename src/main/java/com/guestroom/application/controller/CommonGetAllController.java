package com.guestroom.application.controller;

import com.guestroom.application.model.entity.HouseOwnerEntity;
import com.guestroom.application.service.CommonGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonGetAllController {
    @Autowired
    private CommonGetAllService commonGetAllService;

    @GetMapping
    public List<HouseOwnerEntity> getRoomDetails(){
        return commonGetAllService.getRoom();
    }
}
