/**
 * https://www.youtube.com/watch?v=1cspuQ6qHW0&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=14&ab_channel=AdityaVerma
 * */
package com.shams.recursion;

public class PermutationsWithSpaces {
  public static void main(String[] args) {
    String ip = "ABC";
    solve("", ip);
  }

  private static void solve(String op, String ip) {
    if (ip.length() == 0) {
      System.out.println("[" + op + "]");
      return;
    }
    if (op.equals("")) {
      op = op + ip.charAt(0);
      ip = ip.substring(1);
    }
    String op1 = op + "_" + ip.charAt(0);
    String op2 = op;
    op2 = op + ip.charAt(0);
    ip = ip.substring(1);
    solve(op1, ip);
    solve(op2, ip);
  }
}
