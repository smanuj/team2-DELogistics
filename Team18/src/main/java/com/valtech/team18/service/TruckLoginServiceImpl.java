package com.valtech.team18.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.Otps;
import com.valtech.team18.entity.SupplierDetails;
//import com.valtech.team18.entity.SupplierDetails;
//import com.valtech.team18.entity.PendingDriver;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.OtpRepo;
import com.valtech.team18.repo.TruckDetailsRepo;
import com.valtech.team18.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class TruckLoginServiceImpl implements TruckLoginService {

	private static final Logger logger = LoggerFactory.getLogger(TruckLoginServiceImpl.class);

	@Autowired
	private TruckDetailsRepo truckDetailsRepo;

	@Autowired
	private MailMessage mailMessage;
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private OtpRepo otpRepo;

	public static String getRandomNumberString() {
		logger.info("Generating Random String....");
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		logger.debug("Successfully Generated Random String! -> " + number);
		return String.format("%06d", number);
	}

	// Login Validation by checking given username and password in the database
	@Override
	public boolean loginvalidation(String email, String password) throws NullPointerException {
		logger.info("Validating Login Credentials....");

		try {
//			TruckDetails sup = truckDetailsRepo.findByEmailAndApprovedTrue(email);
//			User usr = userRepo.findByEmail(email);
			User usr = userRepo.findByEmailAndApprovalTrueAndTruckIdNotNull(email);

			if ((email.equals(usr.getEmail())) && (password.equals(usr.getPassword()))) {
				logger.debug("Successfully Validated Login Credentials for " + usr.getEmail());
				return true;
			}

			return false;
		}

		catch (NullPointerException n) {
			logger.error("Login Failed! Error at Line 70 in TruckLoginServiceImpl");
			return false;
		}

	}

	@Override
	public int getIdFromEmail(String email) {
		logger.info("Retreiving Id assoicated with mail....");
		logger.debug("Successfully Retreived Id assoicated with mail " + email);
		// return truckDetailsRepo.findByEmail(email).getTruckId();
		return userRepo.findByEmail(email).getTruckId().getTruckId();
		// return supplierDetailsRepo.findByEmail(email).getSuppId();
	}

	@Override
	public boolean generateOtp(String email) {
		logger.info("Confirming Mail....");
		User usr = userRepo.findByEmailAndTruckIdNotNull(email);
		TruckDetails td = truckDetailsRepo.findByTruckId(usr.getTruckId().getTruckId());

		if (usr.getEmail() != null) {
			String pass = getRandomNumberString();
			Otps otp = new Otps(pass);
			System.out.println("otp:   "+otp);
			otpRepo.save(otp);
			usr.setOtpId(otp);
			userRepo.save(usr);
			try {
				mailMessage.sendOTP(usr.getEmail(), pass, "Driver", td.getDriverName());
				logger.debug("Mail Confirmed and Sent to " + usr.getEmail());
			} catch (Exception e) {
				logger.error("Mail Confirmation Unsuccessfull! Error at Line 102 in TruckLoginServiceImpl");
				e.printStackTrace();
			}
			return true;

		}
		return false;
	}

	@Override
	public boolean checkOTP(int id, String otp) {
		logger.info("Confirming OTP....");
		User usr = userRepo.findById(id).get();
		TruckDetails td = truckDetailsRepo.findByTruckId(id);
//		int tempOtpId = usr.getOtpId();
//		Integer otpId=Integer.parseInt(tempOtpId);
		Otps otp10 = otpRepo.findByOtpId(usr.getOtpId().getOtpId());
		// Otps otp1 = otpRepo.findById(usr.getOtpId()).get();
		if (otp.equals(otp10.getOtp())) {
			logger.debug("OTP Confirmed and Sent to " + usr);
			return true;
		}
		logger.debug("Unable to sent OTP to " + usr);
		return false;

	}

	@Override
	public void changePassword(int id, String password) {
		logger.info("Changing password....");
		User usr = userRepo.findById(id).get();
		TruckDetails td = truckDetailsRepo.findByTruckId(id);
		usr.setPassword(password);
//		int tempOtpId = usr.getOtpId();
//		Integer otpId=Integer.parseInt(tempOtpId);
		Otps otp10 = otpRepo.findByOtpId(usr.getOtpId().getOtpId());
		// Otps otp = otpRepo.findById(usr.getOtpId()).get();
		otp10.setOtp(null);
		truckDetailsRepo.save(td);
		try {
			mailMessage.successfulPasswordChange(usr.getEmail(), "Driver", td.getDriverName());
			logger.debug("Password Changed Successfully for " + usr.getEmail());
		} catch (Exception e) {
			logger.error("Error while Changing Password at Line 145 in TruckLoginServiceImpl");
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
