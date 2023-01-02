package com.valtech.team18.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailService  {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getPendingSupplier() {
		logger.info("Loading Pending Supplier Details....");
		//logger.debug("Successfully Loaded Pending Supplier Details! " + supplierDetailsRepo.findAllByApprovedFalse());
		return userRepo.findAllByApprovalFalseAndSuppIdNotNull();
	}

	@Override
	public List<User> getApprovedSupplier() {
		logger.info("Loading Approved Supplier Details....");
		//logger.debug("Successfully Loaded Approved Supplier Details! " + supplierDetailsRepo.findAllByApprovedTrue());
		return userRepo.findAllByApprovalTrueAndSuppIdNotNull();
	}
	
	
	@Override
	public List<User> getPendingDriver() {
		logger.info("Loading Pending Driver Details....");
//		logger.debug("Successfully Loaded Pending Driver Details! " + supplierDetailsRepo.findAllByApprovedFalse());
		return userRepo.findAllByApprovalFalseAndTruckIdNotNull();
	}

	
	

	@Override
	public List<User> getApprovedDriver() {
		logger.info("Loading Approved Driver Details....");
//		logger.debug("Successfully Loaded Approved Driver Details! " + supplierDetailsRepo.findAllByApprovedTrue());
		return userRepo.findAllByApprovalTrueAndTruckIdNotNull();
	}
	
	@Override
	public void deleteSupplier(int id) {
		logger.info("Deleting Supplier....");
		logger.debug("Successfully Deleted Supplier!" + id);
		userRepo.deleteById(id);
	}
	@Override
	public void deleteTruck(int id) {
		logger.info("Deleting Supplier....");
		logger.debug("Successfully Deleted Driver! " + id);
		userRepo.deleteById(id);
	}
	@Override
	public void deleteSupplierRegister(int id){
		String sql = "delete User where id = ?";
        jdbcTemplate.update(sql, id);
	}
	@Override
	public void deleteTruckDriverRegister(int id){
		String sql = "delete User where id = ?";
        jdbcTemplate.update(sql, id);
	}
	
	

	
}
