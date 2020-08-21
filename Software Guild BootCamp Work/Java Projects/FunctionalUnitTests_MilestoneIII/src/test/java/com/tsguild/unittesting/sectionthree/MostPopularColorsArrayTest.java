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
public class MostPopularColorsArrayTest {

    public MostPopularColorsArrayTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testColorMethod() {
        String[] colors = {"Red", "Blue", "Red", "Blue", "Red", "Blue", "Red"};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "Red", mostCommonColor);
    }

    @Test
    public void testColorMethodOneOfEach() {
        String[] colors = {"Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red"};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "Violet", mostCommonColor);
    }

    @Test
    public void testColorMethod3() {
        String[] colors = {"Green", "Green", "Green", "Green", "Green", "Red", "Green"};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "Green", mostCommonColor);
    }

    @Test
    public void testColorMethod4() {
        String[] colors = {"Red", "Blue", "Yellow", "Blue", "Red", "Blue", "Blue"};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "Blue", mostCommonColor);
    }
    @Test
    public void testColorMethodOneOfEach2() {
        String[] colors = {"Red", "Blue", "yellow"};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "Red", mostCommonColor);
    }
     @Test
    public void testColorMethodOneOfEach3() {
        String[] colors = {"Red", "Blue"};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "Red", mostCommonColor);
    }
    @Test
    public void testColorMethodEmpty() {
        String[] colors = {};
        String mostCommonColor = WorkWithArrays.mostCommonColor(colors);
        Assert.assertEquals("This is the test for mostCommonColor", "", mostCommonColor);
    }

}
