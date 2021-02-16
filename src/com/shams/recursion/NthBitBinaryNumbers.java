/***
 *
 * https://www.youtube.com/watch?v=U81n0UYtk98&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=18&ab_channel=AdityaVerma
 * */
package com.shams.recursion;

public class NthBitBinaryNumbers {

  public static void main(String[] args) {
    int n = 5;
    solve(0, 0, "", n);
  }

  private static void solve(int ones, int zeros, String op, int n) {
    if(n == 0) {
      System.out.println(op);
      return;
    }
    String op1 = op;
    op1 = op1 + '1';
    solve(ones+1, zeros, op1, n-1);
    if(ones > zeros) {
      String op2 = op;
      op2 = op2 + '0';
      solve(ones, zeros+1, op2, n-1);
    }
  }
}
