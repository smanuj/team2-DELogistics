package com.valtech.team18.service;

public interface MailMessage {

	void sendAlert(String email);

	void registeredSuccessfully(String email,String role);

	void registerationFailure(String email,String role);

	void sendOTP(String email, String pass,String role);

	void successfulPasswordChange(String email,String role);

	void notifyRegisteration(String email, String role);

}