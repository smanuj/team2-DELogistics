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
import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.entity.User;
import com.valtech.team18.repo.OrderDetailsRepo;
import com.valtech.team18.repo.SupplierDetailsRepo;
import com.valtech.team18.repo.TruckDetailsRepo;
import com.valtech.team18.repo.UserRepo;
import com.valtech.team18.service.AdminService;
import com.valtech.team18.service.NewOrderService;
import com.valtech.team18.service.SupplierService;
import com.valtech.team18.service.TruckDetailsService;
import com.valtech.team18.service.UserDetailService;

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
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private TruckDetailsService truckDetailsService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserDetailService userDetailService;
	
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
		od=orderDetailsRepo.findAll();
		int z=od.size();
		System.out.println("z= "+z);
		assertEquals(y-1, z);
		
		
		
	}
	
	@Test
	public void testAdminServiceSupplierDetails() throws Exception{
		List<SupplierDetails> sd=supplierDetailsRepo.findAll();
		List<User> usr=userRepo.findAll();	
		int x=usr.size();
		SupplierDetails sd2=new SupplierDetails("santhu11","Davangere", 9880821607L, 98988589967L);
		supplierDetailsRepo.save(sd2);
		sd=supplierDetailsRepo.findAll();
		User usr1=new User("supplier@gmail.com","supp123",sd2);
		userRepo.save(usr1);
		usr=userRepo.findAll();
		int y=usr.size();
		assertEquals(x+1, y);
		userDetailService.deleteSupplier(usr1.getId());
		usr=userRepo.findAll();
		int z=usr.size();
		assertEquals(y-1, z);
	}

	@Test
	public void testAdminServiceTruckDetails() throws Exception{
		List<TruckDetails> td=truckDetailsRepo.findAll();
		List<User> usr=userRepo.findAll();
		int x=usr.size();
		TruckDetails td2=new TruckDetails("santhu1234", 6361748785L, 7.90);
		truckDetailsRepo.save(td2);
		td=truckDetailsRepo.findAll();
		User usr1=new User("Driver@gmail.com","driver123",td2);
		userRepo.save(usr1);
		usr=userRepo.findAll();
		int y=usr.size();
		assertEquals(x+1, y);
		userDetailService.deleteTruck(usr1.getId());
		usr=userRepo.findAll();
		int z=usr.size();
		assertEquals(y-1, z);
		
		
	}
	
}
