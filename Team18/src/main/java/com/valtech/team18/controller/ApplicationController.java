package com.valtech.team18.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.team18.service.AdminLoginService;
import com.valtech.team18.service.SupplierLoginService;
import com.valtech.team18.service.TruckLoginService;

@Controller
public class ApplicationController {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

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
		logger.info("Fetching adminLoginVal for admin");

		System.out.println("test1");
		if (role.equals("admin")) {
			System.out.println("test2");
			if (adminLoginService.loginvalidation(email, password) == true) {
				System.out.println("test3");
				return "redirect:/admin/adminHome";
			} else {
				String message = "Invalid Email-Id and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "mainHomePage";
			}
		} else if (role.equals("supp")) {
			if (supplierLoginService.loginvalidation(email, password) == true) {
				int id = supplierLoginService.getIdFromEmail(email);
				return "redirect:/supplier/supplierHome/" + id;
			} else {
				String message = "Invalid supp Email-Id and Password";
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

				String message = "Invalid driver Email-Id and Password";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "mainHomePage";
			}

		}
		logger.debug("Successfully fetched adminLoginVal");

		return "mainHomePage";

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

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPassword";
	}

	@PostMapping("/forgotPassword")
	public String forgotPass(@RequestParam("email") String email, @RequestParam("role") String role, Model model) {
		logger.info("Fetching forgotPassword");
		if (role.equals("supp")) {
			if (supplierLoginService.checkmail(email)) {
				// return "newPassword";
				int id = supplierLoginService.getIdFromEmail(email);
				return "redirect:/newPassword/supp/" + id;

			} else {
				String message = "Invalid Email-Id for Supplier";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "forgotPassword";
			}
		} else {
			if (truckLoginService.checkmail(email)) {
				int id = truckLoginService.getIdFromEmail(email);
				return "redirect:/newPassword/driver/" + id;
			} else {
				String message = "Invalid Email-Id for Driver";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "forgotPassword";
			}

		}

	}

	@GetMapping("/newPassword/supp/{id}")
	public String newPasswordForSupp() {
		logger.info("Fetching newPassword for supplier {}");

		logger.debug("Successfully fetched {} newPassword");
		return "newPassword";
	}

	@GetMapping("/newPassword/driver/{id}")
	public String newPasswordForDriver() {
		logger.info("Fetching newPassword for driver {}");

		logger.debug("Successfully fetched {} newPassword");
		return "newPassword";
	}

	@PostMapping("/newPassword/supp/{id}")
	public String changeSuppPass(@PathVariable("id") int id, @RequestParam("otp") String otp,
			@RequestParam("newpassword") String password, @RequestParam("confirmPassword") String cPassword,
			Model model) {
		logger.info("Fetching changeSuppPassword for supplier {}", id);
		if (supplierLoginService.checkOTP(id, otp)) {
			if (password == cPassword || password.equals(cPassword)) {
				supplierLoginService.changePassword(id, password);
				String message = "Password has been changed";
				// model.addAttribute("mess", message);
				System.out.println(message);
				return "redirect:/";
			} else {
				String message = "Entered passwords do not match";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "/newPassword/supp/{id}";
			}
		} else {
			String message = "Invalid OTP, enter the correct OTP";
			System.out.println(message);
			model.addAttribute("mess", message);
			return "/newPassword/supp/{id}";
		}

	}

	@PostMapping("/newPassword/driver/{id}")
	public String changeDriverPass(@PathVariable("id") int id, @RequestParam("otp") String otp,
			@RequestParam("newpassword") String password, @RequestParam("confirmPassword") String cPassword,
			Model model) {
		logger.info("Fetching newPassword for driver {}", id);
		if (truckLoginService.checkOTP(id, otp)) {
			if (password == cPassword || password.equals(cPassword)) {
				truckLoginService.changePassword(id, password);
				String message = "Password has been changed";
				// System.out.println(message);
				model.addAttribute("mess", message);
				return "redirect:/";
			} else {
				String message = "Entered passwords do not match";
				System.out.println(message);
				model.addAttribute("mess", message);
				return "/newPassword/supp/{id}";
			}
		} else {
			String message = "Invalid OTP, enter the correct OTP";
			System.out.println(message);
			model.addAttribute("mess", message);
			return "/newPassword/supp/{id}";
		}
	}

}
