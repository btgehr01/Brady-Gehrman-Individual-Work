/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class MultiplyArrayMethodTest {

    public MultiplyArrayMethodTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testMultiplyArrayMethod() {
        int multiplier = 5;
        int[] intArray = {1, 2, 3, 4, 5};
        int[] products = WorkWithArrays.multiplyAll(multiplier, intArray);
        int[] expectedProducts = {5, 10, 15, 20, 25};
        Assert.assertArrayEquals("test for the multiply all method", expectedProducts, products);
    }

    @Test
    public void testMultiplyArrayMethodZero() {
        int multiplier = 0;
        int[] intArray = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] products = WorkWithArrays.multiplyAll(multiplier, intArray);
        int[] expectedProducts = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assert.assertArrayEquals("test for the multiply all method", expectedProducts, products);
    }

    @Test
    public void testMultiplyArrayMethod3() {
        int multiplier = -1;
        int[] intArray = {-2, 0, 0, 1};
        int[] products = WorkWithArrays.multiplyAll(multiplier, intArray);
        int[] expectedProducts = {2, 0, 0, -1};
        Assert.assertArrayEquals("test for the multiply all method", expectedProducts, products);
    }
    @Test
    public void testMultiplyArrayMethodBigMultiplier() {
        int multiplier = 100;
        int[] intArray = {-2, 0, 0, 1};
        int[] products = WorkWithArrays.multiplyAll(multiplier, intArray);
        int[] expectedProducts = {-200, 0, 0, 100};
        Assert.assertArrayEquals("test for the multiply all method", expectedProducts, products);
    }
    @Test
    public void testMultiplyArrayMethodBigNums() {
        int multiplier = 2;
        int[] intArray = {-2000, 0, 0, 1000};
        int[] products = WorkWithArrays.multiplyAll(multiplier, intArray);
        int[] expectedProducts = {-4000, 0, 0, 2000};
        Assert.assertArrayEquals("test for the multiply all method", expectedProducts, products);
    }
    @Test
    public void testMultiplyArrayMethodArrayEmpty() {
        int multiplier = 2;
        int[] intArray = {};
        int[] products = WorkWithArrays.multiplyAll(multiplier, intArray);
        int[] expectedProducts = {};
        Assert.assertArrayEquals("test for the multiply all method", expectedProducts, products);
    }

}
