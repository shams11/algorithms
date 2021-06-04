package com.shams.paranthesis;

import java.util.Stack;

public class CheckBalancedBracketsAndOrder {

  // Sales force screening (1st) round - 28-May-2021 : 3 - 4 PM
  /*
      {}, [], ()

      "(){}{}[]" ->Valid
      "[{}]" - Not valid
      "([])" - Not Valid
      "{[()]}" Valid
      "[()]" Valid
      "(()" Not Valid
      "[{}]"  valid
      "}}}" Not valid
*/

  public static void main(String[] str) {
    String input = "{{[[]]}}";
    System.out.println(areBracketsValid(input));
  }

  static boolean areBracketsValid(String str) {

    if (!isInputValid(str)) {
      return false;
    }
    Stack<Character> s = new Stack<>();

    Character sTop;
    char c;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (s.isEmpty()) {
        s.push(c);
      } else if (c == '{' || c == '[' || c == '(') {
        if (!evaluateBracketOrder(c, s)) return false;
      } else {
        if (!evaluateExpression(c, s)) {
          return false;
        }
      }
    }
    return s.isEmpty();
  }

  private static boolean evaluateBracketOrder(char c, Stack<Character> s) {
    char sTop = s.peek();
    if (sTop == '(') {
      if (c == '{' || c == '[')
        return false;
    }
    if (sTop == '[') {
      if (c == '{')
        return false;
    }
    s.push(c);
    return true;
  }

  private static boolean evaluateExpression(char c, Stack<Character> s) {
    if (s.isEmpty()) return false;
    Character x = s.pop();
    switch (c) {
      case ')':
        if (x == '{' || x == '[') {
          return false;
        }
        break;
      case ']':
        if (x == '(' || x == '{') {
          return false;
        }
        break;
      case '}':
        if (x == '(' || x == '[') {
          return false;
        }
        break;
      default:
        return false;
    }
    return true;
  }

  private static boolean isInputValid(String str) {
    if (str == null || str.equals("")) {
      System.out.println("Invalid Input");
      return false;
    }
    if (str.length() % 2 != 0) {
      return false;
    }
    char c = str.charAt(0);
    if (c == '}' || c == ')' || c == ']') {
      return false;
    }
    return true;
  }
}
