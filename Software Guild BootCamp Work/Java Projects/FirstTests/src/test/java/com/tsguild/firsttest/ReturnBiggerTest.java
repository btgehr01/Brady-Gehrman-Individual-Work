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
public class ReturnBiggerTest {
    
    public ReturnBiggerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        int numOne = 4;
        int numTwo = 5;
        int result = SomeMethods.returnTheBigger(numOne, numTwo);
        Assert.assertEquals("I found which integer id greater: 4 or 5", 5, result);
    }
    @Test
    public void testLargeNums(){
       int numOne = 10000;
       int numTwo = 5000;
       int result = SomeMethods.returnTheBigger(numOne, numTwo);
       Assert.assertEquals("I found which integer id greater: 10000 or 5000", 10000, result); 
    }
    @Test
    public void testNegativeNums(){
        int numOne = -10000;
       int numTwo = -5000;
       int result = SomeMethods.returnTheBigger(numOne, numTwo);
       Assert.assertEquals("I found which integer id greater: -10000 or -5000", -5000,result);
    }
    
}
