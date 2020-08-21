/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatormvcspringwebapp;

import java.math.BigDecimal;

/**
 *
 * @author 19bgehrman
 */
public class InterestYear {
    private BigDecimal beginningBalance;
    private BigDecimal amountEarned;
    private BigDecimal endingBalance;
    private int year;

    public InterestYear(int year) {
        this.year = year;
    }

    
    public BigDecimal getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(BigDecimal beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public BigDecimal getAmountEarned() {
        return amountEarned;
    }

    public void setAmountEarned(BigDecimal amountEarned) {
        this.amountEarned = amountEarned;
    }

    public BigDecimal getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
}
