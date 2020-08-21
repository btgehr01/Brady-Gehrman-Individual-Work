/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.firsttest;

/**
 *
 * @author ahill
 */
public class SomeMethods {

    public static int addStuff(int a, int b) {
        return a + b;
    }

    public static int multiplyStuff(int a, int b) {
        return a * b;
    }

    public static int returnTheBigger(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}
