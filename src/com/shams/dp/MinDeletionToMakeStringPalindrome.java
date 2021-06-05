/**
 *
 * https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 * */
package com.shams.dp;

public class MinDeletionToMakeStringPalindrome {
  static int[][] t;
  public static void main(String[] args) {
    String s = "geeksforgeeks";
    StringBuffer rs = new StringBuffer(s);
    rs = rs.reverse();
    int m = s.length();
    int n = rs.length();
    t = new int[m+1][n+1];
    int l = lcs(s, rs.toString(), m, n);
    System.out.println("lcs : " + l);
    System.out.println( m  - l);
  }

   // Min deletions to make string Palindrome = s.length - LPS
  // LPS = LCS(a, rev(a))
  private static int lcs(String x, String y, int m, int n) {
    for(int i = 0; i < m+1; i++) {
      for(int j = 0; j < n+1; j++) {
        if(i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for(int i = 1; i < m+1; i ++) {
      for(int j = 1; j < n+1; j++) {
        if(x.charAt(i-1) == y.charAt(j-1)) {
          t[i][j] = 1 + t[i-1][j-1];
        } else {
          t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
        }
      }
    }
    return t[m][n];
  }
}
