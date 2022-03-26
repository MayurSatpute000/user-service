package com.edusol.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER_TABLE")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String city;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + "]";
	}
	
	
	
	
}

















