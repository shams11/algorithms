/***
 * https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * */

package com.shams.dp;

public class CoinChangeProblemMaxWays {
  public static void main(String[] args) {
    int[] coins = {1, 3, 4};
    System.out.println(change(4, coins, coins.length));

  }

  public static int change(int sum, int[] coins, int n) {
    int[][] t = new int[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) {
          t[i][j] = 0;
        }
        if (j == 0) {
          t[i][j] = 1;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coins[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
        }
      }
    }
    return t[n][sum];
  }
}
