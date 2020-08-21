/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalcspringmvcwebapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 19bgehrman
 */
@Controller
public class FlooringController {
    @RequestMapping(value="getFlooringEstimate", method = RequestMethod.POST)
    public String getFlooringEstimate(HttpServletRequest request, Map <String, Object> model){
        String width = request.getParameter("widthOfFloor");
        String length = request.getParameter("lengthOfFloor");
        String cost = request.getParameter("costPerSqFoot");
        
        //set variables to BigDecimals
        BigDecimal widthOfFloor = new BigDecimal(width);
        BigDecimal lengthOfFloor = new BigDecimal(length);
        BigDecimal costPerSqFoot = new BigDecimal(cost);
        
        //set a bigdecimal to costForLaborPerFifteen
        BigDecimal costForLaborPerFifteen = new BigDecimal("21.5");
        
        //find total area
        BigDecimal area = widthOfFloor.multiply(lengthOfFloor).setScale(2, RoundingMode.HALF_UP);
        //find amount of time in hour it will take
        BigDecimal hours = area.divide(new BigDecimal("20.00").setScale(2, RoundingMode.HALF_UP));
        //find amount of fifteen inute increments, round up
        BigDecimal numberOfFifteenMinuteIncrements = hours.multiply(new BigDecimal("4.00"));
        numberOfFifteenMinuteIncrements = numberOfFifteenMinuteIncrements.setScale(0, RoundingMode.UP);
        //calculate labor cost
        BigDecimal laborCost = numberOfFifteenMinuteIncrements.multiply(costForLaborPerFifteen).setScale(2, RoundingMode.HALF_UP);
        
        
        //calculate material cost
        BigDecimal materialCost = costPerSqFoot.multiply(area).setScale(2, RoundingMode.HALF_UP);
        
        
        //calculate total cost
        BigDecimal totalCost = laborCost.add(materialCost);
        
        model.put("totalTime", hours);
        model.put("totalCost", totalCost);
        
        return "result";
    }
}
