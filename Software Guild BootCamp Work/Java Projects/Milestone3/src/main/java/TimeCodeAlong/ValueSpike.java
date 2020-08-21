/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeCodeAlong;

/**
 *
 * @author 19bgehrman
 */
public class ValueSpike {

    public static void main(String[] args) {
        int sensorValue1 = 0; //read another value from the sensor
        //wait for 10 miliseconds
        int sensorValue2 = 0; //read another value from the sensor
        int secondsPassed = 0;
        int diffrence = sensorValue2 - sensorValue1;
        while (diffrence > 100) {
            //wait 10 miliseconds
            secondsPassed = secondsPassed + 1;
            if (secondsPassed < .5 && sensorValue2 == sensorValue1) {
                //turn on light for 2 seconds
                diffrence = 0; // stop while loop
            }
            if (secondsPassed > 1) {
                diffrence = 0; // stop while loop
            }
        }

    }

}
//three read method
//get three readings 5 miliseconds aparts and see if two is greater than one
//then check to mak sure 3 is close to one to see the spike