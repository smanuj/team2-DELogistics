package com.valtech.team18.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class SendMailImpl implements SendMail {

	private static final Logger logger = LoggerFactory.getLogger(SendMailImpl.class);

	// @Value("${sender.email.id}")
	// private String fromId;
	// @Value("${sender.email.password}")
	// private String password;

	@Override
	@RequestMapping("de")
	public void sendMail(String email, String subject, String body) {
		logger.info("Sending mail....");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		// smtp.gmail.com supports TLSv1.2 and TLSv1.3
		// smtp.office365.com supports only TLSv1.2
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				logger.info("Getting Password Authenticated....");
				// System.out.println("ID: "+appProperties.getId());
				// System.out.println("Password: "+appProperties.getPassword());
				logger.debug("Successfully Authenticated Password!");
				return new PasswordAuthentication("dartexpresslogistics@outlook.com", "Qwertyuiop12#");
			}
		});

		try {
			logger.info("Sending mail....");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dartexpresslogistics@outlook.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			// message.setText("This email was sent with JavaMail.");
			message.setText(body);
			Transport.send(message);
			logger.debug("Mail Sent Successfully!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}