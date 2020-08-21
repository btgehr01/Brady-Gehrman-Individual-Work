/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone1.labs;

import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class Factorizor {

    public static void main(String[] args) {

        Scanner userInput;
        int num;
        int remainder;
        String answer;
        userInput = new Scanner(System.in);
        
        do {
        int numberOfFactors = 1;
        int perfect = 0;
            System.out.println("Give me a number to factor!!");
            num = userInput.nextInt();

            System.out.println("The factors of " + num + " are: ");

            for (int i = 1; i < num; i++) {
                remainder = num % i;
                if (remainder == 0) {
                    System.out.println(i);
                    perfect = perfect + i;
                    numberOfFactors = numberOfFactors + 1;
                }
            }
            System.out.println(num + " has " + numberOfFactors + " factors");

            if (perfect == num) {
                System.out.println(num + " is a perfect number!!");
            }
            if (perfect == 1) {
                System.out.println(num + " is a prime number");
            }
            if (perfect > 1) {
                System.out.println(num + " is not a prime number!!");
            }
            System.out.println("would you like to factor a number?");
            answer = userInput.next();

        } while (answer.equals("yes"));

    }
}
