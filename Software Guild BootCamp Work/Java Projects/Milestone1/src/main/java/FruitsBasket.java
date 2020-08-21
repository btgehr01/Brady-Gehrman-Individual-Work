/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class FruitsBasket {
    public static void main(String[] args) {
        int apples = 0;
        int oranges = 0;
        String [] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", 
            "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", 
            "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", 
            "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        for (int i = 0; i < fruit.length; i++) {
            if(fruit[i]. equals("Apple")){
                apples++;  
            }
            else{
                oranges++;
            }   
        }
        System.out.println("there are " + apples + " apples in the array");
        System.out.println("there are " + oranges + " oranges in the array");
        System.out.println("That means there is " + (apples + oranges) + 
                " in the array!!");
        
    }
  
}
