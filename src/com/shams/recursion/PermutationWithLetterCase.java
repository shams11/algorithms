/**
 * https://www.youtube.com/watch?v=4eOPYDOiwFo&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=16&ab_channel=AdityaVerma
 * https://leetcode.com/problems/letter-case-permutation/
 */

package com.shams.recursion;

import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;

public class PermutationWithLetterCase {
  public static void main(String[] args) {
    String ip = "a1b2";
    //  solve("", ip);
    List<String> res = letterCasePermutation(ip);
    System.out.println(res);
  }

  static List<String> result = new ArrayList<>();

  private static void solve(String op, String ip) {
    if (ip.length() == 0) {
      System.out.println(op);
      return;
    }
    String op1 = op;
    String op2 = op;

    if (isDigit(ip.charAt(0))) {
      op1 = op1 + ip.charAt(0);
      ip = ip.substring(1);
      solve(op1, ip);
    } else {
      op1 = op1 + String.valueOf(ip.charAt(0)).toLowerCase();
      op2 = op2 + String.valueOf(ip.charAt(0)).toUpperCase();
      ip = ip.substring(1);
      solve(op1, ip);
      solve(op2, ip);
    }
  }

  // leetcode
  public static List<String> letterCasePermutation(String S) {
    return letterCase("", S);
  }

  private static List<String> letterCase(String op, String ip) {
    if (ip.length() == 0) {
      result.add(op);
      System.out.println(op);
      return result;
    }
    String op1 = op;
    String op2 = op;

    if (Character.isDigit(ip.charAt(0))) {
      op1 = op1 + ip.charAt(0);
      ip = ip.substring(1);
      letterCase(op1, ip);
    } else {
      op1 = op1 + String.valueOf(ip.charAt(0)).toLowerCase();
      op2 = op2 + String.valueOf(ip.charAt(0)).toUpperCase();
      ip = ip.substring(1);
      letterCase(op1, ip);
      letterCase(op2, ip);
    }
    return result;
  }
}
