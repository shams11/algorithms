/**
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 */

package com.shams.dp;

public class CountOfSubsetsWithGivenSum {
  public static void main(String[] args) {
    int[] a = {3, 3, 3, 3 };
    int sum = 6;
    System.out.println(countSubsetWithGiveSum(a, sum, a.length));
    System.out.println(countSubsetWithGiveSumRecursive(a, sum, a.length));
  }

  private static int countSubsetWithGiveSumRecursive(int[] a, int sum, int n) {
    if (sum == 0) {
      return 1;
    }
    if (n == 0) {
      return 0;
    }
    if (a[n - 1] > sum) {
      return countSubsetWithGiveSumRecursive(a, sum, n - 1);
    }
    return countSubsetWithGiveSumRecursive(a, sum, n - 1)
        + countSubsetWithGiveSumRecursive(a, sum - a[n - 1], n - 1);
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
