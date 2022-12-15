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
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;
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
	private SupplierDetailsRepo supplierDetailsRepo;
	
	@Autowired
	private TruckDetailsRepo truckDetailsRepo;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private NewOrderService newOrderService;
	
	@Test
	public void testAdminServiceOrderDetails() throws Exception{
		List<OrderDetails> od=orderDetailsRepo.findAll();
		int x=od.size();
		System.out.println("x= "+x);
		OrderDetails od2 = new OrderDetails("test1234", LocalDateTime.now(), "Davangere", 789456120L, "Qwerty2", 12, 12);
		newOrderService.saveNew(od2);
		od=orderDetailsRepo.findAll();
		int y=od.size();
		System.out.println("y= "+y);
		assertEquals(x+1, y);
		newOrderService.deleteOrder(od2.getOrderId());
//		orderDetailsRepo.deleteByOrderId(od2.getOrderId());
//		orderDetailsRepo.deleteByCustName("test123");
		od=orderDetailsRepo.findAll();
		int z=od.size();
		System.out.println("z= "+z);
//		assertEquals(y-1, z);
		
		
		
	}
	
//	@Test
//	public void testAdminServiceSupplierDetails() throws Exception{
//		List<SupplierDetails> sd=supplierDetailsRepo.findAll();
//		int x=sd.size();
//		SupplierDetails sd2=new SupplierDetails(12, "santhu", "santhu@gmail.com", "password", "Davangere", 9880821607L, true, "2565", 98988589967L);
//		supplierDetailsRepo.save(sd2);
//		sd=supplierDetailsRepo.findAll();
//		int y=sd.size();
//		assertEquals(x+1, y);
////		supplierDetailsRepo.delete(sd2);
////		sd=supplierDetailsRepo.findAll();
////		int z=sd.size();
////		assertEquals(x, z);
//	}

//	@Test
//	public void testAdminServiceTruckDetails() throws Exception{
//		List<TruckDetails> td=truckDetailsRepo.findAll();
//		int x=td.size();
//		TruckDetails td2=new TruckDetails(3, "santhu", "santhu12", 6361748785L, 7.90, "santhu@gmail.com", true, true);
//		truckDetailsRepo.save(td2);
//		td=truckDetailsRepo.findAll();
//		int y=td.size();
//		assertEquals(x+1, y);
//		
//	}
//	
}
