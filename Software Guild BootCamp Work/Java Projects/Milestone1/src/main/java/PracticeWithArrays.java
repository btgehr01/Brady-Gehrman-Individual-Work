/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class PracticeWithArrays {

    public static void main(String[] args) {
        //declare the herd
        String[] llamaHerd;
        //declare space for the herd
        llamaHerd = new String[8];
        //now I can put llamas in the herd
        llamaHerd[0] = "Beebop";
        llamaHerd[1] = "Floyd";
        llamaHerd[2] = "Prism";
        llamaHerd[3] = "Oreo";
        llamaHerd[4] = "Dixie";
        llamaHerd[5] = "Secret";
        llamaHerd[6] = "Penny";
        llamaHerd[7] = "Angelina";

        System.out.println("I have " + llamaHerd.length + " llamas in my herd");

        for (int index = 0; index < llamaHerd.length; index++) {

            System.out.println("My Llama in place#" + index
                    + " is:" + llamaHerd[index]);
        }

        System.out.println("Lets Prints Out Every Other Llama");
        for (int i = 0; i < llamaHerd.length; i = i + 2) {
            System.out.println(llamaHerd[i]);

        }
        //now lets use some numbers
        System.out.println("doing some number work..");
        double[] someNums = {1.0, 42.6, 45.99, 33.2};
        System.out.println("the last number is" + someNums[3]);
        
        double result = someNums[0] + someNums[1] + someNums[2] + someNums[3];
        System.out.println("the total of those numbers are: " + result);
        
        int[] moarNums 
                = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
                int sumResult = 0;
        for (int i = 0; i < moarNums.length; i++) {
            
            System.out.println(moarNums[i]);
            sumResult = sumResult + moarNums[i];
            
        }
        
        System.out.println("those all add up to " + sumResult);

    }

}
