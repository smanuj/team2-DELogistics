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
	@JoinColumn(name = "supp_Id", referencedColumnName = "suppId")
	private SupplierDetails suppId;
	@OneToOne(targetEntity = TruckDetails.class)
	@JoinColumn(name = "truck_Id", referencedColumnName = "truckId")
	private TruckDetails truckId;
	private boolean approval;
	@OneToOne(targetEntity = Otps.class)
	@JoinColumn(name = "otpId", referencedColumnName = "otpId")
	private Otps otpId;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	private Set<Role> roles = new HashSet<Role>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String password, SupplierDetails suppId, TruckDetails truckId, boolean approval,
			Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.suppId = suppId;
		this.truckId = truckId;
		this.approval = approval;
		this.roles = roles;
	}

	public User(String email, String password, SupplierDetails suppId) {
		this.email = email;
		this.password = password;
		this.suppId = suppId;
		this.approval = false;
	}

	public User(String email, String password, TruckDetails truckId) {
		this.email = email;
		this.password = password;
		this.truckId = truckId;
		this.approval = false;
	}

	public User(String email, String password, SupplierDetails suppId, TruckDetails truckId, boolean approval,
			Set<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.suppId = suppId;
		this.truckId = truckId;
		this.approval = approval;
		this.roles = roles;
	}

	public Otps getOtpId() {
		return otpId;
	}

	public User(String email, String password, boolean approval, Set<Role> roles) {
		this.email = email;
		this.password = password;
		this.approval = approval;
		this.roles = roles;
	}

	public void setOtpId(Otps otpId) {
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

	public SupplierDetails getSuppId() {
		return suppId;
	}

	public void setSuppId(SupplierDetails suppId) {
		this.suppId = suppId;
	}

	public TruckDetails getTruckId() {
		return truckId;
	}

	public void setTruckId(TruckDetails truckId) {
		this.truckId = truckId;
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
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", suppId=" + suppId + ", truckId="
				+ truckId + ", approval=" + approval + ", otpId=" + otpId + ", roles=" + roles + "]";
	}

}
