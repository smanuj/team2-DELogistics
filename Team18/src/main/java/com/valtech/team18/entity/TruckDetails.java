package com.valtech.team18.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity created to save and retrieve all the information related to truck driver
@Entity
public class TruckDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int truckId;
	//driverName and driverPassword strings are used to save driver login credentials
	private String driverName;
	private String driverPassword;
	private long driverPhNum;
	private double temp;

	public TruckDetails() {
		super();
	}

	
	public String getDriverPassword() {
		return driverPassword;
	}

	public void setDriverPassword(String driverPassword) {
		this.driverPassword = driverPassword;
	}

	@Override
	public String toString() {
		return "TruckDetails [truckId=" + truckId + ", driverName=" + driverName + ", driverPassword=" + driverPassword
				+ ", driverPhNum=" + driverPhNum + ", temp=" + temp + "]";
	}

	
	public TruckDetails(String driverName, String driverPassword, long driverPhNum) {
		super();
		this.driverName = driverName;
		this.driverPassword = driverPassword;
		this.driverPhNum = driverPhNum;
	}


	public TruckDetails(String driverName, String driverPassword, long driverPhNum, double temp) {
		super();
		this.driverName = driverName;
		this.driverPassword = driverPassword;
		this.driverPhNum = driverPhNum;
		this.temp = temp;
	}

	public TruckDetails(int truckId, String driverName, String driverPassword, long driverPhNum, double temp) {
		super();
		this.truckId = truckId;
		this.driverName = driverName;
		this.driverPassword = driverPassword;
		this.driverPhNum = driverPhNum;
		this.temp = temp;
	}


	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public long getDriverPhNum() {
		return driverPhNum;
	}

	public void setDriverPhNum(long driverPhNum) {
		this.driverPhNum = driverPhNum;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

}
