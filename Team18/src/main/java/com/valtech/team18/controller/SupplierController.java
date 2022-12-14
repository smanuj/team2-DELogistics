package com.valtech.team18.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	SupplierDetailsRepo supplierDetailsRepo;

	@Autowired
	SupplierService suppService;

	// Navigate to supplier home page for a particular supplier id
	@GetMapping("/supplier/supplierHome/{id}")
	public String suppHome(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		String supplierName = supplierDetailsRepo.findById(id).get().getSuppName();
		model.addAttribute("sName", supplierName);
		return "supplier/supplierHome";
	}

	// Navigate to orderDetails page containing all the orders related to the
	// supplier currently logged in
	@GetMapping("/supplier/orderDetails/{id}")
	public String suppOrderDetails(Model model, @PathVariable("id") int id) {

		suppService.getAllOrdersBySuppId(id);
		// model.addAttribute("OrderDetails", adminService.getAllOrderD());
		model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));

		return "supplier/orderDetails";
	}

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
