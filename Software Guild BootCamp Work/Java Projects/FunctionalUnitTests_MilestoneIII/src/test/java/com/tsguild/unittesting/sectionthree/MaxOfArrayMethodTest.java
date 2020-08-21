/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 19bgehrman
 */
public class MaxOfArrayMethodTest {
    
    public MaxOfArrayMethodTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMaxOfArrayMethod() {
        int[] intArray = {1};
        int max = WorkWithArrays.maxOfArray(intArray);
        Assert.assertEquals("test for the max of array method", 1, max);
    }
    @Test
    public void testMaxOfArrayMethod2Nums() {
        int[] intArray = {3,4};
        int max = WorkWithArrays.maxOfArray(intArray);
        Assert.assertEquals("test for the max of array method", 4, max);
    }
    @Test
    public void testMaxOfArrayMethod3Nums() {
        int[] intArray = {3,4,5};
        int max = WorkWithArrays.maxOfArray(intArray);
        Assert.assertEquals("test for the max of array method", 5, max);
    }
    @Test
    public void testMaxOfArrayMethodNegative() {
        int[] intArray = {-9000, -700, -50, -3};
        int max = WorkWithArrays.maxOfArray(intArray);
        Assert.assertEquals("test for the max of array method", -3, max);
    }
    @Test
    public void testMaxOfArrayMethodEmptyOrNull() {
        int[] intArray = {};
        int max = WorkWithArrays.maxOfArray(intArray);
        Assert.assertEquals("test for the max of array method", 00, max);
    }
    @Test
    public void testMaxOfArrayMethodHugeNums() {
        int[] intArray = {100000, 6000000, 7000};
        int max = WorkWithArrays.maxOfArray(intArray);
        Assert.assertEquals("test for the max of array method", 6000000, max);
    }
    
}
