package com.valtech.team18.service;

public interface EmailService {

	void SendMail(String from, String to, String subject, String text);

}