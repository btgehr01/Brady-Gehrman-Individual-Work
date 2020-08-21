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
import java.util.Set;

/**
 *
 * @author 19bgehrman
 */
public class StudentQuizGrades {

    public static void main(String[] args) {
        ArrayList<Integer> quizScoresBob;
        quizScoresBob = new ArrayList<>();
        Map<String, ArrayList> newMap = new HashMap<>();
        quizScoresBob.add(68);
        quizScoresBob.add(95);
        quizScoresBob.add(85);
        quizScoresBob.add(79);
        quizScoresBob.add(89);
        newMap.put("Bob", quizScoresBob);
        ArrayList<Integer> quizScoresJeff;
        quizScoresJeff = new ArrayList<>();
        quizScoresJeff.add(78);
        quizScoresJeff.add(85);
        quizScoresJeff.add(95);
        quizScoresJeff.add(65);
        quizScoresJeff.add(100);
        newMap.put("Jeff", quizScoresJeff);
        ArrayList<Integer> quizScoresJohn;
        quizScoresJohn = new ArrayList<>();
        quizScoresJohn.add(85);
        quizScoresJohn.add(100);
        quizScoresJohn.add(75);
        quizScoresJohn.add(93);
        quizScoresJohn.add(88);
        newMap.put("John", quizScoresJohn);
        ArrayList<Integer> quizScoresBrady;
        quizScoresBrady = new ArrayList<>();
        quizScoresBrady.add(85);
        quizScoresBrady.add(100);
        quizScoresBrady.add(88);
        quizScoresBrady.add(93);
        quizScoresBrady.add(88);
        newMap.put("Brady", quizScoresBrady);

        Set<String> keys = newMap.keySet();
        Collection<ArrayList> values = newMap.values();

        for (String name : keys) {
            double total = 0;
            double numberOfNums = 0;
            System.out.println(name);
            ArrayList<Integer> nameList = newMap.get(name);
            System.out.println(nameList);
            for (int score : nameList) {
                System.out.println(score);
                total = total + score;
                numberOfNums++;
            }
            double average = total / numberOfNums;
            System.out.println("The average quiz score for " + name + " is: " + average + " !!");
        }
        }

    }

