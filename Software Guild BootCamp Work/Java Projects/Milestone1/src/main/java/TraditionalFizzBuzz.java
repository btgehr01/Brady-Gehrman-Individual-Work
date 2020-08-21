
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
public class TraditionalFizzBuzz {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What number would you like to count to??");
        int stop = myScanner.nextInt();
        for (int i = 0; i <= stop; i++) {
            if( i % 3 == 0 && i % 5 == 0 && i != 0){
                System.out.println("fizz buzz");
                continue;
            }
            if (i % 3 == 0 && i != 0) {
                System.out.println("fizz");
            }
            else if( i % 5 == 0 && i != 0){
                System.out.println("buzz");
            }
            else{
                System.out.println(i);
            }
            
        }
        System.out.println("TRADITION!!");
    }
}
