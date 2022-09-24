package com.guestroom.application.repository;

import com.guestroom.application.model.entity.BookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends MongoRepository<BookingEntity,String> {


}
