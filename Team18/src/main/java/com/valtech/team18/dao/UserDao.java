package com.valtech.team18.dao;

public interface UserDao {

	void deleteSupplierRegistration(int id);

	void deleteTruckDriverRegistration(int id);

	void changePass(String password, int userId) throws Exception;

}