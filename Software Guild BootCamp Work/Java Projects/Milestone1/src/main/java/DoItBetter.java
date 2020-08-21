
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
public class DoItBetter {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String hotdogs;
        int hotdogsReal;
        String miles;
        double milesReal;
        String languages;
        int languagesReal;
        System.out.println("How many miles can you run at a time??");
        miles = myScanner.nextLine();
        milesReal = Double.parseDouble(miles);
        System.out.println("How many hotdogs can you eat at on time??");
        hotdogs = myScanner.nextLine();
        hotdogsReal = Integer.parseInt(hotdogs);
        System.out.println("How many languages do you know??");
        languages = myScanner.nextLine();
        languagesReal = Integer.parseInt(languages);
        
        System.out.println("I know " + (languagesReal * 2 + 1) + " languages!!");
        System.out.println("I can eat " + (hotdogsReal * 2 + 1) + " hotdogs at a time!!");
        System.out.println("I can run " + (milesReal * 2 + 1) + " miles at a time!!");
    }
}
