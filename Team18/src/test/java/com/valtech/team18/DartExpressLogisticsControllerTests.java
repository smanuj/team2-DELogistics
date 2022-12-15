package com.valtech.team18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.team18.entity.TruckDetails;
import com.valtech.team18.repo.TruckDetailsRepo;
import com.valtech.team18.service.AdminLoginService;
import com.valtech.team18.service.AdminService;
import com.valtech.team18.service.NewOrderService;
import com.valtech.team18.service.SupplierLoginService;
import com.valtech.team18.service.TruckDetailsService;
import com.valtech.team18.service.TruckLoginService;


@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class DartExpressLogisticsControllerTests {
	
	@Autowired
	  private MockMvc mvc;
	
	@Autowired
	private AdminLoginService adminLoginServiceImpl;
	
	@Autowired
	private AdminService adminServiceImpl;
	
	@Autowired
	private NewOrderService newOrderServiceImpl;
	
	@Autowired
	private SupplierLoginService supplierLoginServiceImpl;
	@Autowired
	private TruckLoginService truckLoginServiceImpl;
	
	@Autowired
	private TruckDetailsRepo truckDetailsRepo;
	
	@Autowired
	private TruckDetailsService truckDetailsService;
	
//	 @Test
//     public void testAdminLoginValidation() throws Exception{
//	       assertEquals(true, adminLoginServiceImpl.loginvalidation("admin@gmail.com","admin"));
//	       assertEquals(false, adminLoginServiceImpl.loginvalidation("admin","user"));
//     }
//	 
//	 @Test
//	 public void AdminOrderDetails() throws Exception{
//			assertEquals(adminServiceImpl.getAllOrderD().size(), adminServiceImpl.getAllOrderD().size());
//			assertEquals(adminServiceImpl.getAllSuppplierD().size(), adminServiceImpl.getAllSuppplierD().size());
//			assertEquals(adminServiceImpl.getAllTruckD().size(), adminServiceImpl.getAllTruckD().size());
//	  }
//	 
//	 @Test
//     public void testSupplierLoginValidation() throws Exception{
//	       assertEquals(true, supplierLoginServiceImpl.loginvalidation("santhoshkumara1204@gmail.com","$Santhu12"));
//	       assertEquals(false, supplierLoginServiceImpl.loginvalidation("supplier","user"));
//     }
//	 @Test
//     public void testDriverLoginValidation() throws Exception{
//	       assertEquals(true, truckLoginServiceImpl.loginvalidation("santhoshkumara1204@gmail.com","$Santhu12"));
//	       assertEquals(false, truckLoginServiceImpl.loginvalidation("truck","user"));
//     }
	 
	 @Test
     public void testDriverRegisteration() throws Exception{
		 List<TruckDetails> td = truckDetailsRepo.findAll();
		 int x =td.size();
		 System.out.println("x= "+x);
		 truckDetailsService.register("Test", "password", "anujsm112345@gmail.com", "789");
		  td = truckDetailsRepo.findAll();
		 int y = td.size();
		 System.out.println("y= "+y);
		 TruckDetails td2 = truckDetailsRepo.findByEmail("anujsm112345@gmail.com");
	       assertEquals(x+1, y);
	     truckDetailsRepo.deleteById(td2.getTruckId());
	     assertEquals(y-1, x);
     }
	
	 
//	 @Test
//	 public void saveNewOrderDetails(){
//		 LocalDateTime time=LocalDateTime.parse("2022-12-01T18:41:29.065");
//		 OrderDetails ord=new OrderDetails("santhosh",time, "davanagere", 9876543210L,"nonveg",8, 78);
//		 assertEquals(, newOrderServiceImpl.saveNew(ord));
//	  }
	
	
//	 @Test
//     public void testAdminLoginPage() throws Exception{
//         mvc.perform(get("/admin/adminLogin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 
//	 
//	 @Test
//     public void testSupplierLoginPage() throws Exception{
//         mvc.perform(get("/supplier/supplierLogin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testSupplierRegisterPage() throws Exception{
//         mvc.perform(get("/supplier/supplierRegister")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testDriverLoginPage() throws Exception{
//         mvc.perform(get("/truckDriver/driverLogin")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	
//	 @Test
//     public void testDriverRegisterPage() throws Exception{
//         mvc.perform(get("/truckDriver/driverRegister")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	
//	
//	 @Test
//     public void testSupplierTruckDetailsPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/supplier/truckDetails/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
	
	
	 
}
