//package com.valtech.team18.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
////Entity created to store and retrieve the credentials of Supplier after registration , this information will be moved to SupplierDetails if admin approves it
//@Entity
//public class PendingSupplier {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	private String username;
//	private String password;
//	private String fromAddress;
//	private String suppContactDetails;
//
//	public String getFromAddress() {
//		return fromAddress;
//	}
//
//	public void setFromAddress(String fromAddress) {
//		this.fromAddress = fromAddress;
//	}
//
//	public String getSuppContactDetails() {
//		return suppContactDetails;
//	}
//
//	public void setSuppContactDetails(String suppContactDetails) {
//		this.suppContactDetails = suppContactDetails;
//	}
//
//	public PendingSupplier(String username, String password, String fromAddress, String suppContactDetails) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.fromAddress = fromAddress;
//		this.suppContactDetails = suppContactDetails;
//	}
//
//	public PendingSupplier(int id, String username, String password, String fromAddress, String suppContactDetails) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.fromAddress = fromAddress;
//		this.suppContactDetails = suppContactDetails;
//	}
//
//	@Override
//	public String toString() {
//		return "PendingSupplier [id=" + id + ", username=" + username + ", password=" + password + ", fromAddress="
//				+ fromAddress + ", suppContactDetails=" + suppContactDetails + "]";
//	}
//
//	public PendingSupplier() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//}
