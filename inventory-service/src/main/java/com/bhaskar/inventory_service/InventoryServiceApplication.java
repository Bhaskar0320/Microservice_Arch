package com.bhaskar.inventory_service;

import com.bhaskar.inventory_service.model.*;
import com.bhaskar.inventory_service.repository.*;
import com.bhaskar.inventory_service.service.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Iphone 13");
			inventory.setQuantity(100);


			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("Iphone 13 max pro");
			inventory2.setQuantity(0);
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
	}
}
