/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class SimpleSortWithExplanation {

    public static void main(String[] args) {

        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        int[] wholeNumbers = new int[24];
        System.out.println("Here ya go - all nice and ordered:");
        for (int i = 0; i < secondHalf.length; i++) {
            if (firstHalf[i] > secondHalf[i]) {
            wholeNumbers[i] = secondHalf[i];
            wholeNumbers[i + 1] = firstHalf[i];   
            }
            else{
            wholeNumbers[i] = firstHalf[i];
            wholeNumbers[i + 1] = secondHalf[i];    
            }
            System.out.print(wholeNumbers[i] + " ");
            System.out.print(wholeNumbers[i + 1] + " ");
        }
    }
}
//how it works::
/* So I first noticed that the small arrays given are listed in increasing 
order and after each array number is progressed for each smaller array
the numbers for each of the diffrent arrays are greater 
than the numbers in the array number before them. Therefore, I decided I would 
have to compared each firsthalf array number to its equal secondHalf arrat number.
I also knew I would have to put this all int a for loop until one of the smaller arrays 
sequenced fully through. In the for loop it must first decide if the number in the first slot
of secondHalf or firsthalf is greater (if statements). Then it must put the greatest number into
the other array called wholeNumbers (same array number). Then it must put the lower number into 
WholeNumbers aswell (the next slot of wholeNubers (small array number + 1)). Then it must print 
those numbers out to the screen in increasing order! It will end up repeating this 12 times!


*/

