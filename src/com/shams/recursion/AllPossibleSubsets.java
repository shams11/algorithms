/**
 *
 * https://www.youtube.com/watch?v=Yg5a2FxU4Fo&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=12&ab_channel=AdityaVerma
 * */
package com.shams.recursion;

public class AllPossibleSubsets {
  public static void main(String[] args) {
    String str = "123";
    printAllSubsets("", str);
  }

  private static void printAllSubsets(String op, String ip) {

    if (ip.length() == 0) {
      System.out.println("[" + op + "]");
      return;
    }
    String op1 = op;
    String op2 = op;
    op2 =  op2 + ip.charAt(0);
    ip = ip.substring(1);
    printAllSubsets(op1, ip);
    printAllSubsets(op2, ip);
  }
}
