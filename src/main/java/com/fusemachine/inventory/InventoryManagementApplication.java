package com.fusemachine.inventory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementApplication {

	private static final Logger log = LoggerFactory.getLogger(InventoryManagementApplication.class);

	public static void main(String[] args) {
		log.info("Application has started.");
		SpringApplication.run(InventoryManagementApplication.class);
	}


}