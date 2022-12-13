//package com.valtech.team18;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@AutoConfigureMockMvc
//public class DartExpressLogisticsControllerTests {
//	
//	@Autowired
//	  private MockMvc mvc;
//	
//	 @Test
//     public void testMainHomePage() throws Exception{
//         mvc.perform(get("/")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	
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
//	 @Test
//     public void testAdminHomePage() throws Exception{
//         mvc.perform(get("/admin/adminHome")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testAdminOrderDetailsPage() throws Exception{
//         mvc.perform(get("/admin/orderDetails")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testAdminSupplierDetailsPage() throws Exception{
//         mvc.perform(get("/admin/supplierDetails")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testAdminTruckDetailsPage() throws Exception{
//         mvc.perform(get("/admin/truckDetails")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testAdminDriverApprovalPage() throws Exception{
//         mvc.perform(get("/admin/driverApproval")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testAdminSupplierApprovalPage() throws Exception{
//         mvc.perform(get("/admin/supplierApproval")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testAdminNewOrderPage() throws Exception{
//         mvc.perform(get("/admin/newOrder")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testSupplierHomePage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/supplier/supplierHome/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testSupplierOrderDetailsPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/supplier/orderDetails/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 @Test
//     public void testSupplierTruckDetailsPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/supplier/truckDetails/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 @Test
//     public void testTruckDriverHomePage() throws Exception{
//		 String id="2";
//	 
//         mvc.perform(get("/truckDriver/truckDriverHome/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testTruckDriverOrderReceivedPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/truckDriver/ordersRecieved/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 @Test
//     public void testDriverSupplierDetailsPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/truckDriver/supplierDetails/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//
//	
//	 @Test
//     public void testAboutUsPage() throws Exception{
//         mvc.perform(get("/aboutUs")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//
//	 @Test
//     public void testContactUsPage() throws Exception{
//         mvc.perform(get("/contactUs")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 
//}
