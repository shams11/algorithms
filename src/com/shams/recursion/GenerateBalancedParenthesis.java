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
      String op1 = op;
      op1 = op1 + "(";
      solve(op1, open-1, close, result);
    }
    if (close > open) {
      String op2 = op;
      op2 = op2 + ")";
      solve(op2, open, close-1, result);
    }
    return result;
  }
}
