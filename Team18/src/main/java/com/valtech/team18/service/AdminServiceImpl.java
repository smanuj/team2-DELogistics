package com.valtech.team18.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;
import com.valtech.team18.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AdminServiceImpl implements AdminService {

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	@Autowired
	private TruckDetailsRepo truckDetailsRepo;

	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;

	@Autowired
	private MailMessage mailMessage;

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<OrderDetails> getAllOrderD() {
		logger.info("Loading Order Details....");
		logger.debug("Successfully Loaded Order Details! " + orderDetailsRepo.findAll());
		return orderDetailsRepo.findAll();
	}

	@Override
	public List<TruckDetails> getAllTruckD() {
		logger.info("Loading Truck Details....");
		logger.debug("Successfully Loaded Truck Details! " + truckDetailsRepo.findAll());
		return truckDetailsRepo.findAll();
	}

	@Override
	public List<SupplierDetails> getAllSuppplierD() {
		logger.info("Loading Supplier Details....");
		logger.debug("Successfully Loaded Supplier Details!  " + supplierDetailsRepo.findAll());
		return supplierDetailsRepo.findAll();
	}

	@Override
	public void sendAlertMail(int tId) {
		logger.info("Sending alert....");
		TruckDetails td = truckDetailsRepo.findByTruckId(tId);
		System.out.println(td);
		System.out.println(td.getTruckId());
		int td1= td.getTruckId();
		User usr = userRepo.findByTruckId(td);
		System.out.println(usr);
		mailMessage.sendAlert(usr.getEmail(), td.getDriverName());
		logger.debug("Alert Sent!");
	}

}
