/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone2;

/**
 *
 * @author 19bgehrman
 */
public class Llama {
private String name;
private boolean canDrive;
private int age;
private double woolLength;
private String woolColor;
private String woolType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanDrive() {
        return canDrive;
    }

    public void setCanDrive(boolean canDrive) {
        this.canDrive = canDrive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWoolLength() {
        return woolLength;
    }

    public void setWoolLength(double woolLength) {
        this.woolLength = woolLength;
    }

    public String getWoolColor() {
        return woolColor;
    }

    public void setWoolColor(String woolColor) {
        this.woolColor = woolColor;
    }

    public String getWoolType() {
        return woolType;
    }

    public void setWoolType(String woolType) {
        this.woolType = woolType;
    }

    public Llama() {
    }

    public Llama(String name, boolean canDrive, int age, double woolLength, String woolColor, String woolType) {
        this.name = name;
        this.canDrive = canDrive;
        this.age = age;
        this.woolLength = woolLength;
        this.woolColor = woolColor;
        this.woolType = woolType;
    }


}
