/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class TemperatureDriver {
    public static void main(String[] args) throws FileNotFoundException {
        
        String lineFromFile;
        Scanner scan = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\Assignment4\\src\\main\\java\\com\\universityoflouisville\\assignment4\\Temperatures"));
        
        lineFromFile = scan.nextLine();
        ArrayList<Integer> temperatures = unMarshallTemperatures(lineFromFile);
        Week_Temperatures tempClass = new Week_Temperatures (temperatures);
        System.out.println("Below is the temps for each day of the week m/t/w/th/f/s/sun");
        System.out.println(tempClass);
        
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter your preferred serverity temperature below (degrees f): ");
        int userWantedServerityTemp = scan2.nextInt();
        tempClass.setSeverity(userWantedServerityTemp);
        
        System.out.println("Serverity Level: " + tempClass.getSeverityLevel());
        System.out.println("Tempatures below freezing: " + tempClass.numberOfDayBelowFreezing());
        System.out.println("Temperatures above " + tempClass.getSeverity() + " degrees (Serverity Level) in next weeks forecast:");
        for(int temp : tempClass.getlistOfTempsAboveSevTemp()){
            System.out.print(temp + " ");
        }
        
        
    }
    public static ArrayList<Integer>unMarshallTemperatures(String lineFromFile){
        ArrayList<Integer> list = new ArrayList<>();
        String[] tokens = lineFromFile.split("::");
        
        String mondayTemp = tokens[0];
        int mTemp = Integer.parseInt(mondayTemp);
        list.add(mTemp);
        
        String tuesdayTemp = tokens[1];
        int tTemp = Integer.parseInt(tuesdayTemp);
        list.add(tTemp);
        
        String wednesdayTemp = tokens[2];
        int wTemp = Integer.parseInt(wednesdayTemp);
        list.add(wTemp);
        
        String thursdayTemp = tokens[3];
        int thTemp = Integer.parseInt(thursdayTemp);
        list.add(thTemp);
        
        String fridayTemp = tokens[4];
        int fTemp = Integer.parseInt(fridayTemp);
        list.add(fTemp);
        
        String saturdayTemp = tokens[5];
        int sTemp = Integer.parseInt(saturdayTemp);
        list.add(sTemp);
        
        String sundayTemp = tokens[6];
        int sunTemp = Integer.parseInt(sundayTemp);
        list.add(sunTemp);
        
        return list;
    }
}
