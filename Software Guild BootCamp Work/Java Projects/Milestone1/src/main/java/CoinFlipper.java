
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
public class CoinFlipper {

    public static void main(String[] args) {
        boolean decider;
        Random randomizer = new Random();
        System.out.println("Ready, Set, Flip....!!");
        decider = randomizer.nextBoolean();

        if (decider) {
            System.out.println("You got tails!!");
        } else {
            System.out.println("You got heads!!");
        }
    }
}
