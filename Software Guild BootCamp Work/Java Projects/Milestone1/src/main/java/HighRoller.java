
import java.util.Random;
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
public class HighRoller {

    public static void main(String[] args) {
        Random diceRoller = new Random();
        Scanner myScanner = new Scanner(System.in);
        int total;
        System.out.println("How many sides do you want your dice to have?");
        total = myScanner.nextInt();
        int rollResult = diceRoller.nextInt(total) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        if (rollResult == total) {
            System.out.println("You rolled a critical! Nice Job!");
        } else {
            System.out.println("You didn't roll a critical "
                    + "or a critical failure value!!");
        }
    }
}
