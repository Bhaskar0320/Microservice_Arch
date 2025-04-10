package com.bhaskar.inventory_service.repository;

import com.bhaskar.inventory_service.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    Optional<Inventory> findBySkuCode(String skuCode); // ✅ Corrected

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}