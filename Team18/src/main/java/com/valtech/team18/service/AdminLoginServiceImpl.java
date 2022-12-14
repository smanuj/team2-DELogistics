package com.valtech.team18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.AdminLogin;
import com.valtech.team18.repo.AdminLoginRepo;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private AdminLoginRepo adminLoginRepo;


	// Login Validation for admin
	@Override
	public boolean loginvalidation(String username,String password) throws NullPointerException{
		
		try{
		AdminLogin sup=adminLoginRepo.findByUsername(username);
		
		//if((username.equals(sup.getUsername())) && (password.equals(sup.getPassword()))){
		if(username.equals("admin@gmail.com")&&(password.equals("admin"))){
			
			return true;
		}
		
		return false;
		}
		
		catch(NullPointerException n){
			return false;
		}
		
	}
}
