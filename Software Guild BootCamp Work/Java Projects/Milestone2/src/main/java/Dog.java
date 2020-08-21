
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class Dog {
    private String name;
    private double weight;
    private int age;
    private Color furColor;
    private Trick[] tricksKnown;
    
    //This is defining the no-args (or no params)
    //constructor for the Dog class.
    //otherwise known as the Charles constructor (har)
    //^^ this is a joke
    public Dog(){
        this.name = "Charles";
        this.weight = 200.0;
        this.age = 42;
        this.furColor = Color.BLACK;
        this.tricksKnown = new Trick[0];
    }
    
    //however no args constructors aren't always
    //as useful to a program. Sometimes you want
    //to let someoe specify the infomation
    //about an object that THEY need to encapsulate
    public Dog(String name, int age, double weight){
        this.name = name; 
        this.age = age;
        this.weight = weight;
        this.furColor = Color.BLACK;
        this.tricksKnown = new Trick[0];
                
    }
    
    // every getter has the following pattern
    // access modifier - public
    // Return Type - matches property data type
    // name -get<PropertyName>
    // parameter list - ()
    public double getWeight(){
        return this.weight;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    // every getter has the following pattern
    // access modifier - public
    // Return Type - void
    // name -get<PropertyName>
    // parameter list - (property)
    public void setName(String name){
        this.name = name;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setAge(int age){
        this.age = age;
    }
    
    //behaviors
    public void bark(){
        System.out.println("BARK BARK BARK!");
    }
    
}
