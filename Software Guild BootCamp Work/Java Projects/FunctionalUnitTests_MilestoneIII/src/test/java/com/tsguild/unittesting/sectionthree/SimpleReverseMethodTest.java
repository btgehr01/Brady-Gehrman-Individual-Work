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
public class SimpleReverseMethodTest {

    public SimpleReverseMethodTest() {
    }
//    simpleReverse( "fun times" ) ->  "semit nuf"
//    ** simpleReverse( "llama llama duck" ) ->  "kcud amall amall"
//    ** simpleReverse( "hannah" ) ->  "hannah"

    @Test
    public void testSimpleReverseMethod() {
        String phrase = "fun times";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "semit nuf";
        Assert.assertEquals("testing reverse method example1", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodMultipleWordsInAString() {
        String phrase = "llama llama duck";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "kcud amall amall";
        Assert.assertEquals("testing reverse method MultipleWordsInAString", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodSameWordBackwardsAndForwards() {
        String phrase = "hannah";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "hannah";
        Assert.assertEquals("testing reverse method SameWordBackwardsAndForward", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodEmpty() {
        String phrase = "";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "";
        Assert.assertEquals("testing reverse empty string", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodNull() {
        String phrase = null;
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = null;
        Assert.assertEquals("testing reverse method null string", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodLongString() {
        String phrase = "aeioubgh";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "hgbuoiea";
        Assert.assertEquals("testing reverse long string", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodOneLetterString() {
        String phrase = "a";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "a";
        Assert.assertEquals("testing reverse one letter string", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodIndividualLetters() {
        String phrase = "a b c d";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "d c b a";
        Assert.assertEquals("testing reverse method IndividualLetters with spaces", expectedReversedPhrase, reversedPhrase);
    }
    @Test
    public void testSimpleReverseMethodCapitals() {
        String phrase = "ABC";
        String reversedPhrase = WorkWithStrings.simpleReverse(phrase);
        String expectedReversedPhrase = "CBA";
        Assert.assertEquals("testing reverse method with capitals", expectedReversedPhrase, reversedPhrase);
    }


}
