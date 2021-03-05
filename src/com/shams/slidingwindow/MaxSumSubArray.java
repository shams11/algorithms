/**
 * https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3&ab_channel=AdityaVerma
 * https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 */

package com.shams.slidingwindow;

public class MaxSumSubArray {
  public static void main(String[] args) {
    int[] a = {2, 5, 1, 8, 2, 9, 1};
    int k = 3;
    System.out.println(maxSumSubArray(a, k));
  }

  private static int maxSumSubArray(int[] a, int k) {
    int i = 0, j = 0, sum = 0;
    int max = Integer.MIN_VALUE;
    while (j < a.length) {
      sum += a[j];
      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        max = Math.max(max, sum);
        sum -= a[i];
        i++;
        j++;
      }
    }
    return max;
  }
}
