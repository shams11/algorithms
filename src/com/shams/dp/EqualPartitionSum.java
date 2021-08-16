/**
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
 */

package com.shams.dp;

public class EqualPartitionSum {
  public static void main(String[] args) {
    int[] arr = {1, 3, 3, 2, 3, 2};
    int n = arr.length;
    System.out.println(isEqualPartitionSubSetSumExists(arr, arr.length));
  }

  private static boolean isEqualPartitionSubSetSumExists(int[] arr, int n) {
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      sum += arr[i];
    }
    if (sum % 2 != 0) {
      return false;
    }
    //return isSubSetSum(arr, sum / 2, n);
    return canPartition(arr, sum/2, n);
  }

  // Recursive
  private static boolean isSubSetSum(int[] arr, int sum, int n) {
    if (sum == 0) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    if (arr[n - 1] > sum) {
      return isSubSetSum(arr, sum, n - 1);
    }
    return isSubSetSum(arr, sum, n - 1) || isSubSetSum(arr, sum - arr[n - 1], n - 1);
  }
  private static boolean canPartition(int[] a, int sum, int n) {
    boolean[][] t = new boolean[n+1][sum+1];
    for(int i = 0; i < n + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0) t[i][j] = false;
        if (j == 0) t[i][j] = true;
      }
    }

      for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < sum + 1; j++) {
          if(a[i - 1] > j) {
            t[i][j] = t[i-1][j];
          } else {
            t[i][j] = t[i - 1][j - a[i-1]] || t[i - 1][j];
          }
        }
      }
   return t[n][sum];
  }
}
