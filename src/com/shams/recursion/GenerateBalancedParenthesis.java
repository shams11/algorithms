/**
 * https://leetcode.com/problems/generate-parentheses/
 * */
package com.shams.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesis {
  public static void main(String[] args) {
    List<String> result = solve("", 3, 3, new ArrayList<>());
    System.out.println(result);
  }

  private static List<String> solve(String op, int open, int close, List<String> result) {
    if (open == 0 && close == 0) {
      result.add(op);
      return result;
    }
    if (open != 0) {
      // Always you have a choice to use open bracket unless it is 0
      String op1 = op + "(";
      solve(op1, open-1, close, result);
    }
    if (close > open) {
      // close is used only when there is already open bracket
     String op2 = op + ")";
      solve(op2, open, close-1, result);
    }
    return result;
  }
}
