//                                      
//package com.valtech.team18;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.valtech.team18.entity.SupplierDetails;
//import com.valtech.team18.entity.TruckDetails;
//import com.valtech.team18.entity.User;
//import com.valtech.team18.repo.SupplierDetailsRepo;
//import com.valtech.team18.repo.TruckDetailsRepo;
//import com.valtech.team18.repo.UserRepo;
//import com.valtech.team18.service.AdminLoginService;
//import com.valtech.team18.service.AdminService;
//import com.valtech.team18.service.NewOrderService;
//import com.valtech.team18.service.SupplierLoginService;
//import com.valtech.team18.service.SupplierService;
//import com.valtech.team18.service.TruckDetailsService;
//import com.valtech.team18.service.TruckLoginService;
//import com.valtech.team18.service.UserDetailService;
//
//
//@SpringBootTest
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@AutoConfigureMockMvc
//public class DartExpressLogisticsLoginAndRegisterTests {
//	
//	@Autowired
//	  private MockMvc mvc;
//	
//	@Autowired
//	private AdminLoginService adminLoginService;
//	
//	@Autowired
//	private AdminService adminService;
//	
//	@Autowired
//	private NewOrderService newOrderService;
//	
//	@Autowired
//	private SupplierLoginService supplierLoginService;
//	
//	@Autowired
//	private SupplierDetailsRepo supplierDetailsRepo;
//	
//	@Autowired
//	private SupplierService supplierService;
//	
//	@Autowired
//	private TruckLoginService truckLoginService;
//	
//	@Autowired
//	private TruckDetailsRepo truckDetailsRepo;
//	
//	@Autowired
//	private TruckDetailsService truckDetailsService;
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Autowired
//	private UserDetailService userDetailService;
//	 @Test
//     public void testAdminLoginValidation() throws Exception{
//	       assertEquals(true, adminLoginService.loginvalidation("admin@gmail.com","admin"));
//	       assertEquals(false, adminLoginService.loginvalidation("admin","user"));
//     }
//	 
// 
//	 @Test
//     public void testSupplierLogin1Validation() throws Exception{
//		 List<User> usr=userRepo.findAllByApprovalTrueAndSuppIdNotNull();
//		 
//		 SupplierDetails sp=  new SupplierDetails("test", "Davangere", 63637878L,9693685L);
//		 User usr1=new User("test123456@test.com","testpass",sp);
//		 for (User user : usr) {
//			 if(user.getEmail().equals(usr1.getEmail())){
//				 
//			 }
//			 else{
//				 userRepo.save(usr1);
//			 }
//		}
//		 assertEquals(true, supplierLoginService.loginvalidation("test123456@test.com","testpass"));
//	     assertEquals(false, supplierLoginService.loginvalidation("supplier","user"));
//     }
//	 @Test
//     public void testDriverLoginValidation() throws Exception{
//		 List<User> usr=userRepo.findAllByApprovalTrueAndTruckIdNotNull();
//		 
//		 TruckDetails td=new TruckDetails("santhosh", 9698985852L, 8.25);
//		 User usr1=new User("driver123456@gmail.com","Santhu12",td);
//		 for(User user : usr){
//			 if(user.getEmail().equals(usr1.getEmail())){
//				 System.out.println("exists");
//			 }else{
//				 userRepo.save(usr1);
//			 }
//		 }
//	       assertEquals(true, truckLoginService.loginvalidation("driver123456@gmail.com","Santhu12"));
//	       assertEquals(false, truckLoginService.loginvalidation("truck","user"));
//     }
//	 @Test
//	 public void testSupplierRegistration() throws Exception{
//		 List<SupplierDetails> sd=supplierDetailsRepo.findAll();
//		 List<User> usr=userRepo.findAll();
//		 int a=usr.size();
//		supplierService.register("username1", "email2345@gmail.com", "password1", "fromAddresss", "6361748785", "25358698967");
//		 sd=supplierDetailsRepo.findAll();
//		 usr=userRepo.findAll(); 
//		 int b=usr.size();
//		 User usr1=userRepo.findByEmail("email2345@gmail.com");
//		 assertEquals(a+1, b);
//		 userDetailService.deleteSupplierRegister(usr1.getId());
//		 assertEquals(b-1, a);
//		 
//	 }
//	 
//	 @Test
//     public void testDriverRegisteration() throws Exception{
//		 List<TruckDetails> td = truckDetailsRepo.findAll();
//		 List<User> usr=userRepo.findAll();
//		 int x =usr.size();
//		 truckDetailsService.register("Test", "password", "anujsm11234567@gmail.com", "7896998962");
//		  td = truckDetailsRepo.findAll();
//		  usr=userRepo.findAll();
//		 int y = usr.size();
//		 User usr1=userRepo.findByEmail("anujsm11234567@gmail.com");
//	       assertEquals(x+1, y);
//	       userDetailService.deleteTruckDriverRegister(usr1.getId());
//	     assertEquals(y-1, x);
//    }	 
//}
