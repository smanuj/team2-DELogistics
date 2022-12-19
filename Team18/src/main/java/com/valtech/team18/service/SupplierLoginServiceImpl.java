package com.valtech.team18.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.valtech.team18.entity.PendingSupplier;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.repo.SupplierDetailsRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SupplierLoginServiceImpl implements SupplierLoginService {

	private static final Logger logger = LoggerFactory.getLogger(SupplierLoginServiceImpl.class);

	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;

	@Autowired
	private MailMessage mailMessage;

	public static String getRandomNumberString() {
		logger.info("Generating Random String....");
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		logger.debug("Successfully Generated Random String!");
		return String.format("%06d", number);
	}

	// Login Validation by checking given username and password in the database
	@Override
	public boolean loginvalidation(String email, String password) throws NullPointerException {
		logger.info("Validating Login Credentials....");

		try {
			SupplierDetails sup = supplierDetailsRepo.findByEmailAndApprovedTrue(email);

			if ((email.equals(sup.getEmail())) && (password.equals(sup.getSuppPassword()))) {
				logger.info("Successfully Validated Login Credentials!");
				return true;
			}

			return false;
		}

		catch (NullPointerException n) {
			return false;
		}

	}

	@Override
	public int getIdFromEmail(String email) {
		logger.info("Retreiving Id assoicated with mail " + email);
		logger.debug("Successfully Retreived Id assoicated with mail " + email);
		return supplierDetailsRepo.findByEmail(email).getSuppId();
	}

	@Override
	public boolean checkmail(String email) {
		logger.info("Confirming Mail....");
		SupplierDetails sd = supplierDetailsRepo.findByEmail(email);
		if (sd.getEmail() != null) {
			String pass = getRandomNumberString();
			sd.setOtp(pass);
			supplierDetailsRepo.save(sd);
			try {
				mailMessage.sendOTP(sd.getEmail(), pass, "Supplier", sd.getSuppName());
				logger.debug("Mail Confirmed and Sent!");
			} catch (Exception e) {
				logger.debug("Mail Confirmation Unsuccessfull!");
				e.printStackTrace();
			}
			return true;

		}

		return false;
	}

	@Override
	public boolean checkOTP(int id, String otp) {
		logger.info("Confirming OTP....");
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(id);
		if (otp.equals(sd.getOtp())) {
			logger.debug("OTP Confirmed!");
			return true;
		}
		logger.debug("OTP Failed!");
		return false;
	}

	@Override
	public void changePassword(int id, String password) {
		logger.info("Changing password....");
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(id);
		sd.setSuppPassword(password);
		sd.setOtp(null);
		supplierDetailsRepo.save(sd);
		try {
			mailMessage.successfulPasswordChange(sd.getEmail(), "Supplier", sd.getSuppName());
			logger.info("Password Changed Successfully!");
		} catch (Exception e) {
			logger.debug("Password Changed Failed!");
			e.printStackTrace();
		}

	}

	// // Save new supplier details
	// @Override
	// @Transactional(propagation=Propagation.REQUIRED)
	// public SupplierDetails saveNew(PendingSupplier ps){
	// String username=ps.getUsername();
	// String password=ps.getPassword();
	// String fromAdd=ps.getFromAddress();
	// String suppConDe=ps.getSuppContactDetails();
	// SupplierDetails sl=new SupplierDetails(username,
	// password,fromAdd,suppConDe);
	// return supplierDetailsRepo.save(sl);
	// }

}
