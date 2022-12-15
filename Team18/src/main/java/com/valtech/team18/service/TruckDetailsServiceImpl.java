package com.valtech.team18.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
@Transactional(propagation = Propagation.SUPPORTS)
public class TruckDetailsServiceImpl implements TruckDetailsService {

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
		return orderDetailsRepo.findAll();
	}

	@Override
	public List<TruckDetails> getAllTruckD() {
		return truckDetailsRepo.findAll();
	}

	@Override
	public List<OrderDetails> getAllOrdersByDriverId(int truckId) {
		return orderDetailsRepo.getAllOrdersByDriverId(truckId);
	}

	@Override
	public List<TruckDetails> getPendingDriver() {
		return truckDetailsRepo.findAllByApprovedFalse();
	}

	@Override
	public List<TruckDetails> getApprovedDriver() {
		return truckDetailsRepo.findAllByApprovedTrue();
	}

	@Override
	public TruckDetails approvingDriver(int id) {
		TruckDetails td = truckDetailsRepo.findById(id).get();
		td.setApproved(true);
		try {
			mailMessage.registeredSuccessfully(td.getEmail(), "Driver", td.getDriverName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return truckDetailsRepo.save(td);
	}

	@Override
	public void deleteRejectedDriver(int id) {
		TruckDetails td = truckDetailsRepo.findById(id).get();
		truckDetailsRepo.deleteById(id);
		try {
			mailMessage.registerationFailure(td.getEmail(), "Driver", td.getDriverName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public TruckDetails getTruckDetailsById(int truckId) {
		return truckDetailsRepo.findByTruckId(truckId);
	}

	@Override
	public List<SupplierDetails> getSupplierFromOrder(int id) {
		List<OrderDetails> od = getAllOrdersByDriverId(id);
		List<Integer> suppId = new ArrayList<Integer>();
		for (OrderDetails orderDetails : od) {
			suppId.add(orderDetails.getSuppId());
		}
		List<SupplierDetails> sd = new ArrayList<SupplierDetails>();
		for (Integer sid : suppId) {
			sd.add(supplierDetailsRepo.findById(sid).get());

		}

		return sd;
	}

	@Override
	public boolean register(String username, String password, String email, String contactNumber) {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

}
