/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vending.Dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author 19bgehrman
 */
public class ChangePurse {
    
    private int numOfDollars;
    private int numOfQuarters;
    private int numOfDimes;
    private int numOfNickels;
    private int numOfPennies;
    
    public ChangePurse(BigDecimal change) {
        change = change.setScale(2);
        int greaterThanDollar = change.compareTo(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanDollar > -1) {
            change = change.subtract(new BigDecimal(1.00));
            greaterThanDollar = change.compareTo(new BigDecimal(1.00));
            numOfDollars++;
        }
        int greaterThanQuarter = change.compareTo(new BigDecimal(0.25).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanQuarter > -1) {
            change = change.subtract(new BigDecimal(0.25));
            greaterThanQuarter = change.compareTo(new BigDecimal(0.25));
            numOfQuarters++;
        }
        int greaterThanDime = change.compareTo(new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanDime > -1) {
            change = change.subtract(new BigDecimal(0.10));
            greaterThanDime = change.compareTo(new BigDecimal(0.10));
            numOfDimes++;
        }
        int greaterThanNickel = change.compareTo(new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanNickel > -1) {
            change = change.subtract(new BigDecimal(0.05));
            greaterThanNickel = change.compareTo(new BigDecimal(0.05));
            numOfNickels++;
        }
        /*
        int greaterThanPenny = change.compareTo(new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanPenny > -1) {
            change = change.subtract(new BigDecimal(0.01));
            greaterThanPenny = change.compareTo(new BigDecimal(0.01));
            numOfPennies++;
        }
         */
        change = change.multiply(new BigDecimal(100.00)).setScale(0, RoundingMode.HALF_UP);
        int pennies = change.intValue();
        while (pennies >= 1) {
            pennies = pennies - 1;
            numOfPennies++;
        }
        
    }
    
    public ChangePurse() {
    }
    
    public ChangePurse(int numOfDollars, int numQuarters, int numOfDimes, int numOfNickels, int numOfPennies) {
        this.numOfDollars = numOfDollars;
        this.numOfQuarters = numQuarters;
        this.numOfDimes = numOfDimes;
        this.numOfNickels = numOfNickels;
        this.numOfPennies = numOfPennies;
    }
    
    public int getNumOfDollars() {
        return numOfDollars;
    }
    
    public void setNumOfDollars(int numOfDollars) {
        this.numOfDollars = numOfDollars;
    }
    
    public int getNumQuarters() {
        return numOfQuarters;
    }
    
    public void setNumQuarters(int numQuarters) {
        this.numOfQuarters = numQuarters;
    }
    
    public int getNumOfDimes() {
        return numOfDimes;
    }
    
    public void setNumOfDimes(int numOfDimes) {
        this.numOfDimes = numOfDimes;
    }
    
    public int getNumOfNickels() {
        return numOfNickels;
    }
    
    public void setNumOfNickels(int numOfNickels) {
        this.numOfNickels = numOfNickels;
    }
    
    public int getNumOfPennies() {
        return numOfPennies;
    }
    
    public void setNumOfPennies(int numOfPennies) {
        this.numOfPennies = numOfPennies;
    }
    
}
