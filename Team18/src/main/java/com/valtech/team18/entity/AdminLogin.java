package com.valtech.team18.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity created to store and retrieve all the information related to Admin login
@Entity
public class AdminLogin {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int adminId;
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "adminLogin [adminId=" + adminId + ", username=" + username + ", password=" + password + "]";
	}
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password; 
	}
	public AdminLogin(int adminId, String username, String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
