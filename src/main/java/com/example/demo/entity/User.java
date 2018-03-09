package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="USERS")
@Entity
public class User implements Serializable{
	
	public User() {
		
	}
	
	public User(long id, String first_name, String last_name, String email, String password) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

	@GeneratedValue
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="FIRST_NAME")
	private String first_name;
	
	@Column(name="LAST_NAME")
	private String last_name;
	
	@Column(name="EMAIL", unique=true)
	private String email;
	
	@Column(name="PASSWORD")
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
