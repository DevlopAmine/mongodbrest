package com.mongodbrest.daoservices;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodbrest.models.Instance;
import com.mongodbrest.repositories.InstanceRepository;

public class InstanceServiceImpl implements InstanceService{

	@Autowired
	  private InstanceRepository instanceRepository;
	@Override
	public void saveInstance(Instance instance) {
		instanceRepository.save(instance);
		
	}

}
