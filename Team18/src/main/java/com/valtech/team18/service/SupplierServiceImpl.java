package com.valtech.team18.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.Otps;
import com.valtech.team18.entity.Role;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.OtpRepo;
import com.valtech.team18.repo.RoleRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;
import com.valtech.team18.repo.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SupplierServiceImpl implements SupplierService {

	private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;

	@Autowired
	private TruckDetailsRepo truckDetailsRepo;

	@Autowired
	private MailMessage mailMessage;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private OtpRepo otpRepo;

	@Override
	public List<TruckDetails> getAllTruckD() {
		logger.info("Loading Truck Details....");
		logger.debug("Successfully Loaded Truck Details! " + truckDetailsRepo.findAll());
		return truckDetailsRepo.findAll();
	}

	@Override
	public List<SupplierDetails> getAllSuppplierD() {
		logger.info("Loading Supplier Details....");
		logger.debug("Successfully Loaded Supplier Details! " + supplierDetailsRepo.findAll());
		return supplierDetailsRepo.findAll();
	}

	@Override
	public List<OrderDetails> getAllOrdersBySuppId(int suppId) {
		logger.info("Loading Order Details for Supplier " + suppId);
		logger.debug(
				"Successfully Loaded Order Details for Supplier! " + orderDetailsRepo.getAllOrdersBySuppId(suppId));
		return orderDetailsRepo.getAllOrdersBySuppId(suppId);
	}

	@Override
	public List<Integer> getAllDriverIdFromOrderDetails(OrderDetails od) {
		logger.info("Loading Driver ID for Order " + od);
		logger.debug(
				"Successfully Loaded Driver ID for Order! " + orderDetailsRepo.getDriverIdBySuppId(od.getSuppId()));
		return orderDetailsRepo.getDriverIdBySuppId(od.getSuppId());
	}

//	@Override
//	public List<SupplierDetails> getPendingSupplier() {
//		logger.info("Loading Pending Supplier Details....");
//		logger.debug("Successfully Loaded Pending Supplier Details! " + supplierDetailsRepo.findAllByApprovedFalse());
//		return supplierDetailsRepo.findAllByApprovedFalse();
//	}
//
//	@Override
//	public List<SupplierDetails> getApprovedSupplier() {
//		logger.info("Loading Approved Supplier Details....");
//		logger.debug("Successfully Loaded Approved Supplier Details! " + supplierDetailsRepo.findAllByApprovedTrue());
//		return supplierDetailsRepo.findAllByApprovedTrue();
//	}

	@Override
	public User approvingSupplier(int id) {
		// TruckDetails td=truckDetailsRepo.findById(id).get();
		// td.setApproved(true);
		logger.info("Approving Supplier " + id);
//		SupplierDetails sd = supplierDetailsRepo.findById(id).get();
		User usr = userRepo.findById(id).get();
		usr.setApproval(true);
		try {
			mailMessage.registeredSuccessfully(usr.getEmail(), "Supplier", usr.getSuppId().getSuppName());
			logger.debug("Successfully Approved Supplier with" + usr.getEmail());
		} catch (Exception e) {
			logger.error("Suppler Rejected");
			e.printStackTrace();
		}
		return userRepo.save(usr);

	}

	@Override
	public void deleteRejectedSupplier(int id) {
		logger.info("Deleting Rejected Supplier " + id);
//		SupplierDetails sd = supplierDetailsRepo.findById(id).get();
		User usr = userRepo.findById(id).get();
		supplierDetailsRepo.deleteBySuppId(usr.getSuppId().getSuppId());
		userRepo.deleteById(id);
		try {
			mailMessage.registerationFailure(usr.getEmail(), "Supplier", usr.getSuppId().getSuppName());
			logger.debug("Deleted Rejected Supplier! " + usr.getEmail());
		} catch (Exception e) {
			logger.error("Unable to Delete Rejected Supplier! Error at Line 128 in SupplierServiceImpl");
			e.printStackTrace();
		}
	}

	@Override
	public List<TruckDetails> getTruckDetailsFromOrder(int id) {
		// model.addAttribute("OrderDetails",
		// suppService.getAllOrdersBySuppId(id));
		logger.info("Loading Truck Details for Order....");
		List<OrderDetails> od = getAllOrdersBySuppId(id);
		List<Integer> driverid = new ArrayList<Integer>();
		for (OrderDetails orderDetails : od) {
			driverid.add(orderDetails.getDriverId());
		}

		List<TruckDetails> td = new ArrayList<TruckDetails>();
		for (Integer did : driverid) {
			td.add(truckDetailsRepo.findById(did).get());
		}
		logger.debug("Successfully Loaded Truck Details for Order! " + id);
		return td;
	}

	@Override
	public boolean register(String username, String email, String password, String fromAddress, String contactNumber,
			String landLine) {
		logger.info("Registering user....");
		System.out.println(username + "   " + email + "    " + password + "    " + fromAddress + "    " + contactNumber
				+ "     " + landLine);
		// TODO Auto-generated method stub
		long contactNumbe = Long.valueOf(contactNumber);
		long landLin = Long.valueOf(landLine);
		// long landLin1=null;
//		boolean set = false;
		// SupplierDetails sl = supplierDetailsRepo.findByEmail(email);
		User usr = userRepo.findByEmailAndSuppIdNotNull(email);
		if (usr == null) {
			SupplierDetails sd = new SupplierDetails(username, fromAddress, contactNumbe, landLin);
			System.out.println("sd= " + sd);
			supplierDetailsRepo.save(sd);
//			String otp="123456";
//			Otps otp1=new Otps(otp);
			User usr1 = new User(email, password, sd);

//			String tempOtpId = usr1.getOtpId();
//			System.out.println("user :    "+tempOtpId);
//			int otpId=Integer.valueOf(tempOtpId);
//			Otps otp10 = otpRepo.findByOtpId(otpId);

			Role role = roleRepo.findByName("SUPPLIER");

			Set<Role> roles = new HashSet<Role>();
			roles.add(role);
			System.out.println(email + password + sd + " test " + roles);

			usr1.setRoles(roles);
			System.out.println("usr= " + usr1);
			userRepo.save(usr1);
			try {
				mailMessage.notifyRegisteration(usr1.getEmail(), "SUPPLIER", sd.getSuppName());
				logger.debug("Registration Successfully Recieved for " + usr1.getEmail());
			} catch (Exception e) {
				logger.error("Registration Not Received! Error at Line 190 at SupplierServiceImpl");
				e.printStackTrace();
			}
			return true;
		}

		return false;

	}

	@Override
	public void deleteSupplier(int id) {
		logger.info("Deleting Supplier...");
		logger.debug("Successfully Deleted Supplier! "  + id);
		supplierDetailsRepo.deleteBySuppId(id);
	}

	@Override
	public List<SupplierDetails> getPendingSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierDetails> getApprovedSupplier() {
		List<User> usr=userRepo.findAllByApprovalTrueAndSuppIdNotNull();
		List<SupplierDetails> sd=new ArrayList<>();
		for (User us : usr) {
				sd.add(us.getSuppId());
		}
		return sd;
	}

}
