/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19&ab_channel=AdityaVerma
 */

package com.shams.dp;

public class LongestCommonSubSequence {

  static int[][] t;

  public static void main(String[] args) {

    String s1 = "horse";
    String s2 = "ros";

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
    //System.out.println("Length of LCS is in Memoization " + " " + lcsMemoization(X, Y, n, m));
    System.out.println("Length of LCS is in Top down " + " " + lcsTopDown(s1, s2, n, m));
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

  private static int lcsTopDown(String x, String y, int n, int m) {
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }
    return t[n][m];
  }
}
