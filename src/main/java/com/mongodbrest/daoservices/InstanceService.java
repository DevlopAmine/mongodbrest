package com.mongodbrest.daoservices;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.mongodbrest.models.Instance;

public interface InstanceService {

	void saveInstance(Map<String, Object> InstanceMap);
	void removeInstance(ObjectId idI);
	ObjectId findInstanceId(String descI);
	List<Instance> findInstancesByCustomerId(ObjectId oId);
}
