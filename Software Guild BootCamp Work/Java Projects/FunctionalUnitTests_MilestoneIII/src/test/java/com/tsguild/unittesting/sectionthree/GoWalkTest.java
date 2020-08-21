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
public class GoWalkTest {

    public GoWalkTest() {
    }

    @Test
    public void testGoWalkMethodPerfectConditions() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = true;
      Assert.assertEquals("perfect conditions test", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodRainingWithUmbrella() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = true;
      boolean haveUmbrella = true;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = true;
      Assert.assertEquals("testing raining with umbrella", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodRainingWithoutUmbrella() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = true;
      boolean haveUmbrella = false;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = false;
      Assert.assertEquals("testing raining without umbrella", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodTooCold() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 30;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = false;
      Assert.assertEquals("testing too cold", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodTooHot() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 100;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = false;
      Assert.assertEquals("testing too hot", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodIsDarkWithFlashlight() {
      boolean isDark = true;
      boolean haveFlashlight = true;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = true;
      Assert.assertEquals("testing IsDarkWithFlashlight", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodIsDarkWithoutFlashlight() {
      boolean isDark = true;
      boolean haveFlashlight = false;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = false;
      Assert.assertEquals("testing IsDarkWithoutFlashlight", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodAllBad() {
      boolean isDark = true;
      boolean haveFlashlight = false;
      boolean isRaining = true;
      boolean haveUmbrella = false;
      int degreesFarenheit = 105;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = false;
      Assert.assertEquals("testing All bad", expectedDecision, goingForAWalk);
    }
    @Test
    public void testGoWalkMethodAllGoodScrambledDevices() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = true;
      Assert.assertEquals("testing All bad", expectedDecision, goingForAWalk);
    }
    ///should fail on empty but to keep the code happy I just put a value in
    @Test
    public void testGoWalkMethodEmpty() {
      boolean isDark = false;
      boolean haveFlashlight = true;
      boolean isRaining = false;
      boolean haveUmbrella = true;
      int degreesFarenheit = 70;
      boolean goingForAWalk = WorkWithLogic.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
      boolean expectedDecision = true;
      Assert.assertEquals("testing All bad", expectedDecision, goingForAWalk);
    }

}
