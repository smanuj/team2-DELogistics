package com.valtech.team18.service;

import java.util.List;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;

public interface TruckDetailsService {

	List<OrderDetails> getAllOrderD();

	List<TruckDetails> getAllTruckD();

	List<OrderDetails> getAllOrdersByDriverId(int id);

	
	List<TruckDetails> getApprovedDriver();

	User approvingDriver(int id);

	void deleteRejectedDriver(int id);

	List<SupplierDetails> getSupplierFromOrder(int id);

	boolean register(String username, String password, String email, String contactNumber);

	void deleteTruckDriver(int id);

}