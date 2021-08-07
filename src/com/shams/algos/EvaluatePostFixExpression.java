/**
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 */

package com.shams.algos;

import java.util.Stack;

public class EvaluatePostFixExpression {
  public static void main(String[] args) {
    //String exp = "100 200 + 2 / 5 * 7 +";
    String exp = "231*+9-";
    System.out.println(evaluatePostFixExp(exp));
  }

  private static int evaluatePostFixExp(String exp) {
    Stack<Integer> stack = new Stack<>();
    for (int curIndex = 0; curIndex < exp.length(); ++curIndex) {
      char curChar = exp.charAt(curIndex);
      if (curChar == ' ') continue;
      else if (Character.isDigit(curChar)) {
        int number = 0;
        while (Character.isDigit(curChar)) {
          number = number * 10 + (curChar - '0');
          curIndex++;
          curChar = exp.charAt(curIndex);
        }
        curIndex--;
        stack.push(number);
        //stack.push(curChar - '0'); for single digits in exp
      } else {
        int value1 = stack.pop();
        int value2 = stack.pop();
        switch (curChar) {
          case '+':
            stack.push(value1 + value2);
            break;
          case '-':
            stack.push(value2 - value1);
            break;
          case '/':
            stack.push(value2 / value1);
            break;
          case '*':
            stack.push(value1 * value2);
            break;
        }
      }
    }
    return stack.pop();
  }
}
