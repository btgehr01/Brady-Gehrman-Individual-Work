/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class StaticMethods {

    public static String colorThingOne(String color) {
        String aColor;
        if (color.equals("red")) {
            aColor = "blue";
        } else {
            aColor = "green";
        }

        return aColor;
    }

    public static String colorThingTwo(String color) {
        if (color.equals("red")) {
            return "blue";
        } else {
            return "green";
        }
    }
    public static int highestNum(int one, int two, int three){
        int max = 0;
        if(one > two && one > three){
        max = one;
    }
     if(two > one && two > three){
         max = two;
     }   
     if(three > one && three > two){
         max = three;
     }
     return max;
    }

}
