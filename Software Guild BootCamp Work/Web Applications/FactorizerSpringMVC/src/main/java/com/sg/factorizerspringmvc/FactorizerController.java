/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerspringmvc;

import java.util.ArrayList;
import java.util.List;
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
public class FactorizerController {
    @RequestMapping(value="factorNumber", method= RequestMethod.POST)
    public String factorNumber(HttpServletRequest request, Map <String, Object> model){
        
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
    model.put("numberToFactor", numberToFactor);
    // Set numberToFactor as an attribute on the request so that
    // it is available to result.jsp
    model.put("factors", factorList);
    //give result.jsp isPrime
    model.put("isPrime", isPrime);
    //give result.jsp isPerfect
    model.put("isPerfect", isPerfect);

        return "result";
        
    }
    
}
