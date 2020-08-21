/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SummativeWork;

/**
 *
 * @author 19bgehrman
 */
public class SummativeSums {

    public static void main(String[] args) {
        int sumArrayOne;
        int sumArrayTwo;
        int sumArrayThree;
        int[] array1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] array2 = {999, -60, -77, 14, 160, 301};
        int[] array3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};
        sumArrayOne = summinator(array1);
        sumArrayTwo = summinator(array2);
        sumArrayThree = summinator(array3);

        System.out.println("The sum of array1 is:" + sumArrayOne);
        System.out.println("The sum of array2 is:" + sumArrayTwo);
        System.out.println("The sum of Array3 is:" + sumArrayThree);

    }

    public static int summinator(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}
