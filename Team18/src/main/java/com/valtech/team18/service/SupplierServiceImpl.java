package com.valtech.team18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation =Propagation.SUPPORTS)
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;
	
	
	@Autowired
	private TruckDetailsRepo truckDetailsRepo;
	
	
	@Override
	public List<TruckDetails> getAllTruckD(){
		return truckDetailsRepo.findAll();
	}

	
	@Override
	public List<SupplierDetails> getAllSuppplierD(){
		return supplierDetailsRepo.findAll();
	}
	
	@Override
	public List<OrderDetails> getAllOrdersBySuppId(int suppId){
		return orderDetailsRepo.getAllOrdersBySuppId(suppId);
	}

	@Override
	public List<Integer> getAllDriverIdFromOrderDetails(OrderDetails od){
		return orderDetailsRepo.getDriverIdBySuppId(od.getSuppId());
	}


	@Override
	public List<SupplierDetails> getPendingSupplier() {
		return supplierDetailsRepo.findAllByApprovedFalse();
	}


	@Override
	public List<SupplierDetails> getApprovedSupplier() {
		return supplierDetailsRepo.findAllByApprovedTrue();
	}


	@Override
	public SupplierDetails approvingSupplier(int id) {
//		TruckDetails td=truckDetailsRepo.findById(id).get();
//		td.setApproved(true);
		
		SupplierDetails sd=supplierDetailsRepo.findById(id).get();
		sd.setApproved(true);
		
		 return supplierDetailsRepo.save(sd);
		
	}


	@Override
	public void deleteRejectedSupplier(int id) {
		supplierDetailsRepo.deleteById(id);
	}


	
	


}
