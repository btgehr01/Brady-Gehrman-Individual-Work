
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
public class ForTimes {
    public static void main(String[] args) {
        int timesTable;
        System.out.println("Which times table should I recite"); 
        Scanner input = new Scanner(System.in);
        timesTable = input.nextInt();
        for(int i = 0; i <= 15; i++){
            System.out.println( timesTable + " * " + i + " is: " + (timesTable * i));
        }
        System.out.println("and those are the times tables of " + timesTable + " up to 15!!");
    }
    
}
