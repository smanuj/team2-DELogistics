package com.valtech.team18.service;

public interface MailMessage {

	void sendAlert(String email, String name);

	void registeredSuccessfully(String email, String role, String name);

	void registerationFailure(String email, String role, String name);

	void sendOTP(String email, String pass, String role, String name);

	void successfulPasswordChange(String email, String role, String name);

	void notifyRegisteration(String email, String role, String name);

}