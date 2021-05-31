/**
 * https://leetcode.com/problems/unique-paths/
 */

package com.shams.dp;

public class UniquePaths {
  public static void main(String[] args) {
    int m = 3, n = 7;
    System.out.println(uniquePaths(m, n));
  }

  public static int uniquePaths(int m, int n) {
    int[][] t = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 1;
        }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        t[i][j] = t[i - 1][j] + t[i][j - 1];
      }
    }
    return t[m - 1][n - 1];
  }
}
