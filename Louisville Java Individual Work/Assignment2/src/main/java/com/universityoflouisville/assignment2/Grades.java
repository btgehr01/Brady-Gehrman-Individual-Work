/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Brady Gehrman
 */
public class Grades {
    public static void main(String[] args) 
	{ 
                //initialize scanner
                Scanner scan = new Scanner(System.in);
                
		Student student1;
                Student student2; 
		String studentName1, studentName2;
                
		System.out.println("Enter the name of your first student");
                studentName1 = scan.nextLine();
		//Read name of studentName1
		
		//Prompt the user to enter the name of student2 
                System.out.println("Enter the name of your second student");
                studentName2 = scan.nextLine();
		//Read name of studentName2
		
		//create Student objects for student1 and student2
		student1 = new Student(studentName1);
                student2 = new Student(studentName2);
                
		//input grades for student1 
                student1.inputGrades();
		//print the values of student1
		System.out.println("Student 1: " + student1);
		
                DecimalFormat format = new DecimalFormat(".##"); 
		//print average for student1 
                double student1Average = student1.getAverage();
		System.out.println("Average grade for " + student1.getName() + " is: " + format.format(student1Average) + "%");
		
		//input grades for student2 
                student2.inputGrades();
		//print the values of student2
                System.out.println("Student 2: " + student2);
		//print average for student2 
                double student2Average = student2.getAverage();
                System.out.println("Average grade for " + student2.getName() + " is: " + format.format(student2Average) + "%");
	} 
}
