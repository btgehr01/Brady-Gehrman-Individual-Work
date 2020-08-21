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
public class WhatColorTest {

    public WhatColorTest() {
    }
//whatColor( 575, 510, 2.15 ) ->  "Yellow"
//    ** whatColor( 449, 670, 3.00 ) ->  "Violet"
//    ** whatColor( 621, 475, 16.5 ) ->  "Unknown"
//    ** whatColor( 590, 508, 2.05 ) ->  "Orange"
//    ** whatColor( 570, 526, 2.17 ) ->  "Yellow-Green"
    @Test
    public void testWhatColorViolet() {
        int waveLengthNM = 449;
        int frequencyTHZ = 670;
        double photonicEnergyEV = 3.00;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Violet";
        Assert.assertEquals("test for violet", expectedColor, color);
    }
    @Test
    //Orange	590–620 nm	484–508 THz	2.00–2.10 eV
    public void testWhatColorOrange() {
        int waveLengthNM = 600;
        int frequencyTHZ = 490;
        double photonicEnergyEV = 2.05;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Orange";
        Assert.assertEquals("test for orange", expectedColor, color);
    }
    //Blue	450–495 nm	606–668 THz	2.50–2.75 eV
    @Test
    public void testWhatColorBlue() {
        int waveLengthNM = 460;
        int frequencyTHZ = 610;
        double photonicEnergyEV = 2.51;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Blue";
        Assert.assertEquals("test for blue", expectedColor, color);
    }
    //Red	620–750 nm	400–484 THz	1.65–2.00 eV
    @Test
    public void testWhatColorRed() {
        int waveLengthNM = 630;
        int frequencyTHZ = 410;
        double photonicEnergyEV = 1.75;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Red";
        Assert.assertEquals("test for red", expectedColor, color);
    }
    //Green	495–570 nm	526–606 THz	2.17–2.50 eV
    @Test
    public void testWhatColorGreen() {
        int waveLengthNM = 500;
        int frequencyTHZ = 530;
        double photonicEnergyEV = 2.25;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Green";
        Assert.assertEquals("test for green", expectedColor, color);
    }
    //Yellow	570–590 nm	508–526 THz	2.10–2.17 eV
    @Test
    public void testWhatColorYellow() {
        int waveLengthNM = 580;
        int frequencyTHZ = 520;
        double photonicEnergyEV = 2.15;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Yellow";
        Assert.assertEquals("test for yellow", expectedColor, color);
    }
    //** whatColor( 570, 526, 2.17 ) ->  "Yellow-Green"
    @Test
    public void testWhatColorOverlapping() {
        int waveLengthNM = 570;
        int frequencyTHZ = 526;
        double photonicEnergyEV = 2.17;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Yellow-Green";
        Assert.assertEquals("test for yellow-green", expectedColor, color);
    }
    //** whatColor( 621, 475, 16.5 ) ->  "Unknown"
    @Test
    public void testWhatColorOutOfBoundsHigh() {
        int waveLengthNM = 621;
        int frequencyTHZ = 475;
        double photonicEnergyEV = 16.5;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Unknown";
        Assert.assertEquals("test for unknown", expectedColor, color);
    }
    @Test
    public void testWhatColorOutOfBoundsLow() {
        int waveLengthNM = 621;
        int frequencyTHZ = 475;
        double photonicEnergyEV = 0.001;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Unknown";
        Assert.assertEquals("test for unknown", expectedColor, color);
    }
    @Test
    public void testWhatColorOutOfBoundsWave() {
        int waveLengthNM = 10000;
        int frequencyTHZ = 475;
        double photonicEnergyEV = 2.2;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Unknown";
        Assert.assertEquals("test for unknown", expectedColor, color);
    }
    @Test
    public void testWhatColorOutOfBoundsFreq() {
        int waveLengthNM = 500;
        int frequencyTHZ = 10000;
        double photonicEnergyEV = 2.2;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Unknown";
        Assert.assertEquals("test for unknown", expectedColor, color);
    }
    ////Red	620–750 nm	400–484 THz	1.65–2.00 eV
    ////Orange	590–620 nm	484–508 THz	2.00–2.10 eV
    @Test
    public void testWhatColorRedOrange() {
        int waveLengthNM = 700;
        int frequencyTHZ = 484;
        double photonicEnergyEV = 2.00;
        String color = WorkWithLogic.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        String expectedColor= "Red-Orange";
        Assert.assertEquals("test for Red-Orange", expectedColor, color);
    }

}
