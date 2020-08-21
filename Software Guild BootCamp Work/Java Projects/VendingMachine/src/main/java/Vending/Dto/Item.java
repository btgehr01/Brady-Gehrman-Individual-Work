/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vending.Dto;

import java.math.BigDecimal;

/**
 *
 * @author 19bgehrman
 */
public class Item {

    private String name;
    private BigDecimal cost;
    private int calories;
    private String slotID;
    private int numOfItems;

    public Item(String slotID) {
        this.slotID = slotID;
    }

    public Item(String name, BigDecimal cost, int calories, String slotID, int numOfItems) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
        this.slotID = slotID;
        this.numOfItems = numOfItems;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

}
