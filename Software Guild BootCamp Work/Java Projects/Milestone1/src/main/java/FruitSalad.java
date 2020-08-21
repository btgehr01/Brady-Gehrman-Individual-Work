/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class FruitSalad {

    public static void main(String[] args) {
        int total = 1;
        int apples = 0;
        int oranges = 0;
        int berry = 0;
        int fruits = 0;
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato",
            "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry",
            "Navel Orange", "Pink Pearl Apple", "Raspberry", "Blood Orange", "Sungold Tomato",
            "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple",
            "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[24];

        for (int i = 0; i < fruit.length; i++) {

            if (fruit[i].contains("Apple") && apples < 3 && total <= 12) {
                fruitSalad[i] = fruit[i];
                apples++;
                total++;
                System.out.println(fruit[i]);
            }
            if (fruit[i].contains("Fruit") && total <= 12) {
                fruitSalad[i] = fruit[i];
                fruits++;
                total++;
                System.out.println(fruit[i]);
            }
            if (fruit[i].contains("berry") && total <= 12) {
                fruitSalad[i] = fruit[i];
                berry++;
                total++;
                System.out.println(fruit[i]);
            }
            if (fruit[i].contains("Orange") && oranges < 2 && total <= 12) {
                fruitSalad[i] = fruit[i];
                oranges++;
                total++;
                System.out.println(fruit[i]);
            }
            else{
               
            }
        }
        System.out.println("The total number of fruits in my fruit salad is " + (total - 1));

    }
}
