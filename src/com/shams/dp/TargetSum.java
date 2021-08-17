/**
 * https://leetcode.com/problems/target-sum/
 * Same code ad Count of subsets with given diff
 * */
package com.shams.dp;

import java.util.Arrays;

public class TargetSum {
  public static void main(String[] args) {
    int[] a = {1, 1, 1, 1, 1};
    int diff = 3;
    System.out.println(countOfSubSetsWithGivenDiff(a, diff, a.length));
  }

  private static int countOfSubSetsWithGivenDiff(int[] a, int diff, int n) {
    int totalSum = Arrays.stream(a).sum();
    int sum = (diff + totalSum) / 2;
    return countSubsetWithGiveSum(a, sum, n);
  }

  private static int countSubsetWithGiveSum(int[] a, int sum, int n) {

    int[][] t = new int[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum; j++) {
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
        if (a[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];
        }
      }
    }
    return t[n][sum];
  }
}
