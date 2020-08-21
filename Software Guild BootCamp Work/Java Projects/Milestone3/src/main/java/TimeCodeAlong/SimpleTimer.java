/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeCodeAlong;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 19bgehrman
 */
public class SimpleTimer {
    public static void main(String[] args) {
        
        /*
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime currentTime;
        
        
        
        while(time.isBefore(time.plusMinutes(1))){
            if(time.equals(time))
            System.out.println(time.getSecond());
            
        }
        System.out.println("BEEEEEEEPPPPP");
        */
        
        
        
        
        
        
        
        
        
        
        
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime currentT = LocalDateTime.now();
        LocalDateTime minuteFromNow = startTime.plusMinutes(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("mm:ss");
        int oldSecond = 0;
        int secondsPast = 0;
        while(currentT.isBefore(minuteFromNow)){
       // while(secondsPast < 60){
            currentT = LocalDateTime.now();
            int currentSecond = currentT.getSecond();
            if(currentSecond != oldSecond){
                System.out.println(currentT.format(format));
                secondsPast ++;
            }
                oldSecond = currentSecond;
            
        }
        
        
        
    }
}
