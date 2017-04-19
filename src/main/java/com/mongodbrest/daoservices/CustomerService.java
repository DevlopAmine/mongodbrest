package com.mongodbrest.daoservices;

import java.util.HashMap;
import java.util.List;

import com.mongodbrest.models.Customer;
import com.mongodbrest.models.User;

public interface CustomerService {

	public void createCustomer(HashMap<String, Object> CustomMap);
	public List<User>  findUsersByCustomer(String description);
	
}
