/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

/**
 *
 * @author ahill
 */
public class ExampleWork {

    // When llamas get together they like to bounce on trampolines.
    // However, llamas are very particular about the proper number of trampolines, 
    // and are usually only happy if there are between 24 to 42 (inclusive!).
    // This only changes if the trampolines are made of ultra-bouncey NASA fabric.
    // In those cases, the llamas figure the more trampolines the better!
    // 
    // Return true if the llamas will be happy with their trampolines,
    // or false otherwise.
    //
    //
    // areTheLlamasHappy(false, 20) → false
    // areTheLlamasHappy(false, 30) → true
    // areTheLlamasHappy(true, 100) → true
    public static boolean areTheLlamasHappy(boolean ultraBouncy, int trampolines) {
        boolean llamasAreHappy;
        if (ultraBouncy) {
            if (trampolines >= 24) {
                llamasAreHappy = true;
            } else {
                llamasAreHappy = false;
            }
        } else {
            if (trampolines >= 24 && trampolines <= 42) {
                llamasAreHappy = true;
            } else {
                llamasAreHappy = false;
            }
        }
        return llamasAreHappy;
    }

    // Given a number of bones, return the number of barks your dog will make!
    // If there is an even number of bones, your dog will bark three times.
    // If there is an odd number, they'll bark twice!
    // If there are none, there is only a silence (ex: "..."), 
    // as it waits patiently for more bones!
    //
    // Similarly, there's no such thing as a negative number of bones,
    // and so make sure your dog keeps absolutely silent in those cases too!
    //
    // howManyWoofs(10) -> "Woof! Woof! Woof!"
    // howManyWoofs(5)  -> "Woof! Woof!"
    // howManyWoofs(0)  -> "..."
    public static String howManyWoofs(int numBones) {
        String woofs;
        if (numBones == 0 || numBones < 0) {
            woofs = "...";
        } else {
            if (numBones % 2 == 0) {
                woofs = "Woof! Woof! Woof!";
            } else {
                woofs = "Woof! Woof!";
            }
        }
        return woofs;
    }
}
