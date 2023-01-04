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
	
	@Autowired
	private UserDetailService userDetailService;

	public static String getRandomNumberString() {
		logger.info("Generating Random String....");
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		logger.debug("Successfully Generated Random String!" + number);
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
				logger.info("Successfully Validated Login Credentials for " + usr.getEmail());
				return true;
			}

			return false;
		}

		catch (NullPointerException n) {
			logger.error("Error Occurred while Logging-In at Line 69 in SupplierLoginServiceImpl");
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
		
		User usr=userRepo.findByEmailAndSuppIdNotNull(email);
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(usr.getSuppId().getSuppId());
		if (usr.getEmail() != null) {
			String pass = getRandomNumberString();
			Otps otp = new Otps(pass);
			System.out.println("otp1=   "+otp);
			otp= otpRepo.save(otp);
			System.out.println("otp2=   "+otp);
			usr.setOtpId(otp);
//			supplierDetailsRepo.save(sd);
			userRepo.save(usr);
			try {
				mailMessage.sendOTP(usr.getEmail(), pass, "Supplier", sd.getSuppName());
				logger.debug("Mail Confirmed and Sent to " + usr.getEmail());
			} catch (Exception e) {
				logger.error("Error while Sending Mail at Line 102 in SupplierLoginServiceImpl");
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
//		SupplierDetails sd = supplierDetailsRepo.findBySuppId(id);
//		int tempOtpId = usr.getOtpId();
//		Integer otpId=Integer.parseInt(tempOtpId);
//		Otps otp10 = otpRepo.findByOtpId(usr.getOtpId().getOtpId());
//		Otps otp1 = otpRepo.findById(usr.getOtpId()).get();
		if (otp.equals(usr.getOtpId().getOtp())) {
			logger.debug("OTP Confirmed and Sent to " + usr);
			return true;
		}
		logger.debug("OTP couldn't be sent to " + usr);
		return false;
	}

	@Override
	public void changePassword(int id, String password) {
		logger.info("Changing password....");
		SupplierDetails sd = supplierDetailsRepo.findBySuppId(id);
		
		User usr=userRepo.findById(id).get();
		usr.setPassword(password);
		
		try {
			userDetailService.changePassword(password, id);
			usr.setOtpId(null);
//		int tempOtpId = usr.getOtpId();
//		Integer otpId=Integer.parseInt(tempOtpId);
		Otps otp = otpRepo.findByOtpId(usr.getOtpId().getOtpId());
		supplierDetailsRepo.save(sd);
//		usr.setOtp(null);
		otp.setOtp(null);
		otpRepo.save(otp);
			userRepo.save(usr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			mailMessage.successfulPasswordChange(usr.getEmail(), "Supplier", usr.getSuppId().getSuppName());
			logger.info("Password Changed Successfully!");
		} catch (Exception e) {
			logger.error("Error while Changing Password at Line 147 in SupplierLoginServiceImpl");
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
