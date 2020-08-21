/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment1;

/**
 *
 * @author Brady Gehrman
 */
public class StringPlay {

    public static void main(String[] args) {
        String college = new String("PoDunk College"); //could just do String college, this words the same to initialize a String
        String town = "Anytown, USA"; // part (a)//initilize a String with the value "Anytown, USA"
        int stringLength;
        String change1, change2, change3;
        stringLength = college.length(); // part (b)//use the method length from the string class to get the length of the string and store it
        System.out.println(college + " contains " + stringLength
                + " characters.");
        change1 = college.toUpperCase(); // part (c) //use the toUpperCase method to return the capitalized version of the string college
        change2 = change1.replace('O', '*'); // part (d) //use the replace method to create a new string that replaces all of the Os in college to *s 
        change3 = college.concat(town); // part (e) //create a new string that is the string college and town concatinated (conat method)
        System.out.println("The final string is " + change3); 
        System.out.println(change2);
    }

}
