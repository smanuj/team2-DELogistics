package com.valtech.team18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.team18.service.AdminLoginService;

@Controller
public class ApplicationController {

	@Autowired
	AdminLoginService adminLoginService;

	// Navigate to Main Home Page
	@GetMapping("/")
	public String indexPage() {

		return "Index";
	}

	// Navigate to Login Page
	@GetMapping("/login")
	public String login() {

		return "/Login";
	}

	// Submit username and password for validating Admin Login
	@PostMapping("/login")
	public String adminLoginVal(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap model) {
		if (adminLoginService.loginvalidation(email, password) == true) {
			return "redirect:/admin/adminHome";
		} else {
			String message = "Invalid Username and Password";
			System.out.println(message);
			model.addAttribute("mess", message);
			return "admin/adminLogin";
		}
	}

	// Navigate to the About Us page
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}

	// Navigate to the Contact Us page
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}
}
