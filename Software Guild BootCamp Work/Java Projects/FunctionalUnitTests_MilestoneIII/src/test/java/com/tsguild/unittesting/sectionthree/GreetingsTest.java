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
public class GreetingsTest {

    public GreetingsTest() {
    }

    @Test
    public void testGreetingFriend() {
        String visitorName = "Fred";
        boolean isFriend = true;
        String greeting = WorkWithLogic.friendlyGreeting(visitorName, isFriend);
        String expectedGreeting = "Hello, Fred!";
        Assert.assertEquals("testing the greeting for a friend", expectedGreeting, greeting);
    }
    @Test
    public void testGreetingDiffrentFriend() {
        String visitorName = "Gallant";
        boolean isFriend = true;
        String greeting = WorkWithLogic.friendlyGreeting(visitorName, isFriend);
        String expectedGreeting = "Hello, Gallant!";
        Assert.assertEquals("testing the greeting for a friend", expectedGreeting, greeting);
    }
    @Test
    public void testGreetingIsntFriend() {
        String visitorName = "Bob";
        boolean isFriend = false;
        String greeting = WorkWithLogic.friendlyGreeting(visitorName, isFriend);
        String expectedGreeting = "hi";
        Assert.assertEquals("testing the greeting not a friend", expectedGreeting, greeting);
    }
    @Test
    public void testGreetingIsFriendNoName() {
        String visitorName = "";
        boolean isFriend = true;
        String greeting = WorkWithLogic.friendlyGreeting(visitorName, isFriend);
        String expectedGreeting = "Hello, !";
        Assert.assertEquals("testing the greeting for a friend", expectedGreeting, greeting);
    }
    @Test
    public void testGreetingIsntFriendNoName() {
        String visitorName = "";
        boolean isFriend = false;
        String greeting = WorkWithLogic.friendlyGreeting(visitorName, isFriend);
        String expectedGreeting = "hi";
        Assert.assertEquals("testing the greeting not a friend", expectedGreeting, greeting);
    }
    @Test
    public void testGreetingFriendNullName() {
        String visitorName = null;
        boolean isFriend = true;
        String greeting = WorkWithLogic.friendlyGreeting(visitorName, isFriend);
        String expectedGreeting = "...";
        Assert.assertEquals("testing the greeting not a friend", expectedGreeting, greeting);
    }

}
