package com.guestroom.application.repository;

import com.guestroom.application.model.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity,String> {
}
