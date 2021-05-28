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

      [{}]


      "}}}"
*/

  public static void main(String[] str) {
    String input = "([])";
    System.out.println(areBracketsValid(input));
  }

  static boolean areBracketsValid(String str) {
    if (str == null || str.equals("")) {
      System.out.println("Invalid Input");
      return false;
    }
    Stack<Character> s = new Stack<>();
    Character x;
    Character sTop;
    char c;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (s.isEmpty()) {
        s.push(c);
      } else if (c == '{' || c == '[' || c == '(') {
        sTop = s.peek();
        if (sTop == '(') {
          if (c == '{' || c == '[')
            return false;
        }

        if (sTop == '[') {
          if (c == '{')
            return false;
        }
        s.push(c);
      } else {
        switch (c) {
          case ')':
            x = s.pop();
            if (x == '}' || x == ']') {
              return false;
            }
            break;
          case ']':
            x = s.pop();
            if (x == ')' || x == '}') {
              return false;
            }
            break;
          case '}':
            x = s.pop();
            if (x == ')' || x == ']') {
              return false;
            }
            break;
          default:
            return false;
        }
      }
    }
    return s.isEmpty();
  }
}
