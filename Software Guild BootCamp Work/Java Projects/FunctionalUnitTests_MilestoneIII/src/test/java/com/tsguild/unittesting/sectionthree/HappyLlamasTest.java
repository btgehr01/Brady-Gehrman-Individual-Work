/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import static com.tsguild.unittesting.sectionthree.ExampleWork.areTheLlamasHappy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ahill
 */
public class HappyLlamasTest {
    
    /*  Test Plan:
    **  Normal trampoline tests!
    **  areTheLlamasHappy(false, 20) → false
    **  areTheLlamasHappy(false, 30) → true
    **  areTheLlamasHappy(false, 42) → true
    **  areTheLlamasHappy(false, 24) → true
    **  areTheLlamasHappy(false, 50) → false
    **  areTheLlamasHappy(false, 43) → false
    **  areTheLlamasHappy(false, 23) → false
    **
    **  Ultra-bouncy tests!
    **  areTheLlamasHappy(false, 20) → false
    **  areTheLlamasHappy(true, 30) → true
    **  areTheLlamasHappy(true, 42) → true
    **  areTheLlamasHappy(true, 43) → true
    **  areTheLlamasHappy(true, 60) → true
    **  areTheLlamasHappy(true, 24) → true
    **  areTheLlamasHappy(true, 2)  → false
    */
    
    public HappyLlamasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testNormalTrampoline20() {
        Assert.assertFalse( areTheLlamasHappy(false, 20) );
    }
    
    @Test
    public void testNormalTrampoline30() {
        Assert.assertTrue( areTheLlamasHappy(false, 30) );
    }

    @Test
    public void testNormalTrampoline42() {
        Assert.assertTrue( areTheLlamasHappy(false, 42) );
    }
    
    @Test
    public void testNormalTrampoline24() {
        Assert.assertTrue( areTheLlamasHappy(false, 24) );
    }

    @Test
    public void testNormalTrampoline50() {
        Assert.assertFalse( areTheLlamasHappy(false, 50) );
    }

    @Test
    public void testNormalTrampoline43() {
        Assert.assertFalse( areTheLlamasHappy(false, 43) );
    }
    
    @Test
    public void testNormalTrampoline23() {
        Assert.assertFalse( areTheLlamasHappy(false, 23) );
    }
    
    @Test
    public void testUltraBouncyTrampoline20() {
        Assert.assertFalse( areTheLlamasHappy(true, 20) );
    }
    
    @Test
    public void testUltraBouncyTrampoline30() {
        Assert.assertTrue( areTheLlamasHappy(true, 30) );
    }

    @Test
    public void testUltraBouncyTrampoline42() {
        Assert.assertTrue( areTheLlamasHappy(true, 42) );
    }
    
    @Test
    public void testUltraBouncyTrampoline43() {
        Assert.assertTrue( areTheLlamasHappy(true, 43) );
    }

    @Test
    public void testUltraBouncyTrampoline60() {
        Assert.assertTrue( areTheLlamasHappy(true, 60) );
    }
    
    @Test
    public void testUltraBouncyTrampoline24() {
        Assert.assertTrue( areTheLlamasHappy(true, 24) );
    }

    @Test
    public void testUltraBouncyTrampoline2() {
        Assert.assertFalse( areTheLlamasHappy(true, 2) );
    }
    
}
