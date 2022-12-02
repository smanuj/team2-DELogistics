package com.valtech.team18.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity created to store and retrieve the credentials of driver after registration , this information will be moved to TruckDetails if admin approves it
@Entity
public class PendingDriver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private long driverNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PendingDriver [id=" + id + ", username=" + username + ", password=" + password + ", driverNumber="
				+ driverNumber + "]";
	}

	public PendingDriver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PendingDriver(int id, String username, String password, long driverNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.driverNumber = driverNumber;
	}

	public PendingDriver(String username, String password, long driverNumber) {
		super();
		this.username = username;
		this.password = password;
		this.driverNumber = driverNumber;
	}

	public long getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(long driverNumber) {
		this.driverNumber = driverNumber;
	}

}
