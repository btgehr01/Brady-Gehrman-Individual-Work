
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
public class BiggerBetterAdder {
    public static void main(String[] args) {
        double addendOne;
        double addendTwo;
        Scanner myScanner = new Scanner (System.in);
        System.out.println("give me a number to add");
        addendOne = myScanner.nextDouble();
       
        System.out.println("give me a number to add the first number to");
        addendTwo = myScanner.nextDouble();
        
        System.out.println("total is:" + (addendOne + addendTwo));
       
    }
}
