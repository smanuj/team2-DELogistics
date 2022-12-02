package com.valtech.team18.service;

import com.valtech.team18.entity.PendingSupplier;
import com.valtech.team18.entity.SupplierDetails;

public interface SupplierLoginService {


	boolean loginvalidation(String username, String password);
	
	SupplierDetails saveNew(PendingSupplier ps);

}