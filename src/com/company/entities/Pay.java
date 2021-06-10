package com.company.entities;

import java.util.Date;

public class Pay {
    private String payTipe;
    private int amount;
    private Date payDate;

    public Pay(String payTipe, int amount, Date payDate) {
        this.payTipe = payTipe;
        this.amount = amount;
        this.payDate = payDate;
    }

    public String getPayTipe() {
        return payTipe;
    }

    public void setPayTipe(String payTipe) {
        this.payTipe = payTipe;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "payTipe='" + payTipe + '\'' +
                ", amount=" + amount +
                ", payDate=" + payDate +
                '}';
    }
}
