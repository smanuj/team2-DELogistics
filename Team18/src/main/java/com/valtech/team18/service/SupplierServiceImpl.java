package com.valtech.team18.service;

import java.util.ArrayList;
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
	
	@Autowired
	private MailMessage mailMessage;
	
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
		mailMessage.registeredSuccessfully(sd.getEmail(),"Supplier",sd.getSuppName());
		 return supplierDetailsRepo.save(sd);
		
	}


	@Override
	public void deleteRejectedSupplier(int id) {
		SupplierDetails sd=supplierDetailsRepo.findById(id).get();
		supplierDetailsRepo.deleteById(id);
		mailMessage.registerationFailure(sd.getEmail(),"Supplier",sd.getSuppName());
	}


	@Override
	public List<TruckDetails> getTruckDetailsFromOrder(int id) {
//		model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));
		
		 List<OrderDetails> od = getAllOrdersBySuppId(id);
		 List<Integer> driverid = new ArrayList<Integer>();
		 for (OrderDetails orderDetails : od) {
		 driverid.add(orderDetails.getDriverId());
		 }
		
		 List<TruckDetails> td = new ArrayList<TruckDetails>();
		 for (Integer did : driverid) {
		 td.add(truckDetailsRepo.findById(did).get());
		 }
		return td;
	}


	@Override
	public boolean register(String username, String email, String password, String fromAddress, String contactNumber,
			String landLine) {
		// TODO Auto-generated method stub
		long contactNumbe=Long.valueOf(contactNumber);
		long landLin=Long.valueOf(landLine);
//		long landLin1=null;
		boolean set=false;
		SupplierDetails sl=supplierDetailsRepo.findByEmail(email);
		if(sl==null){
		SupplierDetails sd= new SupplierDetails(username,email,password,fromAddress,contactNumbe,set, null, landLin);
		supplierDetailsRepo.save(sd);
		mailMessage.notifyRegisteration(sd.getEmail(),"Supplier",sd.getSuppName());
		return true;
		}
		
		return false;

	}


	


	
	


}
