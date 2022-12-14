package com.valtech.team18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.repo.OrderDetailsRepo;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class NewOrderServiceImpl implements NewOrderService {
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	@Override
	public OrderDetails saveNew(OrderDetails od){
	  return orderDetailsRepo.save(od);
	 
	}

}
