package com.mongodbrest.daoservices;

import org.bson.types.ObjectId;

import com.mongodbrest.models.Instance;

public interface InstanceService {

	void saveInstance(Instance instance);
	void removeInstance(ObjectId idI);
}
