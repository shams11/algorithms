/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 */

package com.shams.bits;

public class MinFlips {
  public static void main(String[] args) {
    // int a = 2, b = 6, c = 5;
    //Input: a = 2, b = 6, c = 5
    //Output: 3
    //Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

    // int a = 4, b = 2, c = 7;
    // Output: 1

    int a = 1, b = 2, c = 3;
    //Output: 0
    System.out.println(minFlips(a, b, c));
  }

  public static int minFlips(int a, int b, int c) {

    StringBuilder a1 = new StringBuilder(Integer.toBinaryString(a));
    StringBuilder b1 = new StringBuilder(Integer.toBinaryString(b));
    StringBuilder c1 = new StringBuilder(Integer.toBinaryString(c));


    int maxLen = Math.max(a1.length(), Math.max(b1.length(), c1.length()));
    if (maxLen - a1.length() > 0) {
      appendLeadingZeros(a1, maxLen - a1.length());
    }
    if (maxLen - b1.length() > 0) {
      appendLeadingZeros(b1, maxLen - b1.length());
    }
    if (maxLen - c1.length() > 0) {
      appendLeadingZeros(c1, maxLen - c1.length());
    }
    int i = 0;
    int count = 0;
    while (i < c1.length()) {
      char ch = c1.charAt(i);
      if (ch == '1') {
        if (a1.charAt(i) == b1.charAt(i) && b1.charAt(i) == '0') {
          count++;
        }
      } else {
        if (a1.charAt(i) == b1.charAt(i) && a1.charAt(i) == '1') {
          count += 2;
        } else if (a1.charAt(i) != b1.charAt(i)) {
          count++;
        }
      }
      i++;
    }
    return count;
  }

  private static void appendLeadingZeros(StringBuilder s, int numOFZeroes) {
    while (numOFZeroes-- > 0) {
      s.insert(0, '0');
    }
    System.out.println("s : " + s);
  }
}
