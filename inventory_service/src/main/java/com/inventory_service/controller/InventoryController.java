package com.inventory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")                             
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable String skuCode) { 
        return inventoryService.isInStock(skuCode);
    }
}