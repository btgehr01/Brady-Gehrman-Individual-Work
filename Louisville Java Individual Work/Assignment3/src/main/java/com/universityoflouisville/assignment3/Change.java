/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class Change {
    
    final static String DELIMITER = "::";
    
    
    public static void main(String[] args) throws IOException{
        String lineFromFile;
        Scanner fileScan;
        
        fileScan = new Scanner(new File("C:\\Users\\Brady Gehrman\\OneDrive\\Documents\\CECS 220\\Assignment3\\src\\main\\java\\com\\universityoflouisville\\assignment3\\CoinsJar.txt"));
        
        lineFromFile = fileScan.nextLine();
        CoinsJar coinJar = unMarshallCoinJar(lineFromFile);
        //get the CoinsJar Object
        System.out.println(coinJar);
        String dollarAmount = coinJar.getAmount();
        System.out.println("Total Amount in CoinJar: " + dollarAmount);
        System.out.println(coinJar.getValues());
        
        Scanner scan = new Scanner(System.in);
        //show the mutator method work in the CoinsJar Class
        System.out.println("What coin category would you like to change? (pennies/nickels/dimes/quarters)");
        String userCategoryToChange = scan.nextLine();
        System.out.println("What number would you like to change the amount of " + userCategoryToChange + " in the coin jar to?");
        int amountOfCoinWanted = scan.nextInt();
        //switch user specified cointype quantity
        switch(userCategoryToChange){
            case "pennies":
                coinJar.setNumOfPennies(amountOfCoinWanted);
                break;
            case "nickels":
                coinJar.setNumOfNickels(amountOfCoinWanted);
                break;
            case "dimes":
                coinJar.setNumOfDimes(amountOfCoinWanted);
                break;
            case "quarters":
                coinJar.setNumOfQuarters(amountOfCoinWanted);
            default:
                System.out.println("Sorry illegal input");
        }
        
        System.out.println("Total amount of money in the coin jar after changes: " + coinJar.getAmount());
            
        
        fileScan.close();
    }
    
       public static CoinsJar unMarshallCoinJar(String currentLineFromFile){
        String[] tokens = currentLineFromFile.split(DELIMITER);
        //split fileLine into 4 array elements
        String stringQuarters = tokens[0];
        int quarters = Integer.parseInt(stringQuarters);
        //get quarter value
        String stringDimes = tokens[1];
        int dimes = Integer.parseInt(stringDimes);
        //get dimes value
        String stringNickels = tokens[2];
        int nickels = Integer.parseInt(stringNickels);
        //get nickels value
        String stringPennies = tokens[3];
        int pennies = Integer.parseInt(stringPennies);
        //get pennies value
        CoinsJar jar = new CoinsJar(quarters, dimes, nickels, pennies);
        //create CoinJar object anbd return it
        return jar;
    }
}
