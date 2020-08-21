/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.firsttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 19bgehrman
 */
public class AddStuffTest {
    
    public AddStuffTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
       int inputOne = 5;
       int inputTwo = 10;
               
       int result = SomeMethods.addStuff(inputOne, inputTwo);
       
       Assert.assertEquals("I added 5 + 10", 15, result);
    }
    @Test
    public void addStuffLarge(){
       int inputOne = 50000;
       int inputTwo = 100000;
               
       int result = SomeMethods.addStuff(inputOne, inputTwo);
       
       Assert.assertEquals("I added 50000 + 100000", 150000, result);
    }
    @Test
    public void AddStuffNegative(){
      int inputOne = -5;
      int inputTwo = -20;
               
       int result = SomeMethods.addStuff(inputOne, inputTwo);
       
       Assert.assertEquals("I added -5 + -20", -25, result);  
    }
    
}
