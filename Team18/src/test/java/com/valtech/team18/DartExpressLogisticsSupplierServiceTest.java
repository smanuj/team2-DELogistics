package com.valtech.team18;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
public class DartExpressLogisticsSupplierServiceTest {

}
