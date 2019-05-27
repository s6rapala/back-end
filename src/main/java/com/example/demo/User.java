package com.example.demo;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@javax.persistence.Id
	@GeneratedValue
	@Column(name = "ID")
	public String Id;
	
	@Column(name = "UserName")
	public String userName;
	
	@Column(name="Password")
	public String password;	
	
	public String getId() {
		return Id;
	}
	
	public User() {
		
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
