package com.valtech.team18.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.Otps;
//import com.valtech.team18.entity.PendingSupplier;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.OtpRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SupplierLoginServiceImpl implements SupplierLoginService {

	private static final Logger logger = LoggerFactory.getLogger(SupplierLoginServiceImpl.class);

	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;

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
		logger.debug("Successfully Generated Random String!");
		return String.format("%06d", number);
	}

	// Login Validation by checking given username and password in the database
	@Override
	public boolean loginvalidation(String email, String password) throws NullPointerException {
		logger.info("Validating Login Credentials....");

		try {
//			SupplierDetails sup = supplierDetailsRepo.findByEmailAndApprovedTrue(email);
//			User usr = userRepo.findByEmail(email);
			User usr=userRepo.findByEmailAndApprovalTrueAndSuppIdNotNull(email);

			if ((email.equals(usr.getEmail())) && (password.equals(usr.getPassword()))) {
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
		//return supplierDetailsRepo.findByEmail(email).getSuppId();
		return userRepo.findByEmail(email).getSuppId().getSuppId();
	}

	@Override
	public boolean generateOtp(String email) {
		logger.info("Confirming Mail....");
		
		User usr=userRepo.findByEmail(email);
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(usr.getSuppId().getSuppId());
		if (usr.getEmail() != null) {
			String pass = getRandomNumberString();
			Otps otp = new Otps(pass);
			System.out.println("otp1=   "+otp);
			otp= otpRepo.save(otp);
			System.out.println("otp2=   "+otp);
			usr.setOtpId(otp.getOtpId());
//			supplierDetailsRepo.save(sd);
			userRepo.save(usr);
			try {
				mailMessage.sendOTP(usr.getEmail(), pass, "Supplier", sd.getSuppName());
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
		User usr=userRepo.findById(id).get();
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(id);
		int tempOtpId = usr.getOtpId();
//		Integer otpId=Integer.parseInt(tempOtpId);
		Otps otp10 = otpRepo.findByOtpId(tempOtpId);
//		Otps otp1 = otpRepo.findById(usr.getOtpId()).get();
		if (otp.equals(otp10.getOtp())) {
			logger.debug("OTP Confirmed!");
			return true;
		}
		logger.debug("OTP Failed!");
		return false;
	}

	@Override
	public void changePassword(int id, String password) {
		logger.info("Changing password....");
		User usr=userRepo.findById(id).get();
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(id);
		
		usr.setPassword(password);
//		usr.setOtp(null);
		int tempOtpId = usr.getOtpId();
//		Integer otpId=Integer.parseInt(tempOtpId);
		Otps otp = otpRepo.findByOtpId(tempOtpId);
		otp.setOtp(null);
		supplierDetailsRepo.save(sd);
		try {
			mailMessage.successfulPasswordChange(usr.getEmail(), "Supplier", sd.getSuppName());
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
