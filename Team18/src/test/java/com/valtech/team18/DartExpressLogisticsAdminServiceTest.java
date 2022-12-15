package com.valtech.team18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.service.AdminService;
import com.valtech.team18.service.NewOrderService;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class DartExpressLogisticsAdminServiceTest {
	@Autowired
	  private MockMvc mvc;
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo; 
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private NewOrderService newOrderService;
	
	@Test
	public void testAdminServiceDetails() throws Exception{
		List<OrderDetails> od=orderDetailsRepo.findAll();
		int x=od.size();
		OrderDetails od2 = new OrderDetails("test", LocalDateTime.now(), "Davangere", 789456120L, "Qwerty2");
		newOrderService.saveNew(od2);
		List<OrderDetails> od4=orderDetailsRepo.findAll();
		int y=od4.size();
		assertEquals(x+1, y);
		
		
		
	}
//	 @Test
//	 public void testSupplierRegistration() throws Exception{
//		 List<SupplierDetails> sd=supplierDetailsRepo.findAll();
//		 int a=sd.size();
//		 supplierService.register("username", "email", "password", "fromAddress", "6361748785", "25358698967");
//		 sd=supplierDetailsRepo.findAll();
//		 int b=sd.size();
//		 SupplierDetails sd2=supplierDetailsRepo.findByEmail("email");
//		 assertEquals(a+1, b);
//		 supplierDetailsRepo.deleteById(sd2.getSuppId());
//		 assertEquals(b-1, a);
//		 
//	 }
	//	 @Test
//	 public void AdminOrderDetails() throws Exception{
//			assertEquals(adminService.getAllOrderD().size(), adminService.getAllOrderD().size());
//			assertEquals(adminService.getAllSuppplierD().size(), adminService.getAllSuppplierD().size());
//			assertEquals(adminService.getAllTruckD().size(), adminService.getAllTruckD().size());
//	  }
}
