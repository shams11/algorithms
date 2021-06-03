/***
 *
 * https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/shortest-common-supersequence/
 * */

package com.shams.dp;

public class ShortestCommonSupersequence {
  static int[][] t;

  public static void main(String[] args) {
    String s1 = "voldemort";
    String s2 = "dumbledore";

    int m = s1.length();
    int n = s2.length();

    t = new int[m + 1][n + 1];
    int l = lcs(s1, s2, m, n);

    System.out.println("length of shortest common super sequence : " + (m + n - l));
  }

  // Shortest common super sequence => ((len of X +  len of Y) - LCS)
  private static int lcs(String x, String y, int m, int n) {
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for(int j = 1; j < n+1; j++) {
        if(x.charAt(i-1) == y.charAt(j-1)) {
          t[i][j] = t[i-1][j-1] + 1;
        } else {
          t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
        }
      }
    }
    return t[m][n];
  }
}
