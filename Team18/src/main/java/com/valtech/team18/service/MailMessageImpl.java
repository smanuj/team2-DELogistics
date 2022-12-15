package com.valtech.team18.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.controller.AdminController;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MailMessageImpl implements MailMessage {
	
	private static final Logger logger = LoggerFactory.getLogger(MailMessageImpl.class);

	SendMail mm = new SendMailImpl();

	@Override
	public void sendAlert(String email, String name) {
		logger.debug("Sending alert to " + name + " associated with mail " + email);
		String subject = "Alert!! "+name;
		String body = "Hello delivery partner, Please pull over whenever it is safe to do so and examine the delivery contents and the truck as the temperature seems to be highly varying as compared to the ideal temp. -admin";
		mm.sendMail(email, subject, body);
	}

	@Override
	public void registeredSuccessfully(String email,String role, String name) {
		logger.debug("Successfully registered User with email: "+ email + " under role: "+ role + " by name: " + name);
		String subject1 = "Congratulations! "+name;
		String body1 = "Hello, You have successfully registered as "+role+" at Dart Express Logistics, you can now log in to your account through the website using your registered email id and password. Thank you for choosing us :) -admin";
		mm.sendMail(email, subject1, body1);
	}

	@Override
	public void registerationFailure(String email,String role, String name) {
		logger.debug("Registering User with email: "+ email + " under role: "+ role + " by name: " + name + " has Failed! ");
		String subject2 = "Dart Express Logistics "+name;
		String body2 = "Hello, We regret to inform you that your regristration request was not successful for "+role+" . This might have occured due to various reasons. Please contact us at dartexpresslogistics@outlook.com for more info. Thank you for understanding, you can try registering again if you think there was a mistake  -admin";
		mm.sendMail(email, subject2, body2);
	}

	@Override
	public void sendOTP(String email, String pass, String role, String name) {
		logger.debug("Sending OTP to "+ email + " registered under role: "+ role + " by name: " + name);
		String subject3 = "Reset Password for "+name;
		String body3 = "Hello, Please use this OTP to reset your "+role+" account password: "+pass+" DO NOT SHARE THIS OTP WITH ANYONE!!. -admin";
		mm.sendMail(email, subject3, body3);
		
	}

	@Override
	public void successfulPasswordChange(String email,  String role, String name) {
		logger.debug("Password has been successfully changed for "+ email + " registered under role: "+ role + " by name: " + name);
		String subject4 = "Password Changed Successfully "+name;
		String body4 = "Congratulations, your password has been changed successfully for the "+role+" login. -admin";
		mm.sendMail(email, subject4, body4);
	}

	@Override
	public void notifyRegisteration(String email, String role, String name) {
		logger.debug("Registration Request Recieved from " + email + " for role " + role + " by name " + name);
		String subject5 = "Registeration form recieved from "+name;
		String body5 = "Hello, Your registeration form is received for the role: "+role+" You will be notified regarding the approval soon. -admin";
		mm.sendMail(email, subject5, body5);
	}

}
