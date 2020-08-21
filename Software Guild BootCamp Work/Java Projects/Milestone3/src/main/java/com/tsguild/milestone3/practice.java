/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author 19bgehrman
 */
public class practice {
    public static void main(String[] args) {
        System.out.println(1 + 3);
        System.out.println(5 * 5);
        System.out.println(33.3 - 42.42);
        System.out.println(15/25);
        
        BigDecimal op1 = new BigDecimal("1");
        BigDecimal op2 = new BigDecimal("3");
        
        System.out.println(op1.add(op2));
        
        BigDecimal op3 = new BigDecimal("5");
        System.out.println(op3.multiply(op3));
        
        BigDecimal op4 = new BigDecimal("33.3");
        BigDecimal op5 = new BigDecimal("42.42");
        System.out.println(op4.subtract(op5));
        
        BigDecimal op6 = new BigDecimal("15");
        BigDecimal op7 = new BigDecimal("25");
        System.out.println(op6.divide(op7, 3, RoundingMode.HALF_UP));
        
        System.out.println((3 + 4 / 7) * 2);
        
        BigDecimal op8 = new BigDecimal("3");
        BigDecimal op9 = new BigDecimal("4");
        BigDecimal op10 = new BigDecimal("7");
        BigDecimal op11 = new BigDecimal("2");
        
        System.out.println((op8.add(op9).divide(op10, 2, RoundingMode.HALF_UP)).multiply(op11));
    }
}
