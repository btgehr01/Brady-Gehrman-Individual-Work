/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import static Milestone2Labs.NewStudentQuizScores.input;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 19bgehrman
 */
public class QuizScoresWithObject {

    public static void main(String[] args) {

        ArrayList<Integer> quizScores;
        quizScores = new ArrayList<>();
        Map<String, QuizScores> newMap = new HashMap<>();
        int numOfStudents;
        String stNumOfStudents;
        String again;
        String name;
        String operation;
        String studentView;
        String n;
        String averageStudent;
        ArrayList<Integer> listOfGrades;
        listOfGrades = new ArrayList<>();
        String tryAgain;
        Set<String> keys = newMap.keySet();
        Collection<QuizScores> values = newMap.values();
        
        
        
        
        System.out.println("Welcome to my student quiz score program!!(;");
        do {
            System.out.println("What would you like to do? (add = +)(remove = -)");
            System.out.println("(veiw a list of students = list)(view quiz scores for a student = view)");
            System.out.println("(average quiz scores for a student = avg)");
            operation = input.nextLine();
            switch (operation) {
                case "+":
                    System.out.println("How many students are in your class that you"
                            + " would like to put quiz grades in for??");
                    stNumOfStudents = input.nextLine();
                    numOfStudents = Integer.parseInt(stNumOfStudents);
                    for (int i = 0; i < numOfStudents; i++) {
                        name = name();
                        quizScores = variables();
                        QuizScores grades = new QuizScores(name, quizScores);
                        newMap.put(name, grades);
                    }
                     break;
                case "-":
                    System.out.println("What student would you like to remove?");
                    name = input.nextLine();
                    newMap.remove(name);
                    break;
                case "list":
                    for (String tag : keys) {
                        System.out.println(tag);
                    }
                    break;
                case "view":
                    System.out.println("Which student's quiz scores would you like to view?");
                    studentView = input.nextLine();
                    for (String label : keys) {
                        QuizScores grades = newMap.get(label);
                        n = grades.getName();
                        listOfGrades = grades.getQuizscores();
                        if (n.equals(studentView)) {
                            System.out.println("Here are " + studentView + "'s list of grades:");
                            System.out.println(listOfGrades);
                        }
                    }
                    break;
                case "avg":
                    do{
                    System.out.println("Which student would you like to check "
                            + "their average of their grades?");
                    averageStudent = input.nextLine();
                    for (String title : keys) {
                        double total = 0;
                        double numberOfNums = 0;
                        if(title.equals(averageStudent)){
                        QuizScores quizScoresForStudent = newMap.get(title);
                        listOfGrades = quizScoresForStudent.getQuizscores();
                        for (int score : listOfGrades) {
                            total = total + score;
                            numberOfNums++;
                        }
                        double average = total / numberOfNums;
                        System.out.println("The average of quiz scores for " + averageStudent + " is: " + average + " !!");
                        System.out.println("");
                        }
                        if(!(title.equals(averageStudent))){
                            System.out.println("That student is not in the list):");
                        }
                      
                    }
                        System.out.println("If your student and his average grade didn't pop up type in ! to try again");
                        System.out.println("Else just type in $ and press enter to continue!");
                        tryAgain = input.nextLine();
                    
                    }while(tryAgain.equals("!"));
                    
                    break;
            }
            System.out.println("Would you like do anything else(yes or no)??");
            System.out.println("If no, the program will end and your data will be lost):");
            again = input.nextLine();

        } while (again.equals("yes"));
        
        System.out.println("Thank you for using my quiz score program(:");
        
    }
    public static String name() {
        String name;
        System.out.println("What is the name of one of your students");
        name = input.nextLine();
        return name;
    }

    public static ArrayList variables() {
        ArrayList<Integer> quizScores = new ArrayList();
        String stQuizScore;
        int quizScore;
        String stNumOfQuizScores;
        int numOfQuizScores;
        System.out.println("how many quizes has the name above taken that you would like to store??");
        stNumOfQuizScores = input.nextLine();
        numOfQuizScores = Integer.parseInt(stNumOfQuizScores);
        for (int i = 0; i < numOfQuizScores; i++) {
            System.out.println("What are quiz scores that belong to the name "
                    + "you stated above (one at a time)");
            stQuizScore = input.nextLine();
            quizScore = Integer.parseInt(stQuizScore);
            quizScores.add(quizScore);
        }
        return quizScores;
    }
}
