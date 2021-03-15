/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */

package com.shams.dp;

public class Knapsack {
  public static void main(String[] args) {
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int W = 50;
    int n = val.length;
    System.out.println(" knapSackRecursive : " + knapSackRecursive(wt, val, W, n));
    System.out.println(" knapSackIterative : " + knapSackIterative(wt, val, W, n));
  }

  private static int knapSackIterative(int[] wt, int[] val, int W, int n) {
    int[][] t = new int[n + 1][W + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < W + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        } else if (wt[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = Math.max(t[i - 1][j], val[i - 1] + t[i - 1][j - wt[i - 1]]);
        }
      }
    }
    return t[n][W];
  }

  private static int knapSackRecursive(int[] wt, int[] val, int W, int n) {
    if (n == 0 || W == 0) {
      return 0;
    }
    if (wt[n - 1] > W) {
      return knapSackRecursive(wt, val, W, n - 1);
    } else {
      return Math.max(knapSackRecursive(wt, val, W, n - 1),
          val[n - 1] + knapSackRecursive(wt, val, W - wt[n - 1], n - 1));
    }
  }
}
