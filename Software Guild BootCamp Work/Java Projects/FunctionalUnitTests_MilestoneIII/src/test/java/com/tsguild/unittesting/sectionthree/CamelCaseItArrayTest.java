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
public class CamelCaseItArrayTest {
    
    public CamelCaseItArrayTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCamelCaseMethod() {
        String[] sentenceWithWords = {"llama", "llama", "duck"};
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", "llamaLlamaDuck", sentence);
    }
    @Test
    public void testCamelCaseMethodNames() {
        String[] sentenceWithWords = {"bobby", "joe", "smith"};
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", "bobbyJoeSmith", sentence);
    }
    @Test
    public void testCamelCaseMethoddAllLowercase() {
        String[] sentenceWithWords = {"lambs", "eat", "oats", "and", "does", "eat", "oats"};
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", "lambsEatOatsAndDoesEatOats", sentence);
    }
    @Test
    public void testCamelCaseMethodAllUppercase() {
        String[] sentenceWithWords = {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"};
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", "doOrDoNotThereIsNoTry", sentence);
    }
    @Test
    public void testCamelCaseMethodEmpty() {
        String[] sentenceWithWords = {""};
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", "", sentence);
    }
    @Test
    public void testCamelCaseMethodNull() {
        String[] sentenceWithWords = null;
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", null, sentence);
    }
    @Test
    public void testCamelCaseMethodOneWord() {
        String[] sentenceWithWords = {"bobby", "j", "s"};
        String sentence = WorkWithArrays.camelCaseIt(sentenceWithWords);
        Assert.assertEquals("This is the test for CamelCaseIt", "bobbyJS", sentence);
    }
    
    
    
}
