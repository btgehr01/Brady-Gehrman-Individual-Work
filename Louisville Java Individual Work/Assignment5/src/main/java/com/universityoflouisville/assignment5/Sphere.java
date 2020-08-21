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
public class Sphere extends GeometricShape{
    
    private double radius;
    
    public Sphere(double radius){
        this.radius = radius;
    }
    
    public double getRadius(){
        return this.radius;
    }

    @Override
    public double getSurfaceArea() {
        double area = 4 * GeometricShape.PI * Math.pow(radius, 2);
        super.surfaceArea = area;
        return area;
    }

    @Override
    public double getVolume() { 
       double vol = (4.0/3) * GeometricShape.PI * Math.pow(radius, 3);
       super.volume = vol;
       return vol;
    }
    
    public String toString(){
        DecimalFormat format = new DecimalFormat(".##"); 
        String output = "Sphere's stats:";
        output += "\nRadius: " + radius;
        output += "\nVolume: " + format.format(this.getVolume()) + " Surface Area: " + format.format(this.getSurfaceArea());
        return output;
    }

    

    
}
