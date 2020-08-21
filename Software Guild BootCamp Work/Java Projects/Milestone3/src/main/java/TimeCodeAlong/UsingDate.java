/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeCodeAlong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 19bgehrman
 */
public class UsingDate {

    public static void main(String[] args) {
        LocalDate rightNow = LocalDate.now();
        System.out.println(rightNow);

        LocalDateTime rightNowWithTime = LocalDateTime.now();
        System.out.println(rightNowWithTime);

        DateTimeFormatter aBasicFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String nowAsString = rightNowWithTime.format(aBasicFormat);
        System.out.println(nowAsString);
        
        
        LocalDateTime tomorrow = rightNowWithTime.plusDays(1);
        System.out.println(tomorrow.getDayOfMonth());
        
        

        
        
    }
}
