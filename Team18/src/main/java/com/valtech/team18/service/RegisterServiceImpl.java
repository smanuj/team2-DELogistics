package com.valtech.team18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.team18.entity.PendingDriver;
import com.valtech.team18.entity.PendingSupplier;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.PendingDriverRepo;
import com.valtech.team18.repo.PendingSupplierRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private PendingDriverRepo pendingDriverRepo;
	
	@Autowired
	private PendingSupplierRepo pendingSupplierRepo;
	
	@Autowired
	private SupplierDetailsRepo supplierDetailsRepo;
	
	@Autowired
	private TruckDetailsRepo truckDetailsRepo;
	
	
	//Check if username already exists and if not, save the details as a new driver
	@Override
	public int RegisterDriver(PendingDriver pd){
		TruckDetails tdl=truckDetailsRepo.findByDriverName(pd.getUsername());
		PendingDriver ctdl=pendingDriverRepo.findByUsername(pd.getUsername());
		if(tdl==null && ctdl==null){
			pendingDriverRepo.save(pd);
			return 0;
		}
		return 1;
	}
	
	//Check if username already exists and if not, save the details as a new supplier
	@Override
	public int RegisterSupplier(PendingSupplier ps){
		SupplierDetails sl=supplierDetailsRepo.findBySuppName(ps.getUsername());
		PendingSupplier cps=pendingSupplierRepo.findByUsername(ps.getUsername());
		if(sl==null && cps==null){
			pendingSupplierRepo.save(ps);
			return 0;
		}
		return 1;
	}
	
	@Override
	public List<PendingDriver> getDriverList(){
		return pendingDriverRepo.findAll();
	}
	
	@Override
	public List<PendingSupplier> getSupplierList(){
		return pendingSupplierRepo.findAll();
	}
	
	@Override
	public void deleteDriver(PendingDriver pd){
		 pendingDriverRepo.delete(pd);
		
	}
	
	@Override
	public void deleteSupp(PendingSupplier ps){
		 pendingSupplierRepo.delete(ps);;
		
	}

}
