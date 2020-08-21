/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone3;

import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class HowManyDaysUntilFriday {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numOfDaysTillFriday = 0;
        boolean dayNotGiven = true;
        while (dayNotGiven) {
            System.out.println("What day of the week is it for you today?");
            String dayString = input.nextLine().toUpperCase();
            DayOfTheWeek day = DayOfTheWeek.valueOf(dayString);
            switch (day) {
                case MONDAY:
                    numOfDaysTillFriday = 4;
                    dayNotGiven = false;
                    break;
                case TUESDAY:
                    numOfDaysTillFriday = 3;
                    dayNotGiven = false;
                    break;
                case WEDNESDAY:
                    numOfDaysTillFriday = 2;
                    dayNotGiven = false;
                    break;
                case THURSDAY:
                    numOfDaysTillFriday = 1;
                    dayNotGiven = false;
                    break;
                case FRIDAY:
                    numOfDaysTillFriday = 0;
                    dayNotGiven = false;
                    break;
                case SATURDAY:
                    numOfDaysTillFriday = 6;
                    dayNotGiven = false;
                    break;
                case SUNDAY:
                    numOfDaysTillFriday = 5;
                    dayNotGiven = false;
                    break;
                default:
                    dayNotGiven = true;
                    break;
            }
        }
        System.out.println("There are " + numOfDaysTillFriday + " days till friday!!");

    }
}
