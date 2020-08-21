/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment1;

import java.util.Random;

/**
 *
 * @author Brady Gehrman
 */
public class LuckyNumbers {

    public static void main(String[] args) {
        Random generator = new Random();
        int lucky1, lucky2, lucky3;
// Generate lucky1 (a random integer between 50 and 79) using the
// nextInt method (with no parameter)
        do { //do while loop makes sure the random generator generates a positive number
            lucky1 = generator.nextInt();
        } while (lucky1 < 0);
        lucky1 = lucky1 % 30 + 50; //get number 0-29 and adds 50 to it granting a number between 50-79
// Generate lucky2 (a random integer between 90 and 100) using the
// nextInt method with an integer parameter
        lucky2 = generator.nextInt(11) + 90; //gets a number 0-10 adds 90 to it granting a number between 90 and 100
// Generate lucky3 (a random integer between 11 and 30) using nextFloat
        lucky3 = (int) (generator.nextFloat() * 19) + 11; //generates a number 0-.999 then multiplies it by 19, then adds 11, then typecasting it to an int
        System.out.println("Your lucky numbers are " + lucky1 + ", " + lucky2
                + ", and " + lucky3);  //prints out the lucky numbers
    }

}
