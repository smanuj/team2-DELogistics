//package com.valtech.team18;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@AutoConfigureMockMvc
//public class DartExpressLogisticsApplicationControllerTest {
//	@Autowired
//	  private MockMvc mvc;
//	 @Test
//     public void testLoginPage() throws Exception{
//         mvc.perform(get("/login")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//
//	 @Test
//     public void testMainHomePage() throws Exception{
//         mvc.perform(get("/")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 @Test
//     public void testAboutUsPage() throws Exception{
//         mvc.perform(get("/aboutUs")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//
//	 @Test
//     public void testContactUsPage() throws Exception{
//         mvc.perform(get("/contactUs")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 @Test
//     public void testForgotPasswordPage() throws Exception{
//         mvc.perform(get("/forgotPassword")).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 @Test
//     public void testNewSupplierPasswordPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/newPassword/supp/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 @Test
//     public void testNewDriverPasswordPage() throws Exception{
//		 String id="1";
//         mvc.perform(get("/newPassword/driver/{id}",id)).andDo(print()).andExpect(content().string("")).andExpect(status().isOk());
//     }
//	 
//	 
//}
