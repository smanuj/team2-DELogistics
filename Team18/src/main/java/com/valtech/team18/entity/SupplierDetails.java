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
	private String suppPassword;
	private String fromAddress;
	private String suppContactDetails;
	

	public String getSuppPassword() {
		return suppPassword;
	}

	public void setSuppPassword(String suppPassword) {
		this.suppPassword = suppPassword;
	}


	@Override
	public String toString() {
		return "SupplierDetails [suppId=" + suppId + ", fromAddress=" + fromAddress + ", suppName=" + suppName
				+ ", suppPassword=" + suppPassword + ", suppContactDetails=" + suppContactDetails + "]";
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

	public String getSuppContactDetails() {
		return suppContactDetails;
	}

	public void setSuppContactDetails(String suppContactDetails) {
		this.suppContactDetails = suppContactDetails;
	}

	public SupplierDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierDetails(int suppId, String fromAddress, String suppName, String suppPassword,
			String suppContactDetails) {
		super();
		this.suppId = suppId;
		this.fromAddress = fromAddress;
		this.suppName = suppName;
		this.suppPassword = suppPassword;
		this.suppContactDetails = suppContactDetails;
	}
	
	public SupplierDetails( String suppName, String suppPassword, String fromAddress,String suppContactDetails) {
		super();
		this.fromAddress = fromAddress;
		this.suppName = suppName;
		this.suppPassword = suppPassword;
		this.suppContactDetails = suppContactDetails;
	}
}