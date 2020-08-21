/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 19bgehrman
 */
public class CamelTest {

    Camel testCamel;

    @Before
    public void setUp() {
        testCamel = new Camel("Sue", 2, 4);
    }

    @Test
    public void testCamelSpit() {
        String camelSpit = testCamel.spit();
        assertEquals("Checking camel spit", "PTOOOOOEY", camelSpit);
    }

    @Test
    public void testCamelSpitWhenOutOfSpit() {
        testCamel.setAmountOfSpit(0);
        String camelSpit = testCamel.spit();
        assertEquals("Checking camel spit", "ttttthhpthhh", camelSpit);
    }
    @Test
    public void testCamelMultiSpit() {
        testCamel.setAmountOfSpit(10);
        
        for (int i = 10; i > 0; i--) {
        assertEquals("Checking camel spit", i, testCamel.getAmountOfSpit());
            
            
        String camelSpit = testCamel.spit();
        assertEquals("Checking camel spit", "PTOOOOOEY", camelSpit);
        
        assertEquals("Checking camel spit", i - 1, testCamel.getAmountOfSpit());
        
        }
        String camelSpit = testCamel.spit();
        assertEquals("Checking camel spit", "ttttthhpthhh", camelSpit); 
    }
     @Test
    public void testMadCamelSpit() {
        testCamel.poke(); //make it mad
        int amountOfSpitBefore = testCamel.getAmountOfSpit();
        String camelSpit  = testCamel.spit(); 
        String expectedSpit = "PTOOOOOEY PTOOOOOEY PTOOOOOEY PTOOOOOEY PTOOOOOEY";
        int amountOfSpitAfter = testCamel.getAmountOfSpit();
        assertEquals("checking the camel spit", expectedSpit, camelSpit);
        assertEquals("checking that it lost the right amount of spit", amountOfSpitBefore - 5, amountOfSpitAfter);
        
    }

}
