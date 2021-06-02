/***
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14&ab_channel=AdityaVerma
 * */

package com.shams.dp;

public class UnboundedKnapsackOrRodCuttingProblem {

  public static void main(String[] args) {
    int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
    int[] length = new int[prices.length];
    for (int i = 0; i < length.length; i++) {
      length[i] = i + 1;
    }
    System.out.println(cutRods(length, prices, prices.length, prices.length));
  }

  private static int cutRods(int[] length, int[] prices, int W, int n) {
    int[][] t = new int[n + 1][W + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < W + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (length[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = Math.max(prices[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
        }
      }
    }
    return t[n][W];
  }
}
