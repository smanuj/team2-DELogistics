package com.valtech.team18.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
