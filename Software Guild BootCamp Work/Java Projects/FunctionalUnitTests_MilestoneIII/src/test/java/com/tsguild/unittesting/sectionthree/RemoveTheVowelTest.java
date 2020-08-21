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
public class RemoveTheVowelTest {
    
    public RemoveTheVowelTest() {
    }
    
    
//removeTheVowels( "truncate" ) ->  "trnct"
//    ** removeTheVowels( "squashed" ) ->  "sqshd"
//    ** removeTheVowels( "compressed" ) ->  "cmprssd"
    @Test
    public void testRemoveTheVowelMethodTruncate() {
        String word = "truncate";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "trnct";
        Assert.assertEquals("Remove The Vowel Method Truncate", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodExampleTwo() {
        String word = "squashed";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "sqshd";
        Assert.assertEquals("Remove The Vowel Method Truncate", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodExampleThree() {
        String word = "compressed";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "cmprssd";
        Assert.assertEquals("Remove The Vowel Method compressed", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodExampleThreeButUppercased() {
        String word = "Compressed";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "cmprssd";
        Assert.assertEquals("Remove The Vowel Method compressed but uppercased", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodExampleThreerandomUppercase() {
        String word = "ComPReSsEd";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "cmprssd";
        Assert.assertEquals("Remove The Vowel Method compressed random uppercase", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodBlankString() {
        String word = "";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "";
        Assert.assertEquals("Remove The Vowel Method blank String", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodNullString() {
        String word = null;
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = null;
        Assert.assertEquals("Remove The Vowel Method null String", expectedWord, wordWithoutVowels);
    }
    @Test
    public void testRemoveTheVowelMethodVeryLongString() {
        String word = "aeiouaeioussty";
        String wordWithoutVowels = WorkWithStrings.removeTheVowels(word);
        String expectedWord = "ssty";
        Assert.assertEquals("Remove The Vowel Method very long String", expectedWord, wordWithoutVowels);
    }
    
}
