package com.guestroom.application.repository;

import com.guestroom.application.model.entity.HouseOwnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseOwnerRepository extends MongoRepository<HouseOwnerEntity,String> {
}
