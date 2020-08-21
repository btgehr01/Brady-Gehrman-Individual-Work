
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
public class MaybeItLovesMe {

    public static void main(String[] args) {
        int times = 1;
        int petals;
        boolean lovesMe;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many petals does your flower have (13-89)??");
        petals = myScanner.nextInt();
        System.out.println("Here goes nothing..");
        while (times <= petals && petals >= 13 && petals <= 89) {
            if (times % 2 == 0) {
                System.out.println("It LOVES me!");
                times++;
                lovesMe = true;
            } else {
                System.out.println("It loves me NOT!");
                times++;
                lovesMe = false;
            }
            if (lovesMe && times > petals) {
                System.out.println("Oh, wow! It really LOVES me!");
            }
            if (!lovesMe && times > petals) {
                System.out.println("Awwww, bummer.");
            }
        }
    }
}
