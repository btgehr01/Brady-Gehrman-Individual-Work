/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone1.labs;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class LuckySevens {

    public static void main(String[] args) {
        Scanner userInput;
        Random diceRoller;
        double cash;
        double maxMoney;
        int rolls;
        int maxRolls;

        //initialize variables
        userInput = new Scanner(System.in);
        diceRoller = new Random();
        rolls = 0;
        maxRolls = 0;

        //ask the user for money
        System.out.print("Hey! Give me some $: ");
        cash = userInput.nextDouble();
        //String cashAsText=next line and then parse it
        maxMoney = cash;

        while (cash > 0) {
            //roll some die & add together
            int rollOne = diceRoller.nextInt(6) + 1;
            int rollTwo = diceRoller.nextInt(6) + 1;
            int diceTotal = rollOne + rollTwo;
            rolls++;

            System.out.println(rolls + ": " + rollOne + " + " + rollTwo);
            System.out.println(diceTotal);

            //update money
            if (diceTotal == 7) {
                System.out.println("Hey! you won this round!");
                cash = cash + 4;

                //check if we had more thn we had once
                if (cash > maxMoney) {
                    maxMoney = cash;
                    maxRolls = rolls;
                }
            } else {
                System.out.println("Oops. not 7, no money! 1 dollar please!");
                cash--;
            }
        }
        System.out.println("you have $" + cash + " left");
        System.out.println("you should have quit after "
                + maxRolls + " rolls when you had $" + maxMoney);

        //How many dollars do you have? 100 
        //You are broke after 543 rolls. 
        //You should have quit after 47 rolls when you had $113.
        //maybe figure out how to start again
        //but if they ran out, end the game
    }

}
