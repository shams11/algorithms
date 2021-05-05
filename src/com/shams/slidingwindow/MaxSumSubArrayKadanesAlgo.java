/**
 * https://www.youtube.com/watch?v=tmakGVOGV3A&ab_channel=MichaelMuinos
 * https://leetcode.com/problems/maximum-subarray/
 */

package com.shams.slidingwindow;

public class MaxSumSubArrayKadanesAlgo {
  public static void main(String[] args) {
    int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(a));
    // Output: 6
    // Explanation: [4,-1,2,1] has the largest sum = 6.
  }

  public static int maxSubArray(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
      max = Math.max(max, nums[i]);
    }
    return max;
  }
}
