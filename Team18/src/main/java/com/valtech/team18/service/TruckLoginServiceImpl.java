package com.valtech.team18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.valtech.team18.entity.PendingDriver;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class TruckLoginServiceImpl implements TruckLoginService {

	@Autowired
	private TruckDetailsRepo truckDetailsRepo;

	// Login Validation by checking given username and password in the database
	@Override
	public boolean loginvalidation(String username, String password) throws NullPointerException {

		try {
			TruckDetails sup = truckDetailsRepo.findByDriverName(username);

			if ((username.equals(sup.getDriverName())) && (password.equals(sup.getDriverPassword()))) {
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
		
		return truckDetailsRepo.findByEmail(email).getTruckId();
//		return supplierDetailsRepo.findByEmail(email).getSuppId();
	}
	
	
	

	// Save new supplier details
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public TruckDetails saveNew(PendingDriver pd) {
//		String username = pd.getUsername();
//		String password = pd.getPassword();
//		long driverNumber = pd.getDriverNumber();
//
//		TruckDetails td = new TruckDetails(username, password, driverNumber);
//		return truckDetailsRepo.save(td);
//	}

}
