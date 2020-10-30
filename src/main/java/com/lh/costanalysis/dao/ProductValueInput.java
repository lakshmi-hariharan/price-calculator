package com.lh.costanalysis.dao;

public class ProductValueInput {
    int itemID;
    String currencyAlpha;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getCurrencyAlpha() {
        return currencyAlpha;
    }

    public void setCurrencyAlpha(String currencyAlpha) {
        this.currencyAlpha = currencyAlpha;
    }
}