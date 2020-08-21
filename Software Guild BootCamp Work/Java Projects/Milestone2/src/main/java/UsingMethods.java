/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class UsingMethods {
    public static void main(String[] args) {
       String result = StaticMethods.colorThingOne("red");
        System.out.println("The result of the method is " + result);
        
        int max = StaticMethods.highestNum(1, 2, 3);
        
        System.out.println("The higest number given is " + max);
        
    }
}
