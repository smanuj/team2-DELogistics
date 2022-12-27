//package com.valtech.team18.repo;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.valtech.team18.entity.AdminLogin;
//
//@Repository
//public interface AdminLoginRepo extends JpaRepository<AdminLogin, Integer> {
//
//	// findByUsernameAndPassword is used to find the entity during login
//	// verification
//	AdminLogin findByUsernameAndPassword(String username, String password);
//
//	// findByUsername is used to find the admin entity based on username
//	AdminLogin findByUsername(String username);
//
//}
