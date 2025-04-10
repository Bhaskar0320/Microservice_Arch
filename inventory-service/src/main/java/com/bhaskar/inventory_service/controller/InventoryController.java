package com.bhaskar.inventory_service.controller;


import com.bhaskar.inventory_service.dto.*;
import com.bhaskar.inventory_service.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> inStock(@RequestParam List<String> skuCode) {

        return inventoryService.isInStock(skuCode);
    }

}
