/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment5;

/**
 *
 * @author Brady Gehrman
 */
public abstract class GeometricShape implements Comparable<GeometricShape>{
    
    public static final double PI = 22.0/7;
    protected double surfaceArea;
    protected double volume;
    
    
    abstract public double getSurfaceArea();
    abstract public double getVolume();
    
    @Override 
    
    public int compareTo(GeometricShape shapeToCompare) {
        int value = 0;
        if(shapeToCompare.getVolume() > volume){
            value = -1;
        }else if(shapeToCompare.getVolume() < volume){
            value = 1;
        }
        return value;
    }
    
  
}
