/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BirthdayCalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class BirthdayCalc {

    public static void main(String[] args) {

        LocalDate lD = LocalDate.now();
        Scanner input = new Scanner(System.in);
        String birthday;
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println("What is your date of birth? (MM-dd-yyyy)");
        birthday = input.nextLine();

        LocalDate birthD = LocalDate.parse(birthday, date);

        DayOfWeek dayOfWeek = birthD.getDayOfWeek();
        String dayOfTheWeek = dayOfWeek.toString().toLowerCase();
        System.out.println("That's a " + dayOfTheWeek);

        Period p = birthD.until(lD);
        int yearsOld = p.getYears();
        int nextAge = yearsOld + 1;

        String asPattern = lD.format(date);
        System.out.println("Today's Date is: " + asPattern);
        
        LocalDate bdayNow = birthD.plusYears(yearsOld);

        Long diffrence = ChronoUnit.DAYS.between(bdayNow, lD);
        if (bdayNow.isBefore(lD)) {
            LocalDate bdayNext = bdayNow.plusYears(1);
            diffrence = ChronoUnit.DAYS.between(lD, bdayNext);
            System.out.println(diffrence + " days till your next birthday");
            DayOfWeek dayOfWeekBirthdayNow = bdayNext.getDayOfWeek();
            String dayOfWeekNow = dayOfWeekBirthdayNow.toString().toLowerCase();
            System.out.println("That is on a " + dayOfWeekNow);
        } else {
            System.out.println(diffrence + " days till your next birthday");
            DayOfWeek dayOfWeekBirthdayNow = bdayNow.getDayOfWeek();
            String dayOfWeekNow = dayOfWeekBirthdayNow.toString().toLowerCase();
            System.out.println("That is on a " + dayOfWeekNow);
        }

        System.out.println("Bet you're excited to be :" + nextAge);

    }
}
