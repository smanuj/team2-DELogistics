package com.valtech.team18;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.team18.entity.SupplierDetails;
import com.valtech.team18.repo.SupplierDetailsRepo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class DartExpressLogisticsSupplierControllerTest {
	@Autowired
	  private MockMvc mvc;
	
	@Autowired
	SupplierDetails supplierDetails;
	//	 @Test
//     public void testSupplierHomePage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/supplier/supplierHome/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
	 
	 @Test
     public void testSupplierOrderDetailsPage() throws Exception{
		 int id1=supplierDetails.getSuppId();
		 String id=""+id1;
		 System.out.println("id is : "+id);
         mvc.perform(get("/supplier/orderDetails/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
     }
	 
	
}
