package com.mongodbrest.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodbrest.repositories.CascadeSave;

@Document(collection="alert")
public class Alert {

	@Id
	private ObjectId id;
	
	private String descA;
	
	@Field(value="instance")
	@DBRef
	private Instance instance;
	
	private List<AlertSource> alertsources;
	
	public Alert(){}
	
	public Alert(ObjectId id,String desc)
	{
		this.id=id;
		this.descA= desc;
	}

	
	public Instance getInstance() {
		return instance;
	}
	public void setInstance(Instance instance) {
		this.instance = instance;
	}
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getDescA() {
		return descA;
	}

	public void setDescA(String descA) {
		this.descA = descA;
	}

	public List<AlertSource> getAlertsources() {
		return alertsources;
	}

	public void setAlertsources(List<AlertSource> alertsources) {
		this.alertsources = alertsources;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id+ ", descA=" + descA + "]";
	}
	
	
	
	
	
}
