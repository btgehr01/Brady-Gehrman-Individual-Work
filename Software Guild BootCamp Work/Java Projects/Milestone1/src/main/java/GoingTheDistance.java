
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
public class GoingTheDistance {
    public static void main(String[] args) {
        double speed;
        double time;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your current speed??(MPH)");
        speed = myScanner.nextDouble();
        System.out.println("How long will you be traveling at that speed??(hours)");
        time = myScanner.nextDouble();
        double miles = time * speed;
        
        System.out.println("if you continue going at that same speed the whole "
                + "time you will go " + miles + " miles!!");
    }
}
