package com.mongodbrest.daoservices;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodbrest.models.Alert;

public interface AlertService {

	void saveTwAlert(Alert alert);
	void deleteAlert(String alertId);
	List<Alert> findAlertsByInstanceId(ObjectId oId);
	void saveFBAlert(Alert alert);
}
