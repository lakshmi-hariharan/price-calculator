package com.lh.costanalysis.dao;

public class ExchangeRate {
    String currencyAlpha;
    double currencyValue;

    public String getCurrencyAlpha() {
        return currencyAlpha;
    }

    public void setCurrencyAlpha(String currencyAlpha) {
        this.currencyAlpha = currencyAlpha;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public String toString() {
        return "ExchangeRate [currencyAlpha=" + currencyAlpha + ", currencyValue=" + currencyValue + "]";
    }
    
}