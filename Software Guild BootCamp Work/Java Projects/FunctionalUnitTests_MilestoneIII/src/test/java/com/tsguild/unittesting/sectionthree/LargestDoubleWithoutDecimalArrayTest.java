/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class LargestDoubleWithoutDecimalArrayTest {
    
    public LargestDoubleWithoutDecimalArrayTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testLargestDoubleWithoutDecimaleMethod() {
       double[] doubles = { .039 , 20 , .005005 };
        int largestDoubleWithoutDecimal = WorkWithArrays.pointFree(doubles); 
        Assert.assertEquals("testLargestDoubleWithoutDecimal", 5005, largestDoubleWithoutDecimal);
    }
    public void testLargestDoubleWithoutDecimaleMethod1Num() {
       double[] doubles = {.005005 };
        int largestDoubleWithoutDecimal = WorkWithArrays.pointFree(doubles); 
        Assert.assertEquals("testLargestDoubleWithoutDecimal", 5005, largestDoubleWithoutDecimal);
    }
    @Test
    public void testLargestDoubleWithoutDecimaleMethod2Nums() {
       double[] doubles = { 1.1, .22 };
        int largestDoubleWithoutDecimal = WorkWithArrays.pointFree(doubles); 
        Assert.assertEquals("testLargestDoubleWithoutDecimal", 22, largestDoubleWithoutDecimal);
    }
    @Test
    public void testLargestDoubleWithoutDecimaleMethod3Nums() {
       double[] doubles = { -9.9 , -700 , -.5 };
        int largestDoubleWithoutDecimal = WorkWithArrays.pointFree(doubles); 
        Assert.assertEquals("testLargestDoubleWithoutDecimal", -5, largestDoubleWithoutDecimal);
    }
    @Test
    public void testLargestDoubleWithoutDecimaleMethodWithSmallDecimals() {
       double[] doubles = { .039 , 20 , .005005, .0054321 };
        int largestDoubleWithoutDecimal = WorkWithArrays.pointFree(doubles); 
        Assert.assertEquals("testLargestDoubleWithoutDecimal", 54321, largestDoubleWithoutDecimal);
    }
    @Test
    public void testLargestDoubleWithoutDecimaleMethodEmpty() {
       double[] doubles = {};
        int largestDoubleWithoutDecimal = WorkWithArrays.pointFree(doubles); 
        Assert.assertEquals("testLargestDoubleWithoutDecimal", 0, largestDoubleWithoutDecimal);
    }
    
}
