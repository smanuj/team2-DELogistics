package com.valtech.team18.service;

import java.util.List;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;

public interface SupplierService {

	List<TruckDetails> getAllTruckD();

	List<SupplierDetails> getAllSuppplierD();
	
	List<OrderDetails> getAllOrdersBySuppId(int suppId);
	
	List<Integer> getAllDriverIdFromOrderDetails(OrderDetails od);

}