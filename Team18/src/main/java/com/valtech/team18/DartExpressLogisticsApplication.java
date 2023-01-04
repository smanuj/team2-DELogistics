package com.valtech.team18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DartExpressLogisticsApplication  extends SpringBootServletInitializer  {

	 @Override  
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	    { 


	    return application.sources(DartExpressLogisticsApplication.class);  
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(DartExpressLogisticsApplication.class, args);
	}

}
