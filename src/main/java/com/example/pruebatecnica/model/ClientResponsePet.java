package com.example.pruebatecnica.model;

import java.util.ArrayList;

public class ClientResponsePet {
	
	private int id;
	private Category category;
	private String name;
	private ArrayList<String> photoUrls;
	private ArrayList<Tag> tags;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(ArrayList<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public ArrayList<Tag> getTags() {
		return tags;
	}
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
