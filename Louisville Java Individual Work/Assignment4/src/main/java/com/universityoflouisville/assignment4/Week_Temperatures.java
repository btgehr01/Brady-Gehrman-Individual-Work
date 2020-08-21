/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityoflouisville.assignment4;

import java.util.ArrayList;

/**
 *
 * @author Brady Gehrman
 */
public class Week_Temperatures implements Severity{
    
    private ArrayList<Integer> dailyTemps;
    private int serverityTemp;
    private int serverityLevel;
    
    public Week_Temperatures(ArrayList<Integer> list){
        this.serverityLevel = 0;
        this.dailyTemps = list;
    }

    public ArrayList<Integer> getDailyTemps() {
        return dailyTemps;
    }

    public void setDailyTemps(ArrayList<Integer> dailyTemps) {
        this.dailyTemps = dailyTemps;
    }
    
    public int getSeverityLevel(){
        for(int temp : dailyTemps){
            if(temp > serverityTemp){
                serverityLevel++;
            }
        }
        return serverityLevel;
    }
    
    public int numberOfDayBelowFreezing(){
        int count = 0;
        for(int temp : dailyTemps){
            if(temp < 32){
                count++;
            }
        }
        return count;
    }
    
    public ArrayList<Integer> getlistOfTempsAboveSevTemp(){
        ArrayList<Integer> listOfTempsAboveSevTemp = new ArrayList<>();
        for(int temp : dailyTemps){
            if(temp > serverityTemp){
                listOfTempsAboveSevTemp.add(temp);
            }
        }
        return listOfTempsAboveSevTemp;
    }
    
    @Override
    public void setSeverity(int sevTemp) {
        this.serverityTemp = sevTemp;
    }

    @Override
    public int getSeverity() {
        return this.serverityTemp;
    }
    
    public String toString(){
        String output = "";
        for(int temp : dailyTemps){
            output += temp + " ";
        }
        return output;
    }
    
}
