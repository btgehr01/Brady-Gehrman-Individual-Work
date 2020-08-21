/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Labs;

/**
 *
 * @author 19bgehrman
 */
public class AirplaneVirtual {
    private String direction;
    private double altitude;
    private double velocity;
    private String origin;
    private String destination;
    private String eTA;
    private double angleOfDecent;
    private double pressure;
    private double wingLength;
    private String planeColor;
    private String planeType;
    private double weight;
    private double fuel;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String geteTA() {
        return eTA;
    }

    public void seteTA(String eTA) {
        this.eTA = eTA;
    }

    public double getAngleOfDecent() {
        return angleOfDecent;
    }

    public void setAngleOfDecent(double angleOfDecent) {
        this.angleOfDecent = angleOfDecent;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWingLength() {
        return wingLength;
    }

    public void setWingLength(double wingLength) {
        this.wingLength = wingLength;
    }

    public String getPlaneColor() {
        return planeColor;
    }

    public void setPlaneColor(String planeColor) {
        this.planeColor = planeColor;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
    
    public AirplaneVirtual(){
        this.direction = "east";
        this.angleOfDecent = 0.0;
        this.destination = "St. Louis";
        this.eTA = "6:30";
        this.origin = "Louisville";
        this.velocity = 885.0;
        this.altitude = 7.8;     
        this.planeColor = "yellow";
        this.fuel = 300.5;
        this.wingLength = 130.0;
        this.weight = 487.5;
        this.planeType = "Cessna";
        this.pressure = 11;
    }
    
    
}
