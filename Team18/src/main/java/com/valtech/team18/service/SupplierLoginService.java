package com.valtech.team18.service;

//import com.valtech.team18.entity.PendingSupplier;
//import com.valtech.team18.entity.SupplierDetails;

public interface SupplierLoginService {


	boolean loginvalidation(String username, String password);
	
	int getIdFromEmail(String email);
	
//	SupplierDetails saveNew(PendingSupplier ps);

}