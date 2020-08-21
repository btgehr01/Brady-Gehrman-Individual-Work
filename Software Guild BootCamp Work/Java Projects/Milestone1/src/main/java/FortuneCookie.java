
import java.util.Random;
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
public class FortuneCookie {

    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("Here is your fortune cookie!!");
        int num = randomizer.nextInt(10);
        
        if (num == 0) {
            System.out.println("Those aren’t the droids you’re looking for.");
        }
        if (num == 1) {
            System.out.println("Never go in against a Sicilian when death is on the line!");
        }
        if (num == 2) {
            System.out.println("Goonies never say die.");
        }
        if (num == 3) {
            System.out.println("With great power there must also come — great responsibility");
        }
        if (num == 4) {
            System.out.println("Never argue with the data.");
        }
        if (num == 5) {
            System.out.println("Try not. Do, or do not. There is no try.");
        }
        if (num == 6) {
            System.out.println("You are a leaf on the wind, watch how you soar.");
        }
        if (num == 7) {
            System.out.println("Do absolutely nothing, and it will be everything that you thought it could be.");
        }
        if (num == 8) {
            System.out.println("Kneel before Zod.");
        }
        if (num == 8) {
            System.out.println("Make it so.");
        }

    }
}
