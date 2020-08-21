/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizorjspservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "FactorizorServlet", urlPatterns = {"/FactorizorServlet"})
public class FactorizorServlet extends HttpServlet {

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
        
        // Get the value that was submitted in the index.jsp form
        List<Integer> factorList = new ArrayList<>();
        int factorSum = 0;
        boolean isPrime = false;
        boolean isPerfect = false;
        
    String input = request.getParameter("numberToFactor");
    
    int numberToFactor = Integer.parseInt(input);
    
    for(int i = 1; i < numberToFactor; i++){
        if(numberToFactor % i == 0){
            factorList.add(i);
            factorSum += i;
        }
    }
    if(factorSum == numberToFactor){
        isPerfect = true;
    }
    if(factorSum == 1){
        isPrime = true;
    }
    //give result.jsp the factor list
    request.setAttribute("factors", factorList);
    // Set numberToFactor as an attribute on the request so that
    // it is available to result.jsp
    request.setAttribute("numberToFactorJSP", numberToFactor);
    //give result.jsp isPrime
    request.setAttribute("isPrime", isPrime);
    //give result.jsp isPrime
    request.setAttribute("isPerfect", isPerfect);

    // Get the Request Dispatcher for result.jsp and forward the 
    // request to result.jsp
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
