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

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.TruckDetailsRepo;
import com.valtech.team18.service.SupplierService;

@Controller
public class SupplierController {

	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	SupplierService suppService;

	@Autowired
	TruckDetailsRepo truckDetailsRepo;

	// Navigate to supplier home page for a particular supplier id
	@GetMapping("/supplier/supplierHome/{id}")
	public String suppHome(@PathVariable("id") int id, Model model) {

		List<OrderDetails> od = suppService.getAllOrdersBySuppId(id);
		model.addAttribute("OrderDetails", od);
		List<TruckDetails> td = suppService.getTruckDetailsFromOrder(id);
		model.addAttribute("td", td);
		return "supplier/supplierHome";
	}

	@GetMapping("/supplier/supplierRegister")
	public String supplierRegister() {
		return "supplier/supplierRegister";
	}

	@PostMapping("/supplier/supplierRegister")
	public String supplierRegister(@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("confirmpassword") String cpassword,
			@RequestParam("fromAddress") String fromAddress, @RequestParam("contactNumber") String contactNumber,
			@RequestParam("phone") String landLine, ModelMap model) {
		logger.info("Registering a new supplier");
		if (password.equals(cpassword)) {

			boolean check = suppService.register(username, email, password, fromAddress, contactNumber, landLine);

			if (check) {
				return "redirect:/mainHomePage";

			} else {
				String str = "Email already in use";
				model.addAttribute("mess", str);
				return "/supplier/supplierRegister";

			}
		} else {
			String str = "Entered Passwords do not Match";
			model.addAttribute("mess", str);
			return "/supplier/supplierRegister";
		}
	}

}
