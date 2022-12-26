package com.valtech.team18.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String email;
	private String password;
	@OneToOne(targetEntity = SupplierDetails.class)
	@JoinColumn(name = "suppId", referencedColumnName = "suppId")
	private String suppId;
	@OneToOne(targetEntity = TruckDetails.class)
	@JoinColumn(name = "driverId", referencedColumnName = "truckId")
	private String driverId;
	private boolean approval;
	@OneToOne(targetEntity = Otps.class)
	@JoinColumn(name = "otpId", referencedColumnName = "otpId")
	private int otpId;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String password, String suppId, String driverId, boolean approval,
			Set<Role> roles, int otpId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.suppId = suppId;
		this.driverId = driverId;
		this.approval = false;
		this.roles = roles;
		this.otpId = otpId;
	}

	public User(String email, String password, String suppId, String driverId, boolean approval, Set<Role> roles,
			int otpId) {
		super();
		this.email = email;
		this.password = password;
		this.suppId = suppId;
		this.driverId = driverId;
		this.approval = false;
		this.roles = roles;
		this.otpId = otpId;
	}

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuppId() {
		return suppId;
	}

	public void setSuppId(String suppId) {
		this.suppId = suppId;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public boolean getApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", suppId=" + suppId + ", driverId="
				+ driverId + ", approval=" + approval + ", otpId=" + otpId + ", roles=" + roles + "]";
	}

}
