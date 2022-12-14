package com.valtech.team18.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	SupplierService suppService;

	// Navigate to supplier home page for a particular supplier id
	@GetMapping("/supplier/supplierHome/{id}")
	public String suppHome(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		// suppService.getAllOrdersBySuppId(id);
		model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));
		List<TruckDetails> td = suppService.getTruckDetailsFromOrder(id);
		model.addAttribute("td", td);

		// String supplierName =
		// supplierDetailsRepo.findById(id).get().getSuppName();
		// model.addAttribute("sName", supplierName);
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
		if (password.equals(cpassword)) {

			boolean check = suppService.register(username, email, password, fromAddress, contactNumber, landLine);

			if (check) {
				return "/";

			} else {
				String str = "Username already Exists";
				 model.addAttribute("mess", str);
				 return "/supplier/supplierRegister";

			}
		} else {
			String str = "Entered Password do not Match";
			model.addAttribute("mess", str);
			return "/supplier/supplierRegister";
		}
//		return "";
	}
	

	// Navigate to orderDetails page containing all the orders related to the
	// supplier currently logged in
	// @GetMapping("/supplier/orderDetails/{id}")
	// public String suppOrderDetails(Model model, @PathVariable("id") int id) {
	//
	// suppService.getAllOrdersBySuppId(id);
	// // model.addAttribute("OrderDetails", adminService.getAllOrderD());
	// model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));
	//
	// return "supplier/orderDetails";
	// }

	// Navigate to truckDetails page containing all the truck information
	// related to the supplier currently logged in
	// @GetMapping("/supplier/truckDetails/{id}")
	// public String suppTruckDetails(Model model, @PathVariable("id") int id) {
	// model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));
	//
	// List<OrderDetails> od = suppService.getAllOrdersBySuppId(id);
	// List<Integer> driverid = new ArrayList<Integer>();
	// for (OrderDetails orderDetails : od) {
	// driverid.add(orderDetails.getDriverId());
	// }
	//
	// List<TruckDetails> td = new ArrayList<TruckDetails>();
	// for (Integer did : driverid) {
	// td.add(truckDetailsRepo.findById(did).get());
	// }
	// model.addAttribute("td", td);
	//
	// return "supplier/truckDetails";
	// }

}
