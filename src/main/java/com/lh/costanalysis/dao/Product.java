package com.lh.costanalysis.dao;

public class Product {
    Long itemID;
    String itemName;
    double itemCost;

    
	public Long getItemID() {
        return this.itemID;
    }
    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return this.itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "Product [itemCost=" + itemCost + ", itemID=" + itemID + ", itemName=" + itemName + "]";
    }

    public Product(Long itemID, String itemName, double itemCost) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCost = itemCost;
    }
	public Product() {
	}

    

  
   
}