/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.firsttest;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 19bgehrman
 */
public class MultiplyStuffTest {
    
    public MultiplyStuffTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        int factorOne = 5;
        int factorTwo = 10;
        int result = SomeMethods.multiplyStuff(factorOne, factorTwo);
        Assert.assertEquals("I multiplied 5 * 10", 50, result);
    }
    @Test
    public void testMultiplyLarge(){
        int factorOne = 500;
        int factorTwo = 1000;
        int result = SomeMethods.multiplyStuff(factorOne, factorTwo);
        Assert.assertEquals("I multiplied 500 * 1000",500000 , result); 
    }
    @Test
    public void testMultiplyNegative(){
       int factorOne = -5;
       int factorTwo = -20;
       int result = SomeMethods.multiplyStuff(factorOne, factorTwo);
       Assert.assertEquals("I multiplied -20 * -5",100 , result);   
    }
    
}
