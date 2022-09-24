package com.guestroom.application.service;

import com.guestroom.application.model.entity.HouseOwnerEntity;
import com.guestroom.application.repository.HouseOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonGetAllService {

    @Autowired
    private HouseOwnerRepository houseOwnerRepository;

    public List<HouseOwnerEntity> getRoom() {
        List<HouseOwnerEntity> entityList;
        entityList = houseOwnerRepository.findAll();
        return entityList;
    }
}
