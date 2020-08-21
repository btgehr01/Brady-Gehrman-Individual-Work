/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import static com.tsguild.unittesting.sectionthree.ExampleWork.howManyWoofs;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ahill
 */
public class HowManyWoofsTest {

    /*  Test Plan:
    **  howManyWoofs(10)   -> "Woof! Woof! Woof!"
    **  howManyWoofs(5)    -> "Woof! Woof!"
    **  howManyWoofs(2)    -> "Woof! Woof! Woof!"
    **  howManyWoofs(0)    -> "..."
    **  howManyWoofs(-10)  -> "..."
    **  howManyWoofs(-5)   -> "..."
    */
    
    @Test
    public void testTenBones() {
        String expectedWoofs = "Woof! Woof! Woof!";
        Assert.assertEquals(expectedWoofs, howManyWoofs(10));
    }
    
    @Test
    public void testFiveBones() {
        String expectedWoofs = "Woof! Woof!";
        Assert.assertEquals(expectedWoofs, howManyWoofs(5));
    }
    
    @Test
    public void testTwoBones() {
        String expectedWoofs = "Woof! Woof! Woof!";
        Assert.assertEquals(expectedWoofs, howManyWoofs(2));
    }
    
    @Test
    public void testZeroBones() {
        String expectedWoofs = "...";
        Assert.assertEquals(expectedWoofs, howManyWoofs(0));
    }
    
    @Test
    public void testNegativeTenBones() {
        String expectedWoofs = "...";
        Assert.assertEquals(expectedWoofs, howManyWoofs(-10));
    }
    
    @Test
    public void testNegativeFiveBones() {
        String expectedWoofs = "...";
        Assert.assertEquals(expectedWoofs, howManyWoofs(-5));
    }
}
