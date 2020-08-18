package biz.adaptech.model;

import lombok.Data;

import java.util.List;

@Data
public class InventoryItem {
    private List<String> images;
    private String brand;
    private String sku;
    private List<Integer> sizes;
    private Double price;
    private String name;
    private boolean stock;
    private List<String> colors;
}
