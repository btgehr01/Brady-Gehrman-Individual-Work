/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnumCalc;

import java.math.BigDecimal;

/**
 *
 * @author 19bgehrman
 */
public class calcApp {
    public static void main(String[] args) {
        BigDecimalMath myMath = new BigDecimalMath();
        
        BigDecimal op1 = new BigDecimal("10");
        BigDecimal op2 = new BigDecimal("3");
        
        System.out.println(myMath.calculate(MathOperatorEnum.PLUS, op1, op2));
        System.out.println(myMath.calculate(MathOperatorEnum.MINUS, op1, op2));
        System.out.println(myMath.calculate(MathOperatorEnum.MULTIPLY, op1, op2));
        System.out.println(myMath.calculate(MathOperatorEnum.DIVIDE, op1, op2));
    }
}
