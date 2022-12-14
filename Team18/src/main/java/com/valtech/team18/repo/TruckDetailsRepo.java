package com.valtech.team18.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.TruckDetails;

@Repository
public interface TruckDetailsRepo extends JpaRepository<TruckDetails, Integer> {
	
	// Search Truck Driver info based on username
	TruckDetails findByDriverName(String driverName);
	
	List<TruckDetails> findAllByApprovedFalse();
	List<TruckDetails> findAllByApprovedTrue();

	TruckDetails findByEmailAndApprovedTrue(String email);
	
	TruckDetails findByEmail(String email);
	TruckDetails findByTruckId(int id);

}
