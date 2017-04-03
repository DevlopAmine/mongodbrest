package com.mongodbrest.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tree {

	@Id
	private String id;

	private String name;

	private String category;

	private int age;

	private List<String> formList;
	
	 @DBRef
	private List<String> heightL;
	
	public Tree(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getFormList() {
		return formList;
	}

	public void setFormList(List<String> formList) {
		this.formList = formList;
	}
	

	public List<String> getHeightL() {
		return heightL;
	}

	public void setHeightL(List<String> heightL) {
		this.heightL = heightL;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", name=" + name + ", age=" + age
			+ ", category=" + category + "]";
	}	
}
