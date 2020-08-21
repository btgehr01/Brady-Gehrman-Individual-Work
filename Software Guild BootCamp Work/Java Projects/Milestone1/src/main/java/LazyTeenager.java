
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 19bgehrman
 */
public class LazyTeenager {

    public static void main(String[] args) {
        int rounds = 1;
        int cleanRoom = 4;
        boolean clean = false;
        Random randomizer = new Random();
        do {
            if (rounds >= 15) {
                System.out.println("That's it your xbox is mine!!-MOM");
                break;
            }
            System.out.println("Clean your messy room!!-MOM (" + rounds + ")");
            int chance = randomizer.nextInt(100);
            if (chance <= cleanRoom) {
                clean = true;
                System.out.println("Finally the teenagers room is clean. It took him/her "
                        + rounds + " screams by his mom to clean his/her room!");
            } else {
                cleanRoom = cleanRoom + 5;
                rounds++;
            }

        } while (!clean);
    }
}
