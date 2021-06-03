/**
 * https://www.youtube.com/watch?v=J2Er5XceU_I&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=15&ab_channel=AdityaVerma
 * */
package com.shams.recursion;

public class PermutationWithCaseChange {
  public static void main(String[] args) {
    String ip = "ab";
    solve("", ip);
  }

  private static void solve(String op, String ip) {
    if(ip.length() == 0) {
      System.out.println(op);
      return;
    }

    String op1 = op + ip.charAt(0);
    String op2 = op + String.valueOf(ip.charAt(0)).toUpperCase();
    ip = ip.substring(1);
    solve(op1, ip);
    solve(op2, ip);
  }
}
