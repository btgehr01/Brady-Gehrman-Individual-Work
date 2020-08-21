/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment5;

import java.text.DecimalFormat;

/**
 *
 * @author Brady Gehrman
 */
public class Box extends GeometricShape{
    
    private double width;
    private double length;
    private double height;

    public Box(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getSurfaceArea() {
        double area = (2 * width * length) + (2 * width * height) + (2 * length * height);
        super.surfaceArea = area;
        return area;
    }

    @Override
    public double getVolume() {
        double vol = width * length * height;
        super.volume = vol;
        return vol;
    }
    
   public String toString(){
       DecimalFormat format = new DecimalFormat(".##"); 
       String output = "Box's stats:";
       output += "\nLength: " + length + " Width: " + width + " Height: " + height;
       output += "\nSurface Area: " + format.format(this.getSurfaceArea()) + " Volume: " + format.format(this.getVolume());
       return output;
   }
        
}
