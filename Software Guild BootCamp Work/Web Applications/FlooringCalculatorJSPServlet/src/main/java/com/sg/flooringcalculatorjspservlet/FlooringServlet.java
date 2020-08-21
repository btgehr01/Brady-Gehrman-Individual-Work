/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 19bgehrman
 */
@WebServlet(name = "FlooringServlet", urlPatterns = {"/FlooringServlet"})
public class FlooringServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get varibles out of index.jsp
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
        
        
        //return total time
        request.setAttribute("totalTime", hours);
        //return total cost
        request.setAttribute("totalCost", totalCost);
        
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
