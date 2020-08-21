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
public class LongestWordMethodTest {

    public LongestWordMethodTest() {
    }

//    ongestWord( "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple" ) ->  "perspiration"
//    ** longestWord( "All well-established principles should be periodically challenged" ) ->  "well-established"
//    ** longestWord( "Never argue with the data" ) ->  "Never"
    @Test
    public void testSomeMethodVeryLongString() {
        String aPhrase = "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "perspiration";
         Assert.assertEquals("testing reverse method with a very long string", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodStringWithDashes() {
        String aPhrase = "All well-established principles should be periodically challenged";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "well-established";
         Assert.assertEquals("testing reverse method  with a StringWithDashes", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodWithEqualLengthStrings() {
        String aPhrase = "Never argue with the data";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "Never";
         Assert.assertEquals("testing reverse method  with a Equal length Strings", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodWithEmptyStrings() {
        String aPhrase = "";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "";
         Assert.assertEquals("testing reverse method with an empty String", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodWithNullStrings() {
        String aPhrase = null;
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = null;
         Assert.assertEquals("testing reverse method with a null String", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodWithOneLongString() {
        String aPhrase = "hhhhhhgjfjjdjjdjskskdjfhj";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "hhhhhhgjfjjdjjdjskskdjfhj";
         Assert.assertEquals("testing reverse method with one long String", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodWithATwoLetterString() {
        String aPhrase = "a b";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "a";
         Assert.assertEquals("testing reverse method with a two letter with spaced in between them String", expectedLongestWord, longestWord);
    }
    @Test
    public void testSomeMethodWithCapitalWords() {
        String aPhrase = "Bob John";
        String longestWord = WorkWithStrings.longestWord(aPhrase);
        String expectedLongestWord = "John";
         Assert.assertEquals("testing reverse method with capital words", expectedLongestWord, longestWord);
    }

}
