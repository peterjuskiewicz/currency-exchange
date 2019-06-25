package com.juskiewicz.currencyexchange.model;

public class Exchange {

    private double gbp;
    private double usd;
    private double exchangeRate;

    public Exchange(double gbp, double exchangeRate) {
        this.gbp = gbp;
        this.exchangeRate = exchangeRate;
        this.usd = gbp * exchangeRate;
    }

    public Exchange() {
    }

    public double getGbp() {
        return gbp;
    }

    public void setGbp(double gbp) {
        this.gbp = gbp;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
