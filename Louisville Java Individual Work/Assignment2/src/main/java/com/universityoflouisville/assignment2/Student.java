/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment2;

import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class Student {
    //declare instance data 
    private String name;
    private int test1Score;
    private int test2Score;
    
    //initialize Scanner
    Scanner scan = new Scanner(System.in);
    
// --------------------------------------------- 
//constructor that accepts a String arg
// --------------------------------------------- 
	public Student(String studentName) 
	{ 
            this.name = studentName;
	} 

// --------------------------------------------- 
//inputGrades: prompt for and read in student's grades for test1 and test2. 
//Use name in prompts, e.g., "Enter's Joe's score for test1". 
// --------------------------------------------- 
	public void inputGrades() 
	{ 
            System.out.println("Enter " + this.name + "'s score for test1");
            this.test1Score = scan.nextInt();
            System.out.println("Enter " + this.name + "'s score for test2");
            this.test2Score = scan.nextInt();
	} 

// --------------------------------------------- 
//getAverage: compute and return the student's test average 
// --------------------------------------------- 

	public double getAverage()
	{ 
            double average = (this.test1Score + this.test2Score)/ 2.00;
            return average;
            //add body of getAverage 
	} 
// --------------------------------------------- 
//getName: return name to be able to print it with other information later 
// --------------------------------------------- 

	public String getName() 
	{ 
            return this.name;
	} 
        
        public String toString(){
            String student = "Name: " + this.name + "  Test1: " + this.test1Score + "  Test2: " + this.test2Score;
            return student;
        }
}
