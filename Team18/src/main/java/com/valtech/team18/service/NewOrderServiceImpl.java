package com.valtech.team18.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.controller.AdminController;
import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.repo.OrderDetailsRepo;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class NewOrderServiceImpl implements NewOrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(NewOrderServiceImpl.class);
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	@Override
	public OrderDetails saveNew(OrderDetails od){
		logger.info("Loading New Order Details....");
		logger.debug("Successfully Received New Order Details! " + orderDetailsRepo.save(od));
	  return orderDetailsRepo.save(od);
	 
	}
	
	@Override
	public void deleteOrder(int id){
		logger.info("Deleting Order " + id);
		orderDetailsRepo.deleteByOrderId(id);
		logger.debug("Deleting Order " + id);
		
	}

}
