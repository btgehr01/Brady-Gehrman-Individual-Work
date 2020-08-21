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
public class returnTheFirstTest {
    
    public returnTheFirstTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testletterThatComesFirstMethod() {
        char letterOne = 'b';
        char letterTwo = 'a';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", 'a', firstLetter);
    }
     @Test
    public void testletterThatComesFirstMethod2() {
        char letterOne = 'a';
        char letterTwo = 'z';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", 'a', firstLetter);
    }
    @Test
    public void testletterThatComesFirstMethod3() {
        char letterOne = 'a';
        char letterTwo = 'b';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", 'a', firstLetter);
    }
    @Test
    public void testletterThatComesFirstMethodCapitals() {
        char letterOne = 'A';
        char letterTwo = 'B';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", 'a', firstLetter);
    }
    @Test
    public void testletterThatComesFirstMethodCapitals2() {
        char letterOne = 'Z';
        char letterTwo = 'A';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", 'a', firstLetter);
    }
    @Test
    public void testletterThatComesFirstMethodSameLetterCapitals() {
        char letterOne = 'Z';
        char letterTwo = 'z';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", 'z', firstLetter);
    }
    @Test
    public void testletterThatComesFirstMethodEmpty() {
        char letterOne = ' ';
        char letterTwo = ' ';
        char firstLetter = WorkWithLogic.returnTheFirst(letterOne, letterTwo);
        Assert.assertEquals("test to find the letter that comes first in the alphebet", ' ', firstLetter);
    }
    
}
