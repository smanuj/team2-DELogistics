package com.valtech.team18.service;

//import com.valtech.team18.entity.PendingSupplier;
//import com.valtech.team18.entity.SupplierDetails;

public interface SupplierLoginService {

	boolean loginvalidation(String username, String password);

	int getIdFromEmail(String email);

	boolean generateOtp(String email);

	boolean checkOTP(int id, String otp);

	void changePassword(int id, String password);

	// SupplierDetails saveNew(PendingSupplier ps);

}