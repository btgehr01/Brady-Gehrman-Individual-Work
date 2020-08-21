/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 19bgehrman
 */
public class NewStudentQuizScores {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> quizScores;
        quizScores = new ArrayList<>();
        Map<String, ArrayList> newMap = new HashMap<>();
        int numOfStudents;
        String again = "yes";
        String name;
        String removeStudentName;
        do {
            System.out.println("What task can I help you with??");
            String operation = input.next();
            if (operation.contains("add")) {
                System.out.println("How many students are in your class that you"
                        + " would like to put quiz grades in for??");
                numOfStudents = input.nextInt();
                for (int i = 0; i < numOfStudents; i++) {
                    name = name();
                    quizScores = variables();
                    newMap.put(name, quizScores);
                }

                Set<String> keys = newMap.keySet();
                Collection<ArrayList> values = newMap.values();

                for (String title : keys) {
                    double total = 0;
                    double numberOfNums = 0;
                    System.out.println(title);
                    ArrayList<Integer> quizScoresForStudent = newMap.get(title);
                    System.out.println(quizScoresForStudent);
                    for (int score : quizScoresForStudent) {
                        System.out.println(score);
                        total = total + score;
                        numberOfNums++;
                    }
                    double average = total / numberOfNums;
                    System.out.println("The average quiz score for " + title + " is: " + average + " !!");
                    System.out.println("");
                }
                System.out.println("Would you like to add another student that you forgot??");
                again = input.next();
            }
            else if(operation.contains("remove")){
                System.out.println("What student would you like to remove??");
                removeStudentName = input.next();
                newMap.remove(removeStudentName);
            }
        } while (again.equals("yes"));
    }

    public static String name() {
        String name;
        System.out.println("What is the name of one of your students");
        name = input.next();
        return name;
    }

    public static ArrayList variables() {
        ArrayList<Integer> quizScores = new ArrayList();
        int quizScore;
        int numOfQuizScores;
        System.out.println("how many quizes has the name above taken that you would like to store??");
        numOfQuizScores = input.nextInt();
        for (int i = 0; i < numOfQuizScores; i++) {
            System.out.println("What are quiz scores that belong to the name "
                    + "you stated above (one at a time)");
            quizScore = input.nextInt();
            quizScores.add(quizScore);
        }
        return quizScores;
    }
}
