package com.valtech.team18.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.SupplierDetails;

@Repository
public interface SupplierDetailsRepo extends JpaRepository<SupplierDetails, Integer> {
	
	// Search Supplier info based on username
	SupplierDetails findBySuppName(String suppName);

}
