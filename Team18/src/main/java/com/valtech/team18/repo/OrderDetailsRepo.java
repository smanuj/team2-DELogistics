package com.valtech.team18.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.OrderDetails;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

	// Retrieve a list of all orders assigned to that supplier
	List<OrderDetails> getAllOrdersBySuppId(int suppId);

	// Retrieve a list of all orders assigned to that driver
	List<OrderDetails> getAllOrdersByDriverId(int driverId);

	// Retrieve a list of driver ids related to that supplier id
	List<Integer> getDriverIdBySuppId(int suppId);
	
	void deleteByCustName(String name);
	
	void deleteByOrderId(int id);
}
