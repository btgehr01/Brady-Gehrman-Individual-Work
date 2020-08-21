/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment5;

import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class ShapesCollection {
    
    public static void main(String[] args) {
        Scanner scannner = new Scanner(System.in);
        GeometricShape[] shapes = new GeometricShape[10];
        for(int i = 0; i < shapes.length; i++){
            if(i == 9){
                System.out.println("Last shape!");
            }
           System.out.println("What shape would you like to add to the list? (sphere or box)");
           String shape = scannner.nextLine();
           if(shape.equals("sphere")){
           Sphere sphereToAdd = ShapesCollection.createSphere();
           shapes[i] = sphereToAdd;
           }else{
           Box boxToAdd = ShapesCollection.createBox();
           shapes[i] = boxToAdd;
           }
        }
        
        shapes = ShapesCollection.sortArray(shapes);
        System.out.println("\nPrinting out shapes from Smallest to Largest based on their volume\n\n");
        for(int j = 0; j < shapes.length; j++){
            System.out.println(shapes[j]);
        }
    }
    
    private static Sphere createSphere(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Sphere Menu:");
        
        System.out.println("Enter the radius of the sphere (inches)");
        String rad = scanner.nextLine();
        double radius = Double.parseDouble(rad);
        
        Sphere sphere = new Sphere(radius);
        System.out.println(sphere);
        return sphere;
    }
    private static Box createBox(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Box Menu:");
        
        System.out.println("Enter the length of the box (inches)");
        String len = scanner.nextLine();
        double length = Double.parseDouble(len);
        
        System.out.println("Enter the width of the box (inches)");
        String wid = scanner.nextLine();
        double width = Double.parseDouble(wid);
        
        System.out.println("Enter the height of the box (inches)");
        String hei = scanner.nextLine();
        double height = Double.parseDouble(hei);
        
        Box box = new Box(length, width, height);
        System.out.println(box);
        return box;
    }
    
    private static GeometricShape[] sortArray(GeometricShape[] unSortedList){
    int min;
    GeometricShape temp;
    for (int index = 0; index < unSortedList.length - 1; index++){
    min = index;
        for (int scan = index + 1; scan < unSortedList.length; scan++){
            if (unSortedList[scan].compareTo((GeometricShape)unSortedList[min]) < 0){
            min = scan;
            }
        }
    // Swap the values
    temp = unSortedList[min];
    unSortedList[min] = unSortedList[index];
    unSortedList[index] = temp;
    }
    
    return unSortedList;
    
    }
}
