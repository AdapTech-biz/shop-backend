package biz.adaptech.service;

import biz.adaptech.model.InventoryItem;

import java.util.List;

public interface InventoryService {

    List<InventoryItem> getAllItems();
    List<InventoryItem> getItemsByBrand(String brandName);
}
