package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class student {
	@Id
	private int id;
	private String name;
	private String dept;
	@Transient
	private String ranks;

	
	public student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
