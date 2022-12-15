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
	// driverName and driverPassword strings are used to save driver login
	// credentials
	private String driverName;
	private String driverPassword;
	private long driverPhNum;
	private double temp;
	private String email;
	private boolean approved;
	private String otp;


	public TruckDetails() {
		super();
	}

	public TruckDetails(String driverName, String driverPassword, long driverPhNum, double temp, String email,
			boolean approved, String otp) {
		super();
		this.driverName = driverName;
		this.driverPassword = driverPassword;
		this.driverPhNum = driverPhNum;
		this.temp = temp;
		this.email = email;
		this.approved = approved;
		this.otp = otp;
	}

	public TruckDetails(int truckId, String driverName, String driverPassword, long driverPhNum, double temp,
			String email, boolean approved, boolean pending) {
		super();
		this.truckId = truckId;
		this.driverName = driverName;
		this.driverPassword = driverPassword;
		this.driverPhNum = driverPhNum;
		this.temp = temp;
		this.email = email;
		this.approved = approved;

	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
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

	public String getDriverPassword() {
		return driverPassword;
	}

	public void setDriverPassword(String driverPassword) {
		this.driverPassword = driverPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "TruckDetails [truckId=" + truckId + ", driverName=" + driverName + ", driverPassword=" + driverPassword
				+ ", driverPhNum=" + driverPhNum + ", temp=" + temp + ", email=" + email + ", approved=" + approved
				+ "]";
	}

}
