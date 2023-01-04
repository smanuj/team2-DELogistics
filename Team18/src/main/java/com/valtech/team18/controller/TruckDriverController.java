package com.valtech.team18.controller;

import java.util.List;

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

import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.service.TruckDetailsService;

@Controller
public class TruckDriverController {

	private static final Logger logger = LoggerFactory.getLogger(TruckDriverController.class);

	@Autowired
	TruckDetailsService tdService;

	// Navigate to Driver home page for a particular driver id
	@GetMapping("/truckDriver/truckDriverHome/{id}")
	public String driverHome(Model model, @PathVariable("id") int id) {

		model.addAttribute("id", id);
		model.addAttribute("OrderDetails", tdService.getAllOrdersByDriverId(id));

		List<SupplierDetails> sd = tdService.getSupplierFromOrder(id);

		model.addAttribute("sd", sd);
		return "truckDriver/truckDriverHome";
	}

	@GetMapping("/truckDriver/driverRegister")
	public String supplierRegister() {

		return "truckDriver/driverRegister";

	}

	@PostMapping("/truckDriver/driverRegister")
	public String driverRegister(@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("confirmpassword") String cpassword,
			@RequestParam("driverNumber") String contactNumber, ModelMap model) {
		logger.info("Registering truck driver");
		if (password.equals(cpassword)) {

			boolean check = tdService.register(username, password, email, contactNumber);

			if (check) {
				return "redirect:/mainHomePage";

			} else {
				String str = "Email already in use";
				model.addAttribute("mess", str);
				return "/truckDriver/driverRegister";

			}
		} else {
			String str = "Entered Passwords do not Match";
			model.addAttribute("mess", str);
			return "/truckDriver/driverRegisterr";
		}
	}

}
