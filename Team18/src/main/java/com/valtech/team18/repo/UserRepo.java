package com.valtech.team18.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
}
