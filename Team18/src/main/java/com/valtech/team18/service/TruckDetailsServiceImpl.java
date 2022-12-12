package com.valtech.team18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation =Propagation.SUPPORTS)
public class TruckDetailsServiceImpl implements TruckDetailsService {
	
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	@Autowired
	private TruckDetailsRepo truckDetailsRepo;
	
	@Override
	public List<OrderDetails> getAllOrderD(){
		return orderDetailsRepo.findAll();
	}

	@Override
	public List<TruckDetails> getAllTruckD(){
		return truckDetailsRepo.findAll();
	}

	@Override
	public List<OrderDetails> getAllOrdersByDriverId(int truckId) {
		return orderDetailsRepo.getAllOrdersByDriverId(truckId);
	}

	@Override
	public List<TruckDetails> getPendingDriver(){
		return truckDetailsRepo.findAllByApprovedFalse();
	}

	@Override
	public List<TruckDetails> getApprovedDriver() {
		return truckDetailsRepo.findAllByApprovedTrue();
	}

	@Override
	public TruckDetails approvingDriver(int id) {
		TruckDetails td=truckDetailsRepo.findById(id).get();
		td.setApproved(true);
		return truckDetailsRepo.save(td);
	}

	@Override
	public void deleteRejectedDriver(int id) {
		truckDetailsRepo.deleteById(id);
		
	}
	
}
