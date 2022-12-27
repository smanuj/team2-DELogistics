package com.valtech.team18.service;

//import com.valtech.team18.entity.PendingDriver;
//import com.valtech.team18.entity.TruckDetails;

public interface TruckLoginService {

	boolean loginvalidation(String username, String password) throws NullPointerException;

	int getIdFromEmail(String email);

	boolean generateOtp(String email);

	boolean checkOTP(int id, String otp);

	void changePassword(int id, String password);

}