/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * */
package com.shams.algos;

import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
  public static void main(String[] args) {
    //List<String> ops = List.of("2","1","+","3","*");
    // Output :  9

    List<String> ops = List.of("10","6","9","3","+","-11","*","/","*","17","+","5","+");
    System.out.println(evaluatePostFix(ops));
    // Output: 22
  }

  static double evaluatePostFix(List<String> ops) {
    Stack<Double> stack = new Stack<>();
    for (String curChar : ops) {
      try {
        double curVal = Double.parseDouble(curChar);
        stack.push(curVal);
      } catch (NumberFormatException e) {
        char charVal = curChar.charAt(0);
        if (isOperator(charVal)) {
          double value1 = stack.pop();
          double value2 = stack.pop();
          switch (charVal) {
            case '+':
              stack.push(value1 + value2);
              break;
            case '-':
              stack.push(value2 - value1);
              break;
            case '*':
              stack.push(value2 * value1);
              break;
            case '/':
              stack.push(value2 / value1);
              break;
          }
        } else {
          throw new IllegalArgumentException("Illegal Argument ");
        }
      }
    }
    return stack.pop();
  }

  private static boolean isOperator(char charVal) {
    if (charVal == '+' || charVal == '-' || charVal == '*' || charVal == '/') return true;
    return false;
  }
}
