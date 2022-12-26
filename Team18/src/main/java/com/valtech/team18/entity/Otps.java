package com.valtech.team18.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Otps {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int otpId;
	private int otp;

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Otps(int otpId, int otp) {
		super();
		this.otpId = otpId;
		this.otp = otp;
	}

	public Otps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Otps(int otp) {
		super();
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Otps [otpId=" + otpId + ", otp=" + otp + "]";
	}
}
