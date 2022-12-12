package com.valtech.team18.service;

public interface MailMessage {

	void sendAlert(String email);

	void registeredSuccessfully(String email);

	void registerationFailure(String email);

}