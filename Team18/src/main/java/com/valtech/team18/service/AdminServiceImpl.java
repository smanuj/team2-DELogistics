package com.valtech.team18.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService {
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	@Autowired
	private TruckDetailsRepo truckDetailsRepo;
	
	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;
	
	@Autowired
	private MailMessage mailMessage;
	
	@Override
	public List<OrderDetails> getAllOrderD(){
		return orderDetailsRepo.findAll();
	}

	@Override
	public List<TruckDetails> getAllTruckD(){
		return truckDetailsRepo.findAll();
	}

	@Override
	public List<SupplierDetails> getAllSuppplierD(){
		return supplierDetailsRepo.findAll();
	}
	
	@Override
	public void sendAlertMail(int tId){
		TruckDetails td=truckDetailsRepo.findByTruckId(tId);
		mailMessage.sendAlert(td.getEmail());
	}
	
}
