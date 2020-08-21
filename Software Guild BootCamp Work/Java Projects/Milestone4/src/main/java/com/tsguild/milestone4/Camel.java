/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.milestone4;

/**
 *
 * @author 19bgehrman
 */
public class Camel {

    private String name;
    private int numberOfHumps;
    private int amountOfSpit;
    private boolean isMad = false;

    public Camel() {
    }

    public Camel(String name, int numberOfHumps, int amountOfSpit) {
        this.name = name;
        this.numberOfHumps = numberOfHumps;
        this.amountOfSpit = amountOfSpit;
    }
    public void poke(){
       this.isMad = true;
        System.out.println("AAARRTTGGGYYHGFFGGGHHHHFFFF");
    }

    public String spit() {
        if(this.isMad){
           this.amountOfSpit -= 5; //amountOfSpit = amountOfSpit - 5
           this.isMad = false;
           return "PTOOOOOEY PTOOOOOEY PTOOOOOEY PTOOOOOEY PTOOOOOEY";
        }
        if (this.amountOfSpit > 0) {
            this.amountOfSpit--;
            return "PTOOOOOEY";
        } else {
            return "ttttthhpthhh";
        }
    }

    public String whatKindaCamel() {
        switch (this.numberOfHumps) {
            case 2:
                return "Bactrian";
            case 1:
                return "Dromedary";
            default:
                return "Dunn. Might not be a camel.";
        }
    }

    public Camel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHumps() {
        return numberOfHumps;
    }

    public void setNumberOfHumps(int numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
    }

    public int getAmountOfSpit() {
        return amountOfSpit;
    }

    public void setAmountOfSpit(int amountOfSpit) {
        this.amountOfSpit = amountOfSpit;
    }

}
