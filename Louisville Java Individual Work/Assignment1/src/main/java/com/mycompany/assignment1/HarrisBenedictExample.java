/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class HarrisBenedictExample {
    public static void main(String[] args) {
        System.out.println("Welcome to the Total Daily Calorie Calculator!!");
        //print out introduction
        Scanner scan = new Scanner(System.in); //initalize a scanner called scan
        System.out.println("Please enter your weight in lbs");
        //prompt for user weight in lbs
        double weight = scan.nextDouble();
        //use scanner to record the value of the next double into the double weight
        System.out.println("Please enter height in inches");
        //prompt for user height in inches
        double height = scan.nextDouble();
        //use scanner to record the value of the next double into the double height
        System.out.println("Please enter your age in years");
        //prompt the user for their age in years
        double age = scan.nextDouble();
        //use scanner to record the value of the next double into the double age
        double calorieNeededFemale = 655.1 + ( 4.35 * weight) + ( 4.7 * height) - ( 4.7 * age) * 1.2;
        double calorieNeededMale = 66 + ( 6.2 * weight) + ( 12.7 * height)- ( 6.76 * age) * 1.2;
        //do calculations for both malke and female
        DecimalFormat format = new DecimalFormat(".##"); 
        //initalize a DecimalFormat object that takes a decimal and make sure that when it is printed it only shows to the hundredths place

        System.out.println("Daily calorie needs for a male of your statistics: " + format.format(calorieNeededMale));
        System.out.println("Daily calorie needs for a female of your statistics: " + format.format(calorieNeededFemale));
    }
}
