package com.valtech.team18.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.Otps;

@Repository
public interface OtpRepo extends JpaRepository<Otps, Integer>{
	
	Otps findByOtpId(int id);
}
