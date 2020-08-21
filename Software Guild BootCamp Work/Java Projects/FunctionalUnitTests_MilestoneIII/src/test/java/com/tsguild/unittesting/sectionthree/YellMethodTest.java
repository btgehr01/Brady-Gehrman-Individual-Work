/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class YellMethodTest {

    public YellMethodTest() {
    }
//    yell( "Hello there." ) ->  "HELLO THERE."
//    ** yell( "shhhhhhhhhhhh" ) ->  SHHHHHHHHHHHH
//    ** yell( "AAaAAAaAAAaaAAHHHH" ) ->  "AAAAAAAAAAAAAAHHHH"

    @Test
    public void testYellMethodNames() {
    String wordToYell= "bob";
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = "BOB";
    Assert.assertEquals("testing yell method with names", expectedYelledWord, yelledWord);
    }
    @Test
    public void testYellMethodGreetingAndAPeriod() {
    String wordToYell= "Hello there.";
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = "HELLO THERE.";
    Assert.assertEquals("testing yell method with greetings and a period", expectedYelledWord, yelledWord);
    }
    @Test
    public void testYellMethodShhhh() {
    String wordToYell= "shhhhhhhhhhhh";
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = "SHHHHHHHHHHHH";
    Assert.assertEquals("testing yell method with shhhh", expectedYelledWord, yelledWord);
    }
    @Test
    public void testYellMethodAhhhhDiffrentCasedLetters() {
    String wordToYell= "AAaAAAaAAAaaAAHHHH";
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = "AAAAAAAAAAAAAAHHHH";
    Assert.assertEquals("testing yell method Ahhhh", expectedYelledWord, yelledWord);
    }
    @Test
    public void testYellMethodExclamationMark() {
    String wordToYell= "AAaAAAaAAAaaAAHHHH!";
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = "AAAAAAAAAAAAAAHHHH!";
    Assert.assertEquals("testing yell method Ahhhh and exclamation mark", expectedYelledWord, yelledWord);
    }
    @Test
    public void testYellMethodStringBlank() {
    String wordToYell= "";
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = "";
    Assert.assertEquals("testing yell method string is blank", expectedYelledWord, yelledWord);
    }
    @Test
    public void testYellMethodStringIsNull() {
    String wordToYell= null;
    String yelledWord = WorkWithStrings.yell(wordToYell);
    String expectedYelledWord = null;
    Assert.assertEquals("testing yell method string is null", expectedYelledWord, yelledWord);
    }

}
