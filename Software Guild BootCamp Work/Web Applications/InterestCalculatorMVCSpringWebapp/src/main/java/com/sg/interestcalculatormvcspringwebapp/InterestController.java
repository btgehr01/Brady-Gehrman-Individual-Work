/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatormvcspringwebapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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
public class InterestController {

    @RequestMapping(value = "calculateInvestment", method = RequestMethod.POST)
    public String calculateInvestment(HttpServletRequest request, Map<String, Object> model) {

        String annualInterest = request.getParameter("annualInterest");
        BigDecimal bDAnnualInterest = new BigDecimal(annualInterest);
        BigDecimal bDquarterlyInterestRate = bDAnnualInterest.divide(new BigDecimal("4.00")).setScale(3, RoundingMode.HALF_UP);
        BigDecimal quarterlyInterestRate = bDquarterlyInterestRate.divide(new BigDecimal("100.00")).setScale(3, RoundingMode.HALF_UP);
        BigDecimal interestMultiplier = quarterlyInterestRate.add(new BigDecimal("1.00"));

        String amountInvested = request.getParameter("amountInvested");
        BigDecimal amountInitiallyInvested = new BigDecimal(amountInvested);

        String yearsToBeCompounded = request.getParameter("yearsToBeCompounded");
        int years = Integer.parseInt(yearsToBeCompounded);

        //get year number
        LocalDate now = LocalDate.now();
        int startYear = now.getYear();

        int endYear = startYear + years;

        List<InterestYear> listOfYears = new ArrayList<>();

        for (int i = startYear; i < endYear; i++) {

            InterestYear oneYear = new InterestYear(i);

            oneYear.setBeginningBalance(amountInitiallyInvested);

            BigDecimal moneyGained = amountInitiallyInvested.multiply(quarterlyInterestRate).setScale(2, RoundingMode.HALF_UP);
            
            BigDecimal moneyGainedInYear = moneyGained.multiply(new BigDecimal("4").setScale(2, RoundingMode.HALF_UP));

            oneYear.setAmountEarned(moneyGainedInYear);

            BigDecimal endingBalance = amountInitiallyInvested.add(moneyGainedInYear);

            oneYear.setEndingBalance(endingBalance);

            amountInitiallyInvested = endingBalance;

            listOfYears.add(oneYear);
        }

        model.put("listOfYears", listOfYears);

        return "result";
    }

}
