/***
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 *
 */

package com.shams.algos;

import java.util.Stack;

public class InfixToPostfix {
  public static void main(String[] args) {
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(evaluateExpression(exp));
  }

  private static String evaluateExpression(String exp) {
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (int curIndex = 0; curIndex < exp.length(); ++curIndex) {
      char curChar = exp.charAt(curIndex);
      if (Character.isLetterOrDigit(curChar)) {
        result.append(curChar);
      } else if (curChar == '(') {
        stack.push(curChar);
      } else if (curChar == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result.append(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(curChar) <= precedence(stack.peek())) {
          result.append(stack.pop());
        }
        stack.push(curChar);
      }
    }
    while(!stack.isEmpty()) {
      if(stack.peek() == '(') {
        return "Invalid expression";
      }
      result.append(stack.pop());
    }
    return result.toString();
  }

  static int precedence(char curChar) {
    switch (curChar) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }
}
