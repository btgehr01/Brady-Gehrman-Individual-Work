
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class TwoForsAndTenYearsAgo {
  public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

         for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + (i));
        }
    }  
}
//ranges for stopping include the years being less than 10 of the stated start year
//both loops only want to count back 10 years
//The first for loop is clearer to me because im more used to that syntax
