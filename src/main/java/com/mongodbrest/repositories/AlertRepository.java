package com.mongodbrest.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.mongodbrest.models.Alert;

public interface AlertRepository extends CrudRepository<Alert, String>{

	

}
