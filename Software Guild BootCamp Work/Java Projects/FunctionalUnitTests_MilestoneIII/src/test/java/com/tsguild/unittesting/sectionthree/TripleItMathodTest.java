/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unittesting.sectionthree;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class TripleItMathodTest {

    public TripleItMathodTest() {
    }

//tripleIt( "Llama" ) ->  "llamaLLAMAllama"
//    ** tripleIt( "ha" ) ->  "haHAha"
//    ** tripleIt( "Beetlejuice" ) ->  "beetlejuiceBEETLEJUICEbeetlejuice"
    @Test
    public void testTripleItMethodPascalCasedWord() {
        String stringToTriple = "Llama";
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = "llamaLLAMAllama";
        Assert.assertEquals("tipled method test with Pascal Cased", expectedTripledString, tripled);
    }
    @Test
    public void testTripleItMethodLowerCasedWord() {
        String stringToTriple = "ha";
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = "haHAha";
        Assert.assertEquals("tipled method test with LowerCasedWord", expectedTripledString, tripled);
    }
    @Test
    public void testTripleItMethodLongWordUppercased() {
        String stringToTriple = "Beetlejuice";
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = "beetlejuiceBEETLEJUICEbeetlejuice";
        Assert.assertEquals("tipled method test with UpperCasedLongWord", expectedTripledString, tripled);
    }
    @Test
    public void testTripleItMethodLongWordLowercased() {
        String stringToTriple = "beetlejuice";
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = "beetlejuiceBEETLEJUICEbeetlejuice";
        Assert.assertEquals("tipled method test with LowerCasedLongWord", expectedTripledString, tripled);
    }
    @Test
    public void testTripleItMethodBlankString() {
        String stringToTriple = "";
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = "";
        Assert.assertEquals("tipled method test with blank string", expectedTripledString, tripled);
    }
    @Test
    public void testTripleItMethodSpaceString() {
        String stringToTriple = " ";
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = "   ";
        Assert.assertEquals("tipled method test with spaced string", expectedTripledString, tripled);
    }
    @Test
    public void testTripleItMethodNullString() {
        String stringToTriple = null;
        String tripled = WorkWithStrings.tripleIt(stringToTriple);
        String expectedTripledString = null;
        Assert.assertEquals("tipled method test with null string", expectedTripledString, tripled);
    }

}
