package com.mongodbrest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mongodbrest.models.Customer;

public interface CustomRepository  extends CrudRepository<Customer, String>{

}
