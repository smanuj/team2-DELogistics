//package com.valtech.team18.controller;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.valtech.team18.entity.OrderDetails;
//import com.valtech.team18.entity.PendingDriver;
//import com.valtech.team18.entity.PendingSupplier;
//import com.valtech.team18.entity.SupplierDetails;
//import com.valtech.team18.entity.TruckDetails;
//import com.valtech.team18.repo.PendingDriverRepo;
//import com.valtech.team18.repo.PendingSupplierRepo;
//import com.valtech.team18.repo.SupplierDetailsRepo;
//import com.valtech.team18.repo.TruckDetailsRepo;
//import com.valtech.team18.service.AdminLoginService;
//import com.valtech.team18.service.AdminService;
//import com.valtech.team18.service.NewOrderService;
//import com.valtech.team18.service.RegisterService;
//import com.valtech.team18.service.SendMail;
//import com.valtech.team18.service.SupplierLoginService;
//import com.valtech.team18.service.SupplierService;
//import com.valtech.team18.service.TruckDetailsService;
//import com.valtech.team18.service.TruckLoginService;
//
//@Controller()
//public class WebpageController {
//
//	@Autowired
//	private AdminService adminService;
//
//	@Autowired
//	private TruckDetailsService tdService;
//
//	@Autowired
//	private SupplierService suppService;
//
//	@Autowired
//	private SupplierLoginService suppLoginService;
//
//	@Autowired
//	private AdminLoginService adminLoginService;
//
//	@Autowired
//	private TruckLoginService truckLoginService;
//
//	@Autowired
//	private NewOrderService newOrderService;
//
//	@Autowired
//	private SupplierDetailsRepo supplierDetailsRepo;
//
//	@Autowired
//	private TruckDetailsRepo truckDetailsRepo;
//	
//	@Autowired
//	private SendMail sm;
//
//	// Navigate to Main Home Page
//	@GetMapping("/")
//	public String mainHomePage() {
//
//		return "mainHomePage";
//	}
//
//	// Navigate to Login Page for Admin
//	@GetMapping("/admin/adminLogin")
//	public String adminLogin() {
//
//		return "admin/adminLogin";
//	}
//
//	// Submit username and password for validating Admin Login
//	@PostMapping("/admin/adminLogin")
//	public String adminLoginVal(@RequestParam("email") String email, @RequestParam("password") String password,
//			ModelMap model) {
//		if (adminLoginService.loginvalidation(email, password) == true) {
//			return "redirect:/admin/adminHome";
//		} else {
//			String message = "Invalid Username and Password";
//			System.out.println(message);
//			model.addAttribute("mess", message);
//			return "admin/adminLogin";
//		}
//	}
//
//	// Navigate to Login Page for Supplier
//	@GetMapping("/supplier/supplierLogin")
//	public String suppLogin() {
//
//		return "supplier/supplierLogin";
//	}
//
//	// Submit username and password for validating Admin Login
//	@PostMapping("/supplier/supplierLogin")
//	public String suppLoginVal(@RequestParam("email") String email, @RequestParam("password") String password,
//			ModelMap model) {
//		if (suppLoginService.loginvalidation(email, password) == true) {
//			int id = supplierDetailsRepo.findBySuppName(email).getSuppId();
//			return "redirect:/supplier/supplierHome/" + id;
//		} else {
//			String message = "Invalid Username and Password";
//			System.out.println(message);
//			model.addAttribute("mess", message);
//			return "supplier/supplierLogin";
//		}
//	}
//
//	// Navigate to Register Page for Supplier
//	@GetMapping("/supplier/supplierRegister")
//	public String supplierRegister() {
//		return "supplier/supplierRegister";
//	}
//
//	// Submit all the details in the registration page
//	@PostMapping("/supplier/supplierRegister")
//	public String supplierReg(@RequestParam("username") String username, @RequestParam("password") String password,
//			@RequestParam("confirmpassword") String cpassword, @RequestParam("fromAddress") String fromAddress,
//			@RequestParam("contactNumber") String contactNumber, ModelMap model) throws Exception {
////		try {
//////			if (username.equals(null) || password.equals(null) || cpassword.equals(null) || fromAddress.equals(null)
//////					|| contactNumber.equals(null) || (username == "") || (password == "") || (cpassword == "")
//////					|| (fromAddress == "") || (contactNumber == "")) {
//////				String str = "Fields cannot be Empty";
//////				model.addAttribute("mess", str);
//////				return "/supplier/supplierRegister";
//////			} else
//////			if{
////
////				if (password.equals(cpassword)) {
////					PendingSupplier pd = new PendingSupplier(username, password, fromAddress, contactNumber);
////
////					int i = registerService.RegisterSupplier(pd);
////
////					if (i == 1) {
////						String str = "Username already Exists";
////						model.addAttribute("mess", str);
////						return "/supplier/supplierRegister";
////					}
////
////					return "redirect:/supplier/supplierLogin";
////				} else {
////					String str = "Entered Password do not Match";
////					model.addAttribute("mess", str);
////					return "/supplier/supplierRegister";
////				}
//////			}
////		} catch (Exception ex) {
////			String str = "Enter Fields Correctly";
////			model.addAttribute("mess", str);
////			return "/supplier/supplierRegister";
////		}
//		
//		
//	}
//
//	// Navigate to Login Page for Truck Driver
//	@GetMapping("/truckDriver/driverLogin")
//	public String truckDriverLogin() {
//
//		return "truckDriver/driverLogin";
//
//	}
//
//	// Submit all the details in the login page
//	@PostMapping("/truckDriver/driverLogin")
//	public String truckLoginVal(@RequestParam("email") String email, @RequestParam("password") String password,
//			ModelMap model) {
//		if (truckLoginService.loginvalidation(email, password) == true) {
//			int id = truckDetailsRepo.findByDriverName(email).getTruckId();
//			return "redirect:/truckDriver/truckDriverHome/" + id;
//		} else {
//
//			String message = "Invalid Username and Password";
//			System.out.println(message);
//			model.addAttribute("mess", message);
//			return "truckDriver/driverLogin";
//		}
//	}
//
//	// Navigate to Register Page for Truck Driver
//	@GetMapping("/truckDriver/driverRegister")
//	public String driverRegister() {
//		return "truckDriver/driverRegister";
//	}
//
//	// Submit all the details in the registration page
//	@PostMapping("/truckDriver/driverRegister")
//	public String driverReg(@RequestParam("username") String username, @RequestParam("password") String password,
//			@RequestParam("confirmpassword") String cpassword, @RequestParam("driverNumber") long driverNumber,
//			ModelMap model) throws Exception {
//
//		try {
//			if (username.equals(null) || password.equals(null) || cpassword.equals(null) || (driverNumber == 0L)
//					|| Long.valueOf(driverNumber) == null || (username == "") || (password == "")
//					|| (cpassword == "")) {
//				String str = "Fields cannot be Empty";
//				model.addAttribute("mess", str);
//				return "/truckDriver/driverRegister";
//			} else {
//
//				if (password.equals(cpassword)) {
//					PendingDriver pd = new PendingDriver(username, password, driverNumber);
//
//					int i = registerService.RegisterDriver(pd);
//
//					if (i == 1) {
//						String str = "Username already Exists";
//						model.addAttribute("mess", str);
//						return "/truckDriver/driverRegister";
//					}
//
//					return "redirect:/truckDriver/driverLogin";
//				} else {
//					String str = "Entered Password do not Match";
//					model.addAttribute("mess", str);
//					return "/truckDriver/driverRegister";
//				}
//			}
//
//		} catch (Exception ex) {
//			String str = "Enter Fields Correctly";
//			model.addAttribute("mess", str);
//			return "/truckDriver/driverRegister";
//		}
//
//	}
//
//	// Navigate to Home page for Admin
//	@GetMapping("/admin/adminHome")
//	public String adminHome() {
//
//		return "admin/adminHome";
//	}
//
//	// Navigate to Order Details page for Admin
//	@GetMapping("/admin/orderDetails")
//	public String orderDetails(Model model) {
//		model.addAttribute("OrderDetails", adminService.getAllOrderD());
//		return "admin/orderDetails";
//	}
//
//	// Navigate to Supplier Details page for Admin
//	@GetMapping("/admin/supplierDetails")
//	public String supDetails(Model model) {
//		model.addAttribute("SupplierDetails", suppService.getAllSuppplierD());
//		return "admin/supplierDetails";
//	}
//
//	// Navigate to Truck Details page for Admin
//	@GetMapping("/admin/truckDetails")
//	public String truckDetails(Model model) {
//		model.addAttribute("TruckDetails", tdService.getAllTruckD());
//		return "admin/truckDetails";
//	}
//	
//	// Navigate to Truck Details page for Admin
//	@PostMapping("/admin/truckDetails")
//	public String truckDetailsMail(Model model) {
//		model.addAttribute("TruckDetails", tdService.getAllTruckD());
//		String body="This is a sample text";
//		String subject="This is a sample text";
//		String email="harshithvishwanathan927@gmail.com";
////		String email="smanuj007@gmail.com";
//		sm.sendMail(email,subject, body);
//		return "admin/truckDetails";
//	}
//
//	// Navigate to Driver Approval page for Admin so that admin can proceed to
//	// Approve/Reject the pending Driver details
//	@GetMapping("/admin/driverApproval")
//	public String driverApp(Model model) {
//		model.addAttribute("PendingDriver", registerService.getDriverList());
//		return "admin/driverApproval";
//	}
//
//	// Approve driver credentials with that particular driver_id
//	@PostMapping("/admin/driverApproval/{id}")
//	public String driverAR(@PathVariable("id") int id, Model model) {
//		System.out.println(id);
//
//		PendingDriver pd = pendingDriverRepo.findById(id).get();
//
//		truckLoginService.saveNew(pd);
//		registerService.deleteDriver(pd);
//		return "redirect:/admin/driverApproval";
//	}
//
//	// Navigate to Supplier Approval page for Admin so that admin can proceed to
//	// Approve/Reject the pending Supplier details
//	@GetMapping("/admin/supplierApproval")
//	public String supplierApp(Model model) {
//		model.addAttribute("PendingSupplier", registerService.getSupplierList());
//		return "admin/supplierApproval";
//	}
//
//	// Approve supplier credentials with that particular supplier_id
//	@PostMapping("/admin/supplierApproval/{id}")
//	public String supplierAR(@PathVariable("id") int id, Model model) {
//		System.out.println(id);
//
//		PendingSupplier ps = pendingSupplierRepo.findById(id).get();
//
//		suppLoginService.saveNew(ps);
//		registerService.deleteSupp(ps);
//
//		return "redirect:/admin/supplierApproval";
//	}
//
//	// Reject and delete the supplier details for a particular supplier id
//	@PostMapping("/admin/supplierApproval/sdelete/{id}")
//	public String supplierDel(@PathVariable("id") int id, Model model) {
//		System.out.println(id);
//
//		PendingSupplier ps = pendingSupplierRepo.findById(id).get();
//		registerService.deleteSupp(ps);
//		return "redirect:/admin/supplierApproval";
//	}
//
//	// Reject and delete the driver details for a particular driver id
//	@PostMapping("/admin/driverApproval/ddelete/{id}")
//	public String driverDel(@PathVariable("id") int id, Model model) {
//		PendingDriver pd = pendingDriverRepo.findById(id).get();
//
//		registerService.deleteDriver(pd);
//		return "redirect:/admin/driverApproval";
//	}
//
//	// Navigate to a page where Admin can add new order details
//	@GetMapping("/admin/newOrder")
//	public String newOrder(Model model) {
//
//		model.addAttribute("SupplierDetails", suppService.getAllSuppplierD());
//		model.addAttribute("TruckDetails", tdService.getAllTruckD());
//		//
//		return "admin/newOrder";
//	}
//
//	// Save all the details required to create a New Order including assigning
//	// supplier and driver to each order
//	@PostMapping("/admin/newOrder")
//	public String newOrder(@RequestParam("custName") String custName, @RequestParam("toAddress") String toAddress,
//			@RequestParam("phNum") String phNum, @RequestParam("orderType") String orderType,
//			@RequestParam("suppid") int suppid, @RequestParam("driverid") int driverid, ModelMap model)
//			throws Exception, NumberFormatException,MissingServletRequestParameterException {
//		try {
//			System.out.println(suppid);
//			if (custName.equals(null) || toAddress.equals(null) || orderType.equals(null) || (phNum == "")
//					|| phNum.equals(null) || (custName == "") || (toAddress == "") || (orderType == "")) {
//				String str = "Fields cannot be Empty";
//				model.addAttribute("mess", str);
//				return "/admin/newOrder";
//			} else {
//				long phno = Long.parseLong(phNum);
//
//				LocalDateTime time = LocalDateTime.now();
//				OrderDetails od = new OrderDetails(custName, time, toAddress, phno, orderType, suppid, driverid);
//				newOrderService.saveNew(od);
//				return "redirect:/admin/orderDetails";
//
//			}
//		} catch (NumberFormatException nfe) {
//			String str = "Enter Fileds Correctly";
//			model.addAttribute("mess", str);
//			return "/admin/newOrder";
//		} 
//		catch (Exception nfe) {
//			String str = "Enter Fileds Correctly";
//			model.addAttribute("mess", str);
//			return "/admin/newOrder";
//		}
//		
//
//	}
//
//	// Navigate to supplier home page for a particular supplier id
//	@GetMapping("/supplier/supplierHome/{id}")
//	public String suppHome(@PathVariable("id") int id, Model model) {
//		model.addAttribute("id", id);
//		String supplierName = supplierDetailsRepo.findById(id).get().getSuppName();
//		model.addAttribute("sName", supplierName);
//		return "supplier/supplierHome";
//	}
//
//	// Navigate to orderDetails page containing all the orders related to the
//	// supplier currently logged in
//	@GetMapping("/supplier/orderDetails/{id}")
//	public String suppOrderDetails(Model model, @PathVariable("id") int id) {
//
//		suppService.getAllOrdersBySuppId(id);
//		// model.addAttribute("OrderDetails", adminService.getAllOrderD());
//		model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));
//
//		return "supplier/orderDetails";
//	}
//
//	// Navigate to truckDetails page containing all the truck information
//	// related to the supplier currently logged in
//	@GetMapping("/supplier/truckDetails/{id}")
//	public String suppTruckDetails(Model model, @PathVariable("id") int id) {
//		model.addAttribute("OrderDetails", suppService.getAllOrdersBySuppId(id));
//
//		List<OrderDetails> od = suppService.getAllOrdersBySuppId(id);
//		List<Integer> driverid = new ArrayList<Integer>();
//		for (OrderDetails orderDetails : od) {
//			driverid.add(orderDetails.getDriverId());
//		}
//
//		List<TruckDetails> td = new ArrayList<TruckDetails>();
//		for (Integer did : driverid) {
//			td.add(truckDetailsRepo.findById(did).get());
//		}
//		model.addAttribute("td", td);
//
//		return "supplier/truckDetails";
//	}
//
//	// Navigate to Driver home page for a particular driver id
//	@GetMapping("/truckDriver/truckDriverHome/{id}")
//	public String driverHome(Model model, @PathVariable("id") int id) {
//		model.addAttribute("id", id);
//		@SuppressWarnings("deprecation")
//		String driverName = truckDetailsRepo.getById(id).getDriverName();
//		model.addAttribute("dName", driverName);
//		return "truckDriver/truckDriverHome";
//	}
//
//	// Navigate to orderDetails page containing all the order information
//	// assigned to the driver currently logged in
//	@GetMapping("/truckDriver/ordersRecieved/{id}")
//	public String driverOrdersRecieved(Model model, @PathVariable("id") int id) {
//		model.addAttribute("OrderDetails", tdService.getAllOrdersByDriverId(id));
//
//		return "truckDriver/ordersRecieved";
//	}
//
//	// Navigate to supplierDetails page containing all the Supplier related
//	// information required by the driver currently logged in
//	@GetMapping("/truckDriver/supplierDetails/{id}")
//	public String driverSupplierDetails(Model model, @PathVariable("id") int id) {
//		model.addAttribute("OrderDetails", tdService.getAllOrdersByDriverId(id));
//		List<OrderDetails> od = tdService.getAllOrdersByDriverId(id);
//		List<Integer> suppId = new ArrayList<Integer>();
//		for (OrderDetails orderDetails : od) {
//			suppId.add(orderDetails.getSuppId());
//
//		}
//		List<SupplierDetails> sd = new ArrayList<SupplierDetails>();
//		for (Integer sid : suppId) {
//			sd.add(supplierDetailsRepo.findById(sid).get());
//
//		}
//		model.addAttribute("sd", sd);
//
//		return "truckDriver/supplierDetails";
//	}
//
//	// Assign supplier to every order based on the orderId and supplierId
//	@PostMapping("/admin/assignsup/{orderId}/{suppId}")
//	public String supplierAssign(@PathVariable("orderId") int orderId, @PathVariable("suppId") int suppId,
//			Model model) {
//		System.out.println(orderId);
//		System.out.println(suppId);
//
//		return "redirect:/admin/orderDetails";
//	}
//
//	// Navigate to the About Us page
//	@GetMapping("/aboutUs")
//	public String aboutUs() {
//		return "aboutUs";
//	}
//
//	// Navigate to the Contact Us page
//	@GetMapping("/contactUs")
//	public String contactUs() {
//		return "contactUs";
//	}
//
//}
