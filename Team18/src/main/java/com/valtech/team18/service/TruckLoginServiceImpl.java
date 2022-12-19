package com.valtech.team18.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.valtech.team18.entity.SupplierDetails;
//import com.valtech.team18.entity.PendingDriver;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class TruckLoginServiceImpl implements TruckLoginService {

	private static final Logger logger = LoggerFactory.getLogger(TruckLoginServiceImpl.class);

	@Autowired
	private TruckDetailsRepo truckDetailsRepo;

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
			TruckDetails sup = truckDetailsRepo.findByEmailAndApprovedTrue(email);

			if ((email.equals(sup.getEmail())) && (password.equals(sup.getDriverPassword()))) {
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
		return truckDetailsRepo.findByEmail(email).getTruckId();
		// return supplierDetailsRepo.findByEmail(email).getSuppId();
	}

	@Override
	public boolean checkmail(String email) {
		logger.info("Confirming Mail....");
		TruckDetails td = truckDetailsRepo.findByEmail(email);

		if (td.getEmail() != null) {
			String pass = getRandomNumberString();
			td.setOtp(pass);
			truckDetailsRepo.save(td);
			try {
				mailMessage.sendOTP(td.getEmail(), pass, "Driver", td.getDriverName());
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
		TruckDetails td = truckDetailsRepo.findByTruckId(id);
		if (otp.equals(td.getOtp())) {
			logger.debug("OTP Confirmed!");
			return true;
		}
		logger.debug("OTP Failed!");
		return false;
	}

	@Override
	public void changePassword(int id, String password) {
		logger.info("Changing password....");
		TruckDetails td = truckDetailsRepo.findByTruckId(id);
		td.setDriverPassword(password);
		td.setOtp(null);
		truckDetailsRepo.save(td);
		try {
			mailMessage.successfulPasswordChange(td.getEmail(), "Driver", td.getDriverName());
			logger.debug("Password Changed Successfully!");
		} catch (Exception e) {
			logger.debug("Password Changed Failed!");
			e.printStackTrace();
		}

	}

	// Save new supplier details
	// @Override
	// @Transactional(propagation = Propagation.REQUIRED)
	// public TruckDetails saveNew(PendingDriver pd) {
	// String username = pd.getUsername();
	// String password = pd.getPassword();
	// long driverNumber = pd.getDriverNumber();
	//
	// TruckDetails td = new TruckDetails(username, password, driverNumber);
	// return truckDetailsRepo.save(td);
	// }

}
