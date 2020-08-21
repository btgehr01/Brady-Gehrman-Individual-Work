/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Llama.dto;

/**
 *
 * @author 19bgehrman
 */
public class Llama {

    private String name;
    private String color;
    private String woolType;
    private String favHangoutSpot;

    private int id;
    private int age;
    private int weight;
    private int spitRange;
    private int overBP;
    private int underBP;

    private boolean likesToKickJames;

    private long numHairs;

    private double GPA;
    private double omegaSpit;
    private double tongueLength;

    public Llama() {
    }

    public Llama(int id) {
        this.id = id;
    }

    public Llama(String name, String color, String woolType, String favHangoutSpot, 
            int id, int age, int weight, int spitRange, int overBP, int underBP, 
            boolean likesToKickJames, long numHairs, double GPA, double omegaSpit, 
            double tongueLength) {
        this.name = name;
        this.color = color;
        this.woolType = woolType;
        this.favHangoutSpot = favHangoutSpot;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.spitRange = spitRange;
        this.overBP = overBP;
        this.underBP = underBP;
        this.likesToKickJames = likesToKickJames;
        this.numHairs = numHairs;
        this.GPA = GPA;
        this.omegaSpit = omegaSpit;
        this.tongueLength = tongueLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getTongueLength() {
        return tongueLength;
    }

    public void setTongueLength(double tongueLength) {
        this.tongueLength = tongueLength;
    }

    public int getSpitRange() {
        return spitRange;
    }

    public void setSpitRange(int spitRange) {
        this.spitRange = spitRange;
    }

    public boolean isLikesToKickJames() {
        return likesToKickJames;
    }

    public void setLikesToKickJames(boolean likesToKickJames) {
        this.likesToKickJames = likesToKickJames;
    }

    public String getWoolType() {
        return woolType;
    }

    public void setWoolType(String woolType) {
        this.woolType = woolType;
    }

    public long getNumHairs() {
        return numHairs;
    }

    public void setNumHairs(long numHairs) {
        this.numHairs = numHairs;
    }

    public String getFavHangoutSpot() {
        return favHangoutSpot;
    }

    public void setFavHangoutSpot(String favHangoutSpot) {
        this.favHangoutSpot = favHangoutSpot;
    }

    public int getOverBP() {
        return overBP;
    }

    public void setOverBP(int overBP) {
        this.overBP = overBP;
    }

    public int getUnderBP() {
        return underBP;
    }

    public void setUnderBP(int underBP) {
        this.underBP = underBP;
    }

    public double getGpa() {
        return GPA;
    }

    public void setGpa(double GPA) {
        this.GPA = GPA;
    }

    public double getOmegaSpit() {
        return omegaSpit;
    }

    public void setOmegaSpit(double omegaSpit) {
        this.omegaSpit = omegaSpit;
    }

}
