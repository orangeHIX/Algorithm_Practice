package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Given a string of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators. The valid operators are +, - and *.<br/>
 * <br/>
 * <p>
 * Example 1 <br/>
 * Input: "2-1-1". <br/>
 * ((2-1)-1) = 0 <br/>
 * (2-(1-1)) = 2 <br/>
 * <br/>
 * <p>
 * Output: [0, 2] <br/>
 * <br/>
 * <p>
 * Example 2 <br/>
 * Input: "2*3-4*5" <br/>
 * (2*(3-(4*5))) = -34 <br/>
 * ((2*3)-(4*5)) = -14 <br/>
 * ((2*(3-4))*5) = -10 <br/>
 * (2*((3-4)*5)) = -10 <br/>
 * (((2*3)-4)*5) = 10 <br/>
 * <br/>
 * <p>
 * Output: [-34, -14, -10, -10, 10]<br/>
 * <br/>
 * <p>
 * Created by hyx on 2015/10/10.
 */
public class DifferentWaystoAddParentheses {

    private static HashMap<String, ArrayList<Integer>> dpMap = new HashMap<>();

    public static ArrayList<Integer> split(String expression) {

        if (dpMap.containsKey(expression)) {
            return dpMap.get(expression);
        }

        ArrayList<Integer> operatorIndex = findAllOperatorIndex(expression);

        ArrayList<Integer> result = new ArrayList<>();
        if (operatorIndex.isEmpty()) {
            result.add(Integer.parseInt(expression));
        } else {
            for (Integer index : operatorIndex) {
                String leftPart = expression.substring(0, index);
                ArrayList<Integer> resultLeft = split(leftPart);
                dpMap.put(leftPart, resultLeft);

                String rightPart = expression.substring(index + 1);
                ArrayList<Integer> resultRight = split(rightPart);
                dpMap.put(rightPart, resultRight);

                for (Integer left : resultLeft) {
                    for (Integer right : resultRight) {
                        result.add(calculate(left, right, expression.charAt(index)));
                    }
                }
            }

        }
        return result;
    }

    private static char[] operators = {'+', '-', '*'};


    private static int calculate(int left, int right, char operator) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        } else if (operator == '*') {
            return left * right;
        } else {
            throw new IllegalArgumentException("unknown operator");
        }
    }

    private static ArrayList<Integer> findAllOperatorIndex(String expression) {


        char[] ex = expression.toCharArray();
        ArrayList<Integer> operatorIndex = new ArrayList<>();
        for (int i = 0; i < ex.length; i++) {
            for (char o : operators) {
                if (ex[i] == o) {
                    operatorIndex.add(i);
                    break;
                }
            }
        }
        return operatorIndex;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(split("2*3-4*5"));
    }
}
