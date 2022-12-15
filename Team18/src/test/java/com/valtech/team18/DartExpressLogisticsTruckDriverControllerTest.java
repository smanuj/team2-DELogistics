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
//@SpringBootTest
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@AutoConfigureMockMvc
//public class DartExpressLogisticsTruckDriverControllerTest {
//	
//	@Autowired
//	  private MockMvc mvc;
//	
//	 @Test
//   public void testTruckDriverHomePage() throws Exception{
//		 String id="1";
//	 
//       mvc.perform(get("/truckDriver/truckDriverHome/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//   }
//	 @Test
//     public void testTruckDriverRegisterPage() throws Exception{
//         mvc.perform(get("/truckDriver/driverRegister")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	
//
//
//}
