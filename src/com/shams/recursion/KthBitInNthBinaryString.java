/***
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 * */

package com.shams.recursion;

public class KthBitInNthBinaryString {
  public static void main(String[] args) {
    System.out.println(solve(4, 11));
  }

  private static char solve(int n, int k) {
    if (n == 1 && k == 1) {
      return '0';
    }
    int mid = (int) (Math.pow(2, n) - 1) / 2;
    if (k == mid + 1) {
      return '1';
    } else if (k < mid + 1) {
      return solve(n - 1, k);
    } else {
      int newMid = k - (mid + 1);
      newMid = mid - newMid + 1; // newMid position is the reverse position in the previous string
      char ans = solve(n - 1, newMid);
      if (ans == '0')
        return '1';
      else return '0';
    }
  }
}


