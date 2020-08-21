/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.exercises.racer;

import com.tsguild.exercises.racer.helpers.RealAnnouncer;
import com.tsguild.exercises.racer.vehicles.DigitalPorshe;
import com.tsguild.exercises.racer.vehicles.PixelTank;
import com.tsguild.exercises.racer.vehicles.JWBeetle;
import com.tsguild.exercises.racer.vehicles.Vehicle;
import com.tsguild.exercises.racer.vehicles.DragRacer;
import com.tsguild.exercises.racer.vehicles.HamsterBall;
import com.tsguild.exercises.racer.interfaces.Driveable;
import com.tsguild.exercises.racer.tracks.Race;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ahill
 */
public class RaceTrackApp {

    private static final BigDecimal MILES_TO_THE_FINISH = new BigDecimal("100");
    
    public static void main(String[] args) {

        ApplicationContext carFactory = new ClassPathXmlApplicationContext("car-factory.xml");
        Driveable theBall = carFactory.getBean(HamsterBall.class);

        Vehicle theBeetle = carFactory.getBean(JWBeetle.class);
        Vehicle theTank = carFactory.getBean(PixelTank.class);
        Vehicle thePorshe = carFactory.getBean(DigitalPorshe.class);
        Vehicle theRacer = carFactory.getBean(DragRacer.class);
        Vehicle theJunker = carFactory.getBean("theJunker", Vehicle.class);
        
        Race theRace = carFactory.getBean(Race.class);

        theRace.setFirstRacer(theBeetle);
        theRace.setSecondRacer(theTank);
        theRace.setThirdRacer(thePorshe);
        theRace.setFourthRacer(theRacer);
        theRace.setFifthRacer(theJunker);
        theRace.setSixthRacer(theBall);
        
        theRace.runRace();

    }

}
