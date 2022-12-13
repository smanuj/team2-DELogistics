package com.valtech.team18.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MailMessageImpl implements MailMessage {

	SendMail mm = new SendMailImpl();

	@Override
	public void sendAlert(String email) {
		String subject = "Alert!!";
		String body = "Hello delivery partner, Please pull over whenever it is safe to do so and examine the delivery contents and the truck as the temperature seems to be highly varying as compared to the ideal temp. -admin";
		mm.sendMail(email, subject, body);
	}

	@Override
	public void registeredSuccessfully(String email,String role) {
		String subject1 = "Congratulations!";
		String body1 = "Hello, You have successfully registered as "+role+" at Dart Express Logistics, you can now log in to your account through the website using your registered email id and password. Thank you for choosing us :) -admin";
		mm.sendMail(email, subject1, body1);
	}

	@Override
	public void registerationFailure(String email,String role) {
		String subject2 = "Dart Express Logistics";
		String body2 = "Hello, We regret to inform you that your regristration request was not successful for "+role+" . This might have occured due to various reasons. Please contact us at dartexpresslogistics@outlook.com for more info. Thank you for understanding, you can try registering again if you think there was a mistake  -admin";
		mm.sendMail(email, subject2, body2);
	}

	@Override
	public void sendOTP(String email, String pass, String role) {
		String subject3 = "Reset Password";
		String body3 = "Hello, Please use this OTP to reset your "+role+" account password: "+pass+" DO NOT SHARE THIS OTP WITH ANYONE!!. -admin";
		mm.sendMail(email, subject3, body3);
		
	}

	@Override
	public void successfulPasswordChange(String email,  String role) {
		String subject4 = "Password Changed Successfully";
		String body4 = "Congratulations, your password has been changed successfully for the "+role+" login. -admin";
		mm.sendMail(email, subject4, body4);
	}

}
