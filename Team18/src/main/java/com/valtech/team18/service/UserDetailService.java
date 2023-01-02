package com.valtech.team18.service;

import java.util.List;

import com.valtech.team18.entity.User;

public interface UserDetailService {

	List<User> getPendingDriver();

	List<User> getApprovedDriver();

	List<User> getPendingSupplier();

	List<User> getApprovedSupplier();
	
	void deleteSupplier(int id);

	void deleteTruck(int id);

	void deleteSupplierRegister(int id);
	
	void deleteTruckDriverRegister(int id);

	void changePassword(String password, int userId) throws Exception;
}