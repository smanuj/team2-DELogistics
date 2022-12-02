package com.valtech.team18.service;

import java.util.List;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;

public interface AdminService {
	
	// Get all order details in a list
	List<OrderDetails> getAllOrderD();

	// Get all Truck details in a list
	List<TruckDetails> getAllTruckD();

	// Get all Supplier details in a list
	List<SupplierDetails> getAllSuppplierD();

}