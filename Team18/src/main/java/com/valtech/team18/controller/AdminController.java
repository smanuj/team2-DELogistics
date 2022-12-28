package com.valtech.team18.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.UserRepo;
import com.valtech.team18.service.AdminLoginService;
import com.valtech.team18.service.AdminService;
import com.valtech.team18.service.MailMessage;
import com.valtech.team18.service.NewOrderService;
import com.valtech.team18.service.SendMail;
import com.valtech.team18.service.SupplierService;
import com.valtech.team18.service.TruckDetailsService;
import com.valtech.team18.service.UserDetailService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

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
	MailMessage mm;

	@Autowired
	NewOrderService newOrderService;

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserDetailService userDetailService;

	// Navigate to Home page for Admin
	@GetMapping("/admin/adminHome")
	public String adminHome() {
		logger.info("Fetching Home for Admin....");

		logger.debug("Successfully Fetched Home for Admin!");
		return "admin/adminHome";
	}

	// Navigate to Order Details page for Admin
	@GetMapping("/admin/orderDetails")
	public String orderDetails(Model model) {
		logger.info("Fetching Order Details for Admin....");

		model.addAttribute("OrderDetails", adminService.getAllOrderD());

		logger.debug("Successfully Fetched Order Details for Admin!");
		return "admin/orderDetails";
	}

	// Navigate to Supplier Details page for Admin
	@GetMapping("/admin/supplierDetails")
	public String supDetails(Model model) {
		model.addAttribute("SupplierDetails", userDetailService.getApprovedSupplier());
		return "admin/supplierDetails";
	}

	// Navigate to Truck Details page for Admin
	@GetMapping("/admin/truckDetails")
	public String truckDetails(Model model) {
		model.addAttribute("TruckDetails", userDetailService.getApprovedDriver());
		return "admin/truckDetails";
	}

	// Navigate to Driver Approval page for Admin so that admin can proceed to
	// Approve/Reject the pending Driver details
	@GetMapping("/admin/driverApproval")
	public String driverApp(Model model) {
		// model.addAttribute("PendingDriver", registerService.getDriverList());
		List<User> user = userRepo.findAllByApprovalFalseAndTruckIdNotNull();
		for (User user2 : user) {
			System.out.print(user2);
		}
		model.addAttribute("PendingDriver", user);
		System.out.println(tdService.getPendingDriver());

		return "admin/driverApproval";
	}

	// Approve driver credentials with that particular driver_id
	@PostMapping("/admin/driverApproval/{id}")
	public String driverAR(@PathVariable("id") int id, Model model) {
		logger.info("Fetching driverApproval for admin", id);
		System.out.println(id);

		tdService.approvingDriver(id);
		logger.debug("Successfully fetched {} driverApproval");

		return "redirect:/admin/driverApproval";
	}

	// Navigate to Supplier Approval page for Admin so that admin can proceed to
	// Approve/Reject the pending Supplier details
	@GetMapping("/admin/supplierApproval")
	public String supplierApp(Model model) {

		List<User> user = userRepo.findAllByApprovalFalseAndSuppIdNotNull();
		for (User user2 : user) {
			System.out.print(user2);
		}
		model.addAttribute("PendingSupplier", user);
		return "admin/supplierApproval";
	}

	// Approve supplier credentials with that particular supplier_id
	@PostMapping("/admin/supplierApproval/{id}")
	public String supplierAR(@PathVariable("id") int id, Model model) {
		logger.info("Fetching supplierApproval for admin {}", id);
		System.out.println(id);

		suppService.approvingSupplier(id);
		logger.debug("Successfully fetched {} supplierApproval");

		return "redirect:/admin/supplierApproval";
	}

	// Reject and delete the supplier details for a particular supplier id
	@PostMapping("/admin/supplierApproval/sdelete/{id}")
	public String supplierDel(@PathVariable("id") int id, Model model) {
		logger.info("Fetching supplierApproval for admin {}", id);
		System.out.println(id);

		suppService.deleteRejectedSupplier(id);
		logger.debug("Successfully fetched {} supplierApproval");
		return "redirect:/admin/supplierApproval";
	}

	// Reject and delete the driver details for a particular driver id
	@PostMapping("/admin/driverApproval/ddelete/{id}")
	public String driverDel(@PathVariable("id") int id, Model model) {
		// PendingDriver pd = pendingDriverRepo.findById(id).get();
		logger.info("Fetching driverApproval for admin {}", id);

		tdService.deleteRejectedDriver(id);
		logger.debug("Successfully fetched {} driverApproval");

		// registerService.deleteDriver(pd);
		return "redirect:/admin/driverApproval";
	}

	// Navigate to a page where Admin can add new order details
	@GetMapping("/admin/newOrder")
	public String newOrder(Model model) {
		logger.info("Fetching newOrder for admin {}");

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
		logger.info("Fetching new order");

		try {

			long phno = Long.parseLong(phNum);
			LocalDateTime time = LocalDateTime.now();
			OrderDetails od = new OrderDetails(custName, time, toAddress, phno, orderType, suppid, driverid);
			newOrderService.saveNew(od);
			return "redirect:/admin/orderDetails";

		} catch (Exception ex) {
			System.out.println(ex);

			String str = "Enter Fields Correctly";
			model.addAttribute("mess", str);
			return "/admin/newOrder";

		}

	}

	@PostMapping("/alert/{id}")
	public String alert(@PathVariable("id") int id) {
		logger.info("Sending alert to driver");
		try {
			adminService.sendAlertMail(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("Alert sent successfully to driver");
		return "redirect:/admin/truckDetails";
	}

}
