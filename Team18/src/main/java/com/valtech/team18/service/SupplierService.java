package com.valtech.team18.service;

import java.util.List;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;

public interface SupplierService {

	List<TruckDetails> getAllTruckD();

	List<SupplierDetails> getAllSuppplierD();

	List<OrderDetails> getAllOrdersBySuppId(int suppId);

	List<Integer> getAllDriverIdFromOrderDetails(OrderDetails od);



	List<SupplierDetails> getApprovedSupplier();

	User approvingSupplier(int id);

	void deleteRejectedSupplier(int id);

	List<TruckDetails> getTruckDetailsFromOrder(int id);

	boolean register(String username, String email, String password, String fromAddress, String contactNumber,
			String landLine);

	void deleteSupplier(int id);

}