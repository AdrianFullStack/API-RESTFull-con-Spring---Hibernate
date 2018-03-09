package com.example.demo.model;

import com.example.demo.entity.User;

public class UserModel {
	
	public UserModel() {
		
	}
	
	public UserModel(User user) {
		this.id = user.getId();
		this.first_name = user.getFirst_name();
		this.last_name = user.getLast_name();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
	
	public UserModel(long id, String first_name, String last_name, String email, String password) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

	private long id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
