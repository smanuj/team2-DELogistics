package com.valtech.team18.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Otps {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Id @GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private int otpId;
	private String otp;

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Otps(int otpId, String otp) {
		super();
		this.otpId = otpId;
		this.otp = otp;
	}

	public Otps() {
		super();
	}

	public Otps(String otp) {
		super();
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Otps [otpId=" + otpId + ", otp=" + otp + "]";
	}
}
