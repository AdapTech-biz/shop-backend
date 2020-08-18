package biz.adaptech.controller;

import biz.adaptech.model.InventoryItem;
import biz.adaptech.service.InventoryService;
import biz.adaptech.service.InventoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "v1/inventory")
public class Inventory {

    private final InventoryService inventoryService;

    @Autowired
    public Inventory(InventoryServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/list")
    public List<InventoryItem> list(@RequestParam(defaultValue = "all") String brand) {
       return  brand.equalsIgnoreCase("all") ?
               this.inventoryService.getAllItems() : this.inventoryService.getItemsByBrand(brand);
    }


}
