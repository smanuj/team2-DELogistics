
package com.valtech.team18.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity created to store and retrieve all the order details
@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	private String custName;
	private LocalDateTime time;
	private String toAddress;
	private long phNum;
	private String orderType;
	private int suppId;
	private int driverId;

	public OrderDetails(String custName, LocalDateTime time, String toAddress, long phNum, String orderType, int suppId,
			int driverId) {
		super();
		this.custName = custName;
		this.time = time;
		this.toAddress = toAddress;
		this.phNum = phNum;
		this.orderType = orderType;
		this.suppId = suppId;
		this.driverId = driverId;
	}

	public OrderDetails(int orderId, String custName, LocalDateTime time, String toAddress, long phNum,
			String orderType, int suppId, int driverId) {
		super();
		this.orderId = orderId;
		this.custName = custName;
		this.time = time;
		this.toAddress = toAddress;
		this.phNum = phNum;
		this.orderType = orderType;
		this.suppId = suppId;
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", custName=" + custName + ", time=" + time + ", toAddress="
				+ toAddress + ", phNum=" + phNum + ", orderType=" + orderType + ", suppId=" + suppId + ", driverId="
				+ driverId + "]";
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public OrderDetails() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public long getPhNum() {
		return phNum;
	}

	public void setPhNum(long phNum) {
		this.phNum = phNum;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
