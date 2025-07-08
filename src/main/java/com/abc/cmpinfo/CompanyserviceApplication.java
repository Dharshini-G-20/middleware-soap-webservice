package com.abc.cmpinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application Class
 * BITS Pilani - Middleware Technologies Assignment
 * Company Information SOAP Web Service
 */
@SpringBootApplication
public class CompanyServiceApplication {
    
    public static void main(String[] args) {
        System.out.println("Starting Company SOAP Web Service...");
        SpringApplication.run(CompanyServiceApplication.class, args);
        System.out.println("Company SOAP Web Service started successfully!");
        System.out.println("WSDL available at: http://localhost:8080/ws/company.wsdl");
    }
}

