package com.valtech.team18.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.service.TruckDetailsService;

@Controller
public class TruckDriverController {

	@Autowired
	TruckDetailsService tdService;

	// Navigate to Driver home page for a particular driver id
	@GetMapping("/truckDriver/truckDriverHome/{id}")
	public String driverHome(Model model, @PathVariable("id") int id) {
		model.addAttribute("id", id);
		// String driverName =
		// truckDetailsRepo.findById(id).get().getDriverName();
		// model.addAttribute("dName", driverName);
		return "truckDriver/truckDriverHome";
	}

	// Navigate to orderDetails page containing all the order information
	// assigned to the driver currently logged in
	@GetMapping("/truckDriver/ordersRecieved/{id}")
	public String driverOrdersRecieved(Model model, @PathVariable("id") int id) {
		model.addAttribute("OrderDetails", tdService.getAllOrdersByDriverId(id));

		return "truckDriver/ordersRecieved";
	}

	// Navigate to supplierDetails page containing all the Supplier related
	// information required by the driver currently logged in
	@GetMapping("/truckDriver/supplierDetails/{id}")
	public String driverSupplierDetails(Model model, @PathVariable("id") int id) {
		model.addAttribute("OrderDetails", tdService.getAllOrdersByDriverId(id));
		List<OrderDetails> od = tdService.getAllOrdersByDriverId(id);
		List<Integer> suppId = new ArrayList<Integer>();
		for (OrderDetails orderDetails : od) {
			suppId.add(orderDetails.getSuppId());

		}
		List<SupplierDetails> sd = new ArrayList<SupplierDetails>();
		for (Integer sid : suppId) {
			// sd.add(supplierDetailsRepo.findById(sid).get());

		}
		model.addAttribute("sd", sd);

		return "truckDriver/supplierDetails";
	}

}
