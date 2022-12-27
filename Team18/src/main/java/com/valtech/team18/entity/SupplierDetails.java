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
	// suppName and suppPassword strings are used to save supplier login
	// credentials
	private String suppName;
	
	private String fromAddress;
	private long suppContactDetails;
	
	private long landLine;

	public long getLandLine() {
		return landLine;
	}

	public void setLandLine(long landLine) {
		this.landLine = landLine;
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

	public SupplierDetails(int suppId, String suppName, String fromAddress,
			long suppContactDetails, long landLine) {
		super();
		this.suppId = suppId;
		this.suppName = suppName;
		this.fromAddress = fromAddress;
		this.suppContactDetails = suppContactDetails;
		this.landLine = landLine;
	}

	public SupplierDetails(String suppName, String fromAddress,
			long suppContactDetails,long landLine) {
		super();
		this.suppName = suppName;
		this.fromAddress = fromAddress;
		this.suppContactDetails = suppContactDetails;
		this.landLine = landLine;
	}

	@Override
	public String toString() {
		return "SupplierDetails [suppId=" + suppId + ", suppName=" + suppName + ", fromAddress=" + fromAddress
				+ ", suppContactDetails=" + suppContactDetails + ", landLine=" + landLine + "]";
	}

	

}