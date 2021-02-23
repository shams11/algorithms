/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19&ab_channel=AdityaVerma
 */

package com.shams.dp;

import java.util.Arrays;

public class LongestCommonSubSequence {

  static int[][] t;

  public static void main(String[] args) {

    String s1 = "abcdxyz";
    String s2 = "xyzabcd";

    char[] X = s1.toCharArray();
    char[] Y = s2.toCharArray();
    int n = X.length;
    int m = Y.length;
    t = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        t[i][j] = -1;
      }
    }
    System.out.println("Length of LCS is in Memoization " + " " + lcsMemoization(X, Y, n, m));
    System.out.println("Length of LCS is in Top down " + " " + lcsTopDown(X, Y, n, m));
  }

  private static int lcsMemoization(char[] x, char[] y, int n, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (t[n][m] != -1) {
      return t[n][m];
    }
    if (x[n - 1] == y[m - 1]) {
      return t[n][m] = 1 + lcsMemoization(x, y, n - 1, m - 1);
    } else {
      return t[n][m] = Math.max(
          lcsMemoization(x, y, n, m - 1),
          lcsMemoization(x, y, n - 1, m));
    }
  }

  /*
      if (t[i - 1] == t[j - 1]) {
  *      curMaxLen = 1 + t[n - 1][m - 1];
      } else {

      }
  * */

  private static int lcsTopDown(char[] x, char[] y, int n, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (t[i - 1] == t[j - 1]) {
          t[n][m] = 1 + t[n - 1][m - 1];
        } else {
          t[n][m] = Math.max(t[n][m - 1], t[n - 1][m]);
        }
      }
    }
    return t[n][m];
  }
}
