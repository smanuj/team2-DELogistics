package com.valtech.team18.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TruckDetailsServiceImpl implements TruckDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(TruckDetailsServiceImpl.class);

	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	@Autowired
	private TruckDetailsRepo truckDetailsRepo;

	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;

	@Autowired
	private MailMessage mailMessage;

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
	public List<OrderDetails> getAllOrdersByDriverId(int truckId) {
		logger.info("Loading Order Details for Driver " + truckId);
		logger.debug(
				"Successfully Loaded Order Details for Driver! " + orderDetailsRepo.getAllOrdersByDriverId(truckId));
		return orderDetailsRepo.getAllOrdersByDriverId(truckId);
	}

	@Override
	public List<TruckDetails> getPendingDriver() {
		logger.info("Loading Pending Driver Details....");
		logger.debug("Successfully Loaded Pending Driver Details! " + supplierDetailsRepo.findAllByApprovedFalse());
		return truckDetailsRepo.findAllByApprovedFalse();
	}

	@Override
	public List<TruckDetails> getApprovedDriver() {
		logger.info("Loading Approved Driver Details....");
		logger.debug("Successfully Loaded Approved Driver Details! " + supplierDetailsRepo.findAllByApprovedTrue());
		return truckDetailsRepo.findAllByApprovedTrue();
	}

	@Override
	public TruckDetails approvingDriver(int id) {

		logger.info("Approving Driver " + id);
		TruckDetails td = truckDetailsRepo.findById(id).get();
		td.setApproved(true);
		try {
			mailMessage.registeredSuccessfully(td.getEmail(), "Driver", td.getDriverName());
			logger.debug("Successfully Approved Driver! " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return truckDetailsRepo.save(td);
	}

	@Override
	public void deleteRejectedDriver(int id) {
		logger.info("Deleting Rejected Driver " + id);
		TruckDetails td = truckDetailsRepo.findById(id).get();
		truckDetailsRepo.deleteById(id);
		try {
			mailMessage.registerationFailure(td.getEmail(), "Driver", td.getDriverName());
			logger.debug("Deleted Rejected Driver! " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public TruckDetails getTruckDetailsById(int truckId) {
		logger.info("Loading Truck Details for Id " + truckId);
		logger.debug("Successfully Loaded Truck Details for Id " + truckId);
		return truckDetailsRepo.findByTruckId(truckId);
	}

	@Override
	public List<SupplierDetails> getSupplierFromOrder(int id) {
		logger.info("Loading Supplier Id for Order " + id);
		List<OrderDetails> od = getAllOrdersByDriverId(id);
		List<Integer> suppId = new ArrayList<Integer>();
		for (OrderDetails orderDetails : od) {
			suppId.add(orderDetails.getSuppId());
		}
		List<SupplierDetails> sd = new ArrayList<SupplierDetails>();
		for (Integer sid : suppId) {
			sd.add(supplierDetailsRepo.findById(sid).get());

		}
		logger.debug("Successfully Loaded Supplier Id for Order!");
		return sd;
	}

	@Override
	public boolean register(String username, String password, String email, String contactNumber) {
		logger.info("Registering user....");
		long contactNumbe = Long.valueOf(contactNumber);
		boolean set = false;
		Random r = new Random();
		float random = -10 + r.nextFloat() * (45 - (-10));
		TruckDetails td = truckDetailsRepo.findByEmail(email);
		if (td == null) {
			TruckDetails tdn = new TruckDetails(username, password, contactNumbe, random, email, set, null);

			truckDetailsRepo.save(tdn);
			try {
				mailMessage.notifyRegisteration(tdn.getEmail(), "Driver", tdn.getDriverName());
				logger.debug("Registration Successfully Recieved!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public void deleteTruckDriver(int id) {
		logger.info("Deleting Truck Driver " + id);
		logger.debug("Successfully Deleted Truck Driver!");
		truckDetailsRepo.deleteByTruckId(id);
	}

}
