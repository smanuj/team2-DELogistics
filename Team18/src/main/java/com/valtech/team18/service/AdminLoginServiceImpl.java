package com.valtech.team18.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.Otps;
import com.valtech.team18.entity.Role;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.RoleRepo;
import com.valtech.team18.repo.UserRepo;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AdminLoginServiceImpl implements AdminLoginService {

	private static final Logger logger = LoggerFactory.getLogger(AdminLoginServiceImpl.class);

	@Autowired
	private UserRepo userRepo; 
	
	@Autowired
	private RoleRepo roleRepo;

	// @Autowired
	// private AdminLogin adminLo

	// Login Validation for admin
	@Override
	public boolean loginvalidation(String username, String password) throws NullPointerException {
		logger.debug("Validating Login Credentials for " + username + " and " + password);
		try {
			User b = userRepo.findByEmail("admin@gmail.com");
			logger.debug("Valdating for " + b);
			if (b == null) {

//				AdminLogin a = new AdminLogin("admin@gmail.com", "admin");
//				adminLoginRepo.save(a);
				String email = "admin@gmail.com";
				String example = "12345";
				Otps otp1 = new Otps(example);
				
			    Role role=	roleRepo.findByName("ADMIN");
				
			    Set<Role> roles=new HashSet<Role>();
				roles.add(role);
				
				
				System.out.println(otp1.getOtpId());
//				int otp2 = otp1.getOtpId();
				System.out.println(email+password+roles);
				User a = new User(email, password, true, roles);
				
				System.out.println("user "+a);
				userRepo.save(a);
				System.out.println("user as "+a);
				
				
				logger.debug("Validating for " + a);
			}

			User admin = userRepo.findByEmail(username);

			if ((username.equals(admin.getEmail())) && (password.equals(admin.getPassword()))) {
				// if(username.equals("admin@gmail.com")&&(password.equals("admin"))){
				logger.info("Validation Successfull!");
				return true;
			}
			logger.debug("Validation Unsuccessfull!");
			return false;
		}

		catch (NullPointerException n) {
			return false;
		}

	}
}
