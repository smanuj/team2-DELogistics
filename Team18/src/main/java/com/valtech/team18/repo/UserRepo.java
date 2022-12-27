package com.valtech.team18.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	List<User> findAllByApprovalFalse();

//
	List<User> findAllByApprovalTrue();

//
	User findByEmailAndApprovalTrue(String email);

	User findByEmailAndApprovalTrueAndTruckIdNotNull(String email);

	User findByEmailAndApprovalTrueAndSuppIdNotNull(String email);

//	User findByEmail(String email);

	User findByEmail(String email);

	User findByTruckId(int id);

	User findBySuppId(int id);

	User deleteBySuppId(int id);

	List<User> findAllByApprovalFalseAndSuppIdNotNull();

	List<User> findAllByApprovalFalseAndTruckIdNotNull();

	List<User> findAllByApprovalTrueAndSuppIdNotNull();

	List<User> findAllByApprovalTrueAndTruckIdNotNull();

	User findByEmailAndTruckIdNotNull(String email);

	User findByEmailAndSuppIdNotNull(String email);
}
