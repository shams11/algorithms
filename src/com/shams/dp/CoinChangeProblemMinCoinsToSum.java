/**
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16&ab_channel=AdityaVerma
 */

package com.shams.dp;

public class CoinChangeProblemMinCoinsToSum {
  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int amount = 11;
    System.out.println(coinChange(coins, amount));
  }

  private static int coinChange(int[] coins, int sum) {
    int n = coins.length;
    int[][] t = new int[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = Integer.MAX_VALUE -1;
        }
        if (j == 0) {
          t[i][j] = 0;
        }
      }
    }
    t[0][0] = Integer.MAX_VALUE -1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coins[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
        }
      }
    }
    return t[n][sum] == Integer.MAX_VALUE-1 ? -1 : t[n][sum];
  }
}
