/**
 * https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 */

package com.shams.dp;

public class LongestCommonSubstring {

  static int[][] t;

  public static void main(String[] args) {
    String s1 = "zxabcdezy";
    String s2 = "yzabcdezx";

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
    System.out.println("Length of longest common substring " + " " + longestCommonSubstring(X, Y, n, m));
  }

  private static int longestCommonSubstring(char[] x, char[] y, int n, int m) {
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (x[i - 1] == y[j - 1]) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = 0;
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        max = Math.max(max, t[i][j]);
      }
    }
    return max;
  }
}
