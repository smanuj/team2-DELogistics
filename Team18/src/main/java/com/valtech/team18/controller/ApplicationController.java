package com.valtech.team18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.team18.service.AdminLoginService;
import com.valtech.team18.service.SupplierLoginService;
import com.valtech.team18.service.TruckLoginService;

@Controller
public class ApplicationController {

	@Autowired
	AdminLoginService adminLoginService;

	@Autowired
	SupplierLoginService supplierLoginService;

	@Autowired
	TruckLoginService truckLoginService;

	// Navigate to Login Page
	@GetMapping("/login")
	public String login() {

		return "/Login";
	}

	// Navigate to Login Page
	@GetMapping("/")
	public String mainhomepage() {

		return "/mainHomePage";
	}

	// Submit username and password for validating Admin Login
	@PostMapping("/")
	public String adminLoginVal(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("role") String role, ModelMap model) {
		System.out.println("test1");
		if (role.equals("admin")) {
			System.out.println("test2");
			if (adminLoginService.loginvalidation(email, password) == true) {
				System.out.println("test3");
				return "redirect:/admin/adminHome";
			} else {
				String message = "Invalid Username and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "mainHomePage";
			}
		} else if (role.equals("supp")) {
			if (supplierLoginService.loginvalidation(email, password) == true) {
				int id = supplierLoginService.getIdFromEmail(email);
				return "redirect:/supplier/supplierHome/" + id;
			} else {
				String message = "Invalid Username and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "mainHomePage";
			}
		}

		else if (role.equals("driver")) {
			if (truckLoginService.loginvalidation(email, password) == true) {
				int id = truckLoginService.getIdFromEmail(email);
				return "redirect:/truckDriver/truckDriverHome/" + id;
			} else {

				String message = "Invalid driver Username and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "mainHomePage";
			}

		}

		return "mainHomePage";

		// if (adminLoginService.loginvalidation(email, password) == true) {
		// return "redirect:/admin/adminHome";
		// } else {
		// String message = "Invalid Username and Password";
		// System.out.println(message);
		// model.addAttribute("mess", message);
		// return "admin/adminLogin";
		// }
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
