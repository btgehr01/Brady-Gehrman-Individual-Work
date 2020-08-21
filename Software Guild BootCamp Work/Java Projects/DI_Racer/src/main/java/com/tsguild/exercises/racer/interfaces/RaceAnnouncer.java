/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.exercises.racer.interfaces;

import com.tsguild.exercises.racer.interfaces.Driveable;
import com.tsguild.exercises.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;

/**
 *
 * @author ahill
 */
public interface RaceAnnouncer {

    void announceBreakdown(VehicleException boom, Driveable aRacer);

    void announceDriverPlacement(int place, Driveable aRacer);

    void announceNoMechanic(Driveable aRacer);

    void announceRace();

    void announceRacerBeginRound(Driveable aRacer);

    void announceRacerJoin(Driveable aRacer);

    void announceRacerOdometer(Driveable aRacer);

    void announceRacerProgress(Driveable aRacer, BigDecimal milesTraveled);

    void announceRoundEnd(int round);

    void announceRoundStart(int round);

    void announceWinner(Driveable aRacer);
    
}
