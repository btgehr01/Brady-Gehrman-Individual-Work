/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class LovesMe {

    public static void main(String[] args) {
        int times = 1;
        System.out.println("Here goes nothing..");
        while (times <= 34) {
            if (times % 2 == 0) {
                System.out.println("It LOVES me!");
                times++;
            } else {
                System.out.println("It loves me NOT!");
                times++;
            }
            System.out.println("I knew it! It LOVES ME!");
        }
    }
}
