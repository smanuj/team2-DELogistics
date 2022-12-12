package com.valtech.team18.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.service.AdminLoginService;
import com.valtech.team18.service.AdminService;
import com.valtech.team18.service.NewOrderService;
import com.valtech.team18.service.RegisterService;
import com.valtech.team18.service.SendMail;
import com.valtech.team18.service.SupplierService;
import com.valtech.team18.service.TruckDetailsService;

@Controller
public class AdminController {

	@Autowired
	AdminLoginService adminLoginService;

	@Autowired
	AdminService adminService;

	@Autowired
	SupplierService suppService;

	@Autowired
	TruckDetailsService tdService;

	@Autowired
	SendMail sm;

	@Autowired
	RegisterService registerService;

	@Autowired
	NewOrderService newOrderService;

	// Navigate to Home page for Admin
	@GetMapping("/admin/adminHome")
	public String adminHome() {

		return "admin/adminHome";
	}

	// Navigate to Order Details page for Admin
	@GetMapping("/admin/orderDetails")
	public String orderDetails(Model model) {
		model.addAttribute("OrderDetails", adminService.getAllOrderD());
		return "admin/orderDetails";
	}

	// Navigate to Supplier Details page for Admin
	@GetMapping("/admin/supplierDetails")
	public String supDetails(Model model) {
		model.addAttribute("SupplierDetails", suppService.getApprovedSupplier());
		return "admin/supplierDetails";
	}

	// Navigate to Truck Details page for Admin
	@GetMapping("/admin/truckDetails")
	public String truckDetails(Model model) {
		model.addAttribute("TruckDetails", tdService.getApprovedDriver());
		return "admin/truckDetails";
	}

	// // Navigate to Truck Details page for Admin
	// @PostMapping("/admin/truckDetails")
	// public String truckDetailsMail(Model model) {
	// model.addAttribute("TruckDetails", tdService.getAllTruckD());
	// String sample = "This is a sample text";
	// String email = "smanuj007@gmail.com";
	// // String email="smanuj007@gmail.com";
	// sm.sendMail(email, sample);
	// return "admin/truckDetails";
	// }

	// Navigate to Driver Approval page for Admin so that admin can proceed to
	// Approve/Reject the pending Driver details
	@GetMapping("/admin/driverApproval")
	public String driverApp(Model model) {
		// model.addAttribute("PendingDriver", registerService.getDriverList());
		model.addAttribute("PendingDriver", tdService.getPendingDriver());

		return "admin/driverApproval";
	}

	// Approve driver credentials with that particular driver_id
	@PostMapping("/admin/driverApproval/{id}")
	public String driverAR(@PathVariable("id") int id, Model model) {
		System.out.println(id);

		tdService.approvingDriver(id);

		// PendingDriver pd = pendingDriverRepo.findById(id).get();
		//
		// truckLoginService.saveNew(pd);
		// registerService.deleteDriver(pd);
		return "redirect:/admin/driverApproval";
	}

	// Navigate to Supplier Approval page for Admin so that admin can proceed to
	// Approve/Reject the pending Supplier details
	@GetMapping("/admin/supplierApproval")
	public String supplierApp(Model model) {
		model.addAttribute("PendingSupplier", suppService.getPendingSupplier());
		return "admin/supplierApproval";
	}

	// Approve supplier credentials with that particular supplier_id
	@PostMapping("/admin/supplierApproval/{id}")
	public String supplierAR(@PathVariable("id") int id, Model model) {
		System.out.println(id);

		suppService.approvingSupplier(id);

		// PendingSupplier ps = pendingSupplierRepo.findById(id).get();

		// suppLoginService.saveNew(ps);
		// registerService.deleteSupp(ps);

		return "redirect:/admin/supplierApproval";
	}

	// Reject and delete the supplier details for a particular supplier id
	@PostMapping("/admin/supplierApproval/sdelete/{id}")
	public String supplierDel(@PathVariable("id") int id, Model model) {
		System.out.println(id);

		suppService.deleteRejectedSupplier(id);

		// PendingSupplier ps = pendingSupplierRepo.findById(id).get();
		// registerService.deleteSupp(ps);
		return "redirect:/admin/supplierApproval";
	}

	// Reject and delete the driver details for a particular driver id
	@PostMapping("/admin/driverApproval/ddelete/{id}")
	public String driverDel(@PathVariable("id") int id, Model model) {
		// PendingDriver pd = pendingDriverRepo.findById(id).get();

		tdService.deleteRejectedDriver(id);

		// registerService.deleteDriver(pd);
		return "redirect:/admin/driverApproval";
	}

	// Navigate to a page where Admin can add new order details
	@GetMapping("/admin/newOrder")
	public String newOrder(Model model) {

		model.addAttribute("SupplierDetails", suppService.getApprovedSupplier());
		model.addAttribute("TruckDetails", tdService.getApprovedDriver());
		//
		return "admin/newOrder";
	}

	// Save all the details required to create a New Order including assigning
	// supplier and driver to each order
	@PostMapping("/admin/newOrder")
	public String newOrder(@RequestParam("custName") String custName, @RequestParam("toAddress") String toAddress,
			@RequestParam("phNum") String phNum, @RequestParam("orderType") String orderType,
			@RequestParam("suppid") int suppid, @RequestParam("driverid") int driverid, ModelMap model)
			throws Exception, NumberFormatException, MissingServletRequestParameterException {
		// try {
		// System.out.println(suppid);
		// if (custName.equals(null) || toAddress.equals(null) ||
		// orderType.equals(null) || (phNum == "")
		// || phNum.equals(null) || (custName == "") || (toAddress == "") ||
		// (orderType == "")) {
		// String str = "Fields cannot be Empty";
		// model.addAttribute("mess", str);
		// return "/admin/newOrder";
		// } else {
		// long phno = Long.parseLong(phNum);
		//
		// LocalDateTime time = LocalDateTime.now();
		// OrderDetails od = new OrderDetails(custName, time, toAddress, phno,
		// orderType, suppid, driverid);
		// newOrderService.saveNew(od);
		// return "redirect:/admin/orderDetails";
		//
		// }
		// } catch (NumberFormatException nfe) {
		// String str = "Enter Fileds Correctly";
		// model.addAttribute("mess", str);
		// return "/admin/newOrder";
		// } catch (Exception nfe) {
		// String str = "Enter Fileds Correctly";
		// model.addAttribute("mess", str);
		// return "/admin/newOrder";
		// }

		try {

			long phno = Long.parseLong(phNum);
			LocalDateTime time = LocalDateTime.now();
			OrderDetails od = new OrderDetails(custName, time, toAddress, phno, orderType, suppid, driverid);
			newOrderService.saveNew(od);
			return "redirect:/admin/orderDetails";

		} catch (Exception ex) {
			System.out.println(ex);
			
			String str = "Enter Fileds Correctly";
			 model.addAttribute("mess", str);
			 return "/admin/newOrder";
			
		}

	}

}
