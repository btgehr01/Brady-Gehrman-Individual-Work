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
public class AirplaneTraffic {

    private String direction;
    private double altitude;
    private double velocity;
    private String origin;
    private String destination;
    private String eTA;
    private double angleOfDecent;

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
    
    public AirplaneTraffic(){
        this.direction = "east";
        this.angleOfDecent = 30.0;
        this.destination = "St. Louis";
        this.eTA = "6:30";
        this.origin = "Louisville";
        this.velocity = 885.0;
        this.altitude = 7.8;       
    }

}
