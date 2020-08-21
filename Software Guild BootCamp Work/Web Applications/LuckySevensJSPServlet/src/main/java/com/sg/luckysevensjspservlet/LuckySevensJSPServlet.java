/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;
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
@WebServlet(name = "LuckySevensJSPServlet", urlPatterns = {"/LuckySevensJSPServlet"})
public class LuckySevensJSPServlet extends HttpServlet {

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

        //get money out of index.jsp
        String money = request.getParameter("money");
        BigDecimal cash = new BigDecimal(money);
        
        request.setAttribute("startingAmount", cash);
        
        BigDecimal maxCash = new BigDecimal(money);
        
        Random diceRoller = new Random();
        
        int rolls = 0;
        int maxRollNumber = 0;
        
       while (cash.compareTo(BigDecimal.ZERO) == 1) {
            //roll some die & add together
            int rollOne = diceRoller.nextInt(6) + 1;
            int rollTwo = diceRoller.nextInt(6) + 1;
            int diceTotal = rollOne + rollTwo;
            rolls++;

            //update money
            if (diceTotal == 7) {
                
                cash = cash.add(new BigDecimal("4.00"));

                //check if we have more than out max
                if (cash.compareTo(maxCash) >= 0) {
                    maxCash = cash;
                    maxRollNumber = rolls;
                }
            } else {
                cash.subtract(new BigDecimal("1.00"));
            }     
        }
        
        request.setAttribute("endRoll", rolls);
        request.setAttribute("maxRollNumber", maxRollNumber);
        request.setAttribute("maxCash", maxCash);
        
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
