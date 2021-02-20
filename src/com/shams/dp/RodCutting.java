/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 */

package com.shams.dp;

public class RodCutting {
  public static void main(String[] args) {
    int[] cuts = {1, 3, 4, 5};
    int N = 7;
    System.out.println(minCost(cuts, N, cuts.length));
  }

  public static int minCost(int[] cuts, int N, int n) {
    int[][] t = new int[n + 1][N + 1];

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < N + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if(j == 0) {
          t[i][j] = 1;
        }
      }
    }
    t[0][0] = 0;
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < N + 1; j++) {
        if (cuts[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = Math.min(t[i - 1][j],  j + t[i-1][j - cuts[i - 1]]);
        }
      }
    }
    return t[n][N];
  }
}
