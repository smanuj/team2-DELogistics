package com.valtech.team18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.valtech.team18.entity.PendingSupplier;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.repo.SupplierDetailsRepo;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class SupplierLoginServiceImpl implements SupplierLoginService {
	
	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;

	//Login Validation by checking given username and password in the database
	@Override
	public boolean loginvalidation(String email,String password) throws NullPointerException{
		
		try{
		SupplierDetails sup=supplierDetailsRepo.findBySuppName(email);
		
		if((email.equals(sup.getEmail())) && (password.equals(sup.getSuppPassword()))){
			return true;
		}
		
		return false;
		}
		
		catch(NullPointerException n){
			return false;
		}
		
		
	}

	@Override
	public int getIdFromEmail(String email){
		return supplierDetailsRepo.findByEmail(email).getSuppId();
	}
	
	

//	// Save new supplier details
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public SupplierDetails saveNew(PendingSupplier ps){
//		String username=ps.getUsername();
//		String password=ps.getPassword();
//		String fromAdd=ps.getFromAddress();
//		String suppConDe=ps.getSuppContactDetails();
//		SupplierDetails sl=new SupplierDetails(username, password,fromAdd,suppConDe);
//		 return supplierDetailsRepo.save(sl);
//	}
	
}
