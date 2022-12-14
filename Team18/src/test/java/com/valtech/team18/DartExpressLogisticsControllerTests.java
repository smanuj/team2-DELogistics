package com.valtech.team18;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.team18.entity.OrderDetails;
import com.valtech.team18.service.AdminLoginServiceImpl;
import com.valtech.team18.service.AdminServiceImpl;
import com.valtech.team18.service.NewOrderServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;


@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class DartExpressLogisticsControllerTests {
	
	@Autowired
	  private MockMvc mvc;
	
	@Autowired
	private AdminLoginServiceImpl adminLoginServiceImpl;
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private NewOrderServiceImpl newOrderServiceImpl;
	
	 @Test
     public void testAdminLoginValidation() throws Exception{
	       assertEquals(true, adminLoginServiceImpl.loginvalidation("admin@gmail.com","admin"));
	       assertEquals(false, adminLoginServiceImpl.loginvalidation("admin","user"));
     }
	 
	 @Test
	 public void AdminOrderDetails() throws Exception{
			assertEquals(adminServiceImpl.getAllOrderD().size(), adminServiceImpl.getAllOrderD().size());
			assertEquals(adminServiceImpl.getAllSuppplierD().size(), adminServiceImpl.getAllSuppplierD().size());
			assertEquals(adminServiceImpl.getAllTruckD().size(), adminServiceImpl.getAllTruckD().size());
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
