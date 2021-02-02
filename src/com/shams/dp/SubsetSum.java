/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.youtube.com/watch?v=_gPcYovP7wc
 */

package com.shams.dp;

public class SubsetSum {
  static int count = 0;

  public static void main(String[] args) {
    int[] arr = {3, 4, 5, 2};
    int sum = 12;
    int n = arr.length;
    subSetSum(arr, sum, n);
    System.out.println(count);
    //System.out.println(subSetSumTopdown(arr, sum, n));
  }


  private static boolean subSetSumTopdown(int[] arr, int sum, int n) {
    boolean[][] t = new boolean[n + 1][sum + 1];

    //Initialization
    for (int i = 0; i < n + 1; ++i) {
      for (int j = 0; j < sum + 1; ++j) {
        if (i == 0) {
          t[i][j] = false;
        }
        if (j == 0) {
          t[i][j] = true;
        }
      }
    }

    for (int i = 1; i < n + 1; ++i) {
      for (int j = 1; j < sum + 1; ++j) {
        if (arr[i - 1] > j) {
          t[i][j] = t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }

  static boolean isSubsetEqualToSum = false;
  private static boolean subSetSum(int[] arr, int sum, int n) {
    if (sum == 0) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    if (arr[n - 1] > sum) {
      return subSetSum(arr, sum, n - 1);
    }
    isSubsetEqualToSum =  subSetSum(arr, sum - arr[n - 1], n - 1) ||
        subSetSum(arr, sum, n - 1);
    if(isSubsetEqualToSum)
      count++;
    return isSubsetEqualToSum;
  }
}
