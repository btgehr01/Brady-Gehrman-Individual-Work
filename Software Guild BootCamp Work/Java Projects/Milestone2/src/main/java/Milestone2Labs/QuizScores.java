/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

import java.util.ArrayList;

/**
 *
 * @author 19bgehrman
 */
public class QuizScores {
private String studentName;
private ArrayList quizscores;


    public String getName() {
        return studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public ArrayList getQuizscores() {
        return quizscores;
    }

    public void setQuizscores(ArrayList quizscores) {
        this.quizscores = quizscores;
    }

    
    public QuizScores(String name, ArrayList quizScores){
        this.studentName = name;
        this.quizscores = quizScores;
    }

}


