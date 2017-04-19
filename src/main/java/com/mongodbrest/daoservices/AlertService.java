package com.mongodbrest.daoservices;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodbrest.models.Alert;

public interface AlertService {

//	void saveTwAlert(Alert alert);	
//	void saveFBAlert(Alert alert);
//	void saveGgAlert(Alert alert);
	void deleteAlert(String alertId);
	List<Alert> findAlertsByInstanceId(ObjectId oId);
	boolean issetAlert(String desc);
	//ObjectId findAlertId(String descA);
	void saveGgAlert(Alert alert, String descI);
	void saveTwAlert(Alert alert, String descI);
	void saveFBAlert(Alert alert, String descI);
}
