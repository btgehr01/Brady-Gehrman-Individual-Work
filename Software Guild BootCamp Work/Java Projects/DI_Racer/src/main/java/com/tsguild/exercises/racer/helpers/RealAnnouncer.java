/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.exercises.racer.helpers;

import com.tsguild.exercises.racer.interfaces.RaceAnnouncer;
import com.tsguild.exercises.racer.interfaces.Driveable;
import com.tsguild.exercises.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author ahill
 */
public class RealAnnouncer implements RaceAnnouncer {

    @Override
    public void announceRace() {
        System.out.println("");
        System.out.println("WELCOME TO THE RACES!");
        System.out.println("We've got a great selection here today...");
    }

    @Override
    public void announceRacerJoin(Driveable aRacer) {
        System.out.println(aRacer.getIdentifier() + " is joining the race!!!");
    }

    @Override
    public void announceRoundStart(int round) {
        System.out.println("");
        System.out.println("Let's get started on round#" + round + "!!!");
    }

    @Override
    public void announceRoundEnd(int round) {
        System.out.println("");
        System.out.println("Now that round#" + round + " is coming to an end, let's see the results!!!");
    }

    @Override
    public void announceRacerBeginRound(Driveable aRacer) {
        System.out.println(aRacer.getIdentifier() + " is about to drive ...");
    }

    @Override
    public void announceRacerOdometer(Driveable aRacer) {
        System.out.println(aRacer.getIdentifier() + "'s odometer reads: " + aRacer.readOdometer());
    }

    @Override
    public void announceRacerProgress(Driveable aRacer, BigDecimal milesTraveled) {
        System.out.println(aRacer.getIdentifier() + " traveled " + milesTraveled + " mi. this round!");
    }

    @Override
    public void announceDriverPlacement(int place, Driveable aRacer) {
        if (aRacer.isBrokenDown()) {
            System.out.println(place + ") " + aRacer.getIdentifier() + " is broken down on the track @ " + aRacer.readOdometer() + " mi.");
        } else {
            System.out.println(place + ") " + aRacer.getIdentifier() + " @ " + aRacer.readOdometer() + " mi.");
        }
    }

    @Override
    public void announceNoMechanic(Driveable aRacer) {
        System.out.println("A shame there's no mechanic on the field, looks like "+aRacer.getIdentifier()+" out there on the track could really use one!");
    }

    @Override
    public void announceBreakdown(VehicleException boom, Driveable aRacer) {
        System.out.println(boom.getMessage());
        System.out.println("OH NO! It seems like " + aRacer.getShortDescription() + " has had some trouble w/ a " + boom.getClass().getSimpleName() + ".");
        System.out.println("Looks like they won't be going anywhere in a hurry ...");
        System.out.println("");
    }

    @Override
    public void announceWinner(Driveable aRacer) {
        System.out.println("And that's it! The race is over!");
        System.out.println("");
        System.out.println("");
        System.out.println("AND THE GRAND WINNER IS.........");
        if (aRacer != null) {
            System.out.println(aRacer.getIdentifier() + " !!!!!!!");
        } else {
            System.out.println("Absolutely no one! What a rough race!");
            System.out.println("Looks like we ran out of time. No winners this time!");
        }
    }

}
