package com.valtech.team18;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class DartExpressLogisticsAdminControllerTest {
	
	@Autowired
	  private MockMvc mvc;
	
	 @Test
     public void testAdminHomePage() throws Exception{
         mvc.perform(get("/admin/adminHome")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	 
	 @Test
     public void testAdminOrderDetailsPage() throws Exception{
         mvc.perform(get("/admin/orderDetails")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	 @Test
     public void testAdminSupplierDetailsPage() throws Exception{
         mvc.perform(get("/admin/supplierDetails")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	 @Test
     public void testAdminTruckDetailsPage() throws Exception{
         mvc.perform(get("/admin/truckDetails")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	 @Test
     public void testAdminDriverApprovalPage() throws Exception{
         mvc.perform(get("/admin/driverApproval")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	 @Test
     public void testAdminSupplierApprovalPage() throws Exception{
         mvc.perform(get("/admin/supplierApproval")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	 @Test
     public void testAdminNewOrderPage() throws Exception{
         mvc.perform(get("/admin/newOrder")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
}
