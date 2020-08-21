
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
public class StayPositive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What number shoud I count down from");
        int num = input.nextInt();
        System.out.println("Here goes nothing!!");
        System.out.println(num);
        while(num > 0){
            System.out.println(num - 1);
            num = num - 1;
          
        }
        System.out.println("Whoa, better stop there!!");
    }
}
