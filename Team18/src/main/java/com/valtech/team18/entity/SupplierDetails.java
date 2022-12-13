package com.valtech.team18.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity created to save and retrieve all the information related to supplier
@Entity
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int suppId;
	//suppName and suppPassword strings are used to save supplier login credentials
	private String suppName;
	private String email;
	private String suppPassword;
	private String fromAddress;
	private long suppContactDetails;
	private boolean approved;
	private String otp;
	
	

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getSuppPassword() {
		return suppPassword;
	}

	public void setSuppPassword(String suppPassword) {
		this.suppPassword = suppPassword;
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

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public Long getSuppContactDetails() {
		return suppContactDetails;
	}

	public void setSuppContactDetails(long suppContactDetails) {
		this.suppContactDetails = suppContactDetails;
	}

	public SupplierDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public SupplierDetails(int suppId, String suppName, String email, String suppPassword, String fromAddress,
			long suppContactDetails, boolean approved) {
		super();
		this.suppId = suppId;
		this.suppName = suppName;
		this.email = email;
		this.suppPassword = suppPassword;
		this.fromAddress = fromAddress;
		this.suppContactDetails = suppContactDetails;
		this.approved = approved;
		
	}
//
//	public SupplierDetails( String suppName, String suppPassword, String fromAddress,String suppContactDetails) {
//		super();
//		this.fromAddress = fromAddress;
//		this.suppName = suppName;
//		this.suppPassword = suppPassword;
//		this.suppContactDetails = suppContactDetails;
//	}

	public SupplierDetails(String suppName, String email, String suppPassword, String fromAddress,
			long suppContactDetails, boolean approved) {
		super();
		this.suppName = suppName;
		this.email = email;
		this.suppPassword = suppPassword;
		this.fromAddress = fromAddress;
		this.suppContactDetails = suppContactDetails;
		this.approved = approved;
		
	}

	@Override
	public String toString() {
		return "SupplierDetails [suppId=" + suppId + ", suppName=" + suppName + ", email=" + email + ", suppPassword="
				+ suppPassword + ", fromAddress=" + fromAddress + ", suppContactDetails=" + suppContactDetails
				+ ", approved=" + approved +"]";
	}
	
	
}