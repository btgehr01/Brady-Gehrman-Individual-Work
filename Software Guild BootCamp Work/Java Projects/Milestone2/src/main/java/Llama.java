/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19bgehrman
 */
public class Llama {
    private int numLegs;
    private String woolType;
    private String woolColor;
    private int yearsOld;

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public String getWoolType() {
        return woolType;
    }

    public void setWoolType(String woolType) {
        this.woolType = woolType;
    }

    public String getWoolColor() {
        return woolColor;
    }

    public void setWoolColor(String woolColor) {
        this.woolColor = woolColor;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
    
    public Llama(){
        this.numLegs = 4;
        this.woolColor = "black";
        this.woolType = "fluffy";
        this.yearsOld = 3;
    }
    public Llama(int legs, String wool, String color, int age){
        this.numLegs = legs;
        this.woolColor = wool;
        this.woolType = color;
        this.yearsOld = age;
    }
}
