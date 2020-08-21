
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
public class TheCount {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int rounds = 1;
        int num;
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        System.out.println("Where would you like to start? (whole number)");
        int start = myScanner.nextInt();
        System.out.println("When would you like to stop? (whole number)");
        int end = myScanner.nextInt();
        System.out.println("How much would you like to increment by?");
        int increment = myScanner.nextInt();
        System.out.println("Start at " + start);
        System.out.println("End at " + end);
        System.out.println("increment by " + increment);
        for (int i = start; i < end; i = num) {
            if(rounds == 1){
                System.out.print(start + ", ");
                num = start;
                rounds++;
            }
            num = i + increment;
            System.out.print((i + increment) + ", ");
            if (rounds % 3 == 0) {
                System.out.println(" - Ah Ah Ah");
            }
            rounds++;
            if(num + increment > end){
                break;
            }
        }
    }

}
