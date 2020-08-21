/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class ContainsTheOtherTest {

    public ContainsTheOtherTest() {
    }
    
//    containsTheOther( "one", "tone" ) ->  true
//    ** containsTheOther( "same", "same" ) ->  false
//    ** containsTheOther( "fancypants", "pants" ) ->  true
//    ** containsTheOther( "llama", "duck" ) ->  false

    @Test
    public void testContainsTheOtherMethodTrue() {
        String one = "one";
        String two = "tone";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = true;
        Assert.assertEquals("test for one", expected, contains);
    }
    @Test
    public void testContainsTheOtherMethodTrueWordAfter() {
        String one = "fancypants";
        String two = "pants";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = true;
        Assert.assertEquals("test for WordAfter", expected, contains);
    }
    @Test
    public void testContainsTheOtherMethodFalse() {
        String one = "duck";
        String two = "llama";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = false;
        Assert.assertEquals("test for WordAfter", expected, contains);
    }
    @Test
    public void testContainsTheOtherMethodSameWords() {
        String one = "same";
        String two = "same";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = false;
        Assert.assertEquals("test for WordAfter", expected, contains);
    }
    @Test
    public void testContainsTheOtherMethodBothblank() {
        String one = "";
        String two = "";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = false;
        Assert.assertEquals("test for WordAfter", expected, contains);
    }
    @Test
    public void testContainsTheOtherMethodOneblank() {
        String one = "hi";
        String two = "";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = true;
        Assert.assertEquals("test for WordAfter", expected, contains);
    }
    @Test
    public void testContainsTheOtherMethodNull() {
        String one = null;
        String two = "hi";
        boolean contains = WorkWithLogic.containsTheOther(one, two);
        boolean expected = false;
        Assert.assertEquals("test for WordAfter", expected, contains);
    }

}
