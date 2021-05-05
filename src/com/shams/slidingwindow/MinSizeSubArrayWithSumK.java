package com.shams.slidingwindow;

public class MinSizeSubArrayWithSumK {
  public static void main(String[] args) {
    int[] a = {2, 3, 1, 2, 4, 3};
    int k = 7;
    // Output: 2
    // Explanation: The subarray [4,3] has the minimal length under the problem constraint.
    System.out.println(minSubArrayLen(k, a));
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int sum = 0, ans = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (j < nums.length) {
      sum += nums[j];
      if (sum < target) {
        j++;
      } else if (sum >= target) {
        while (sum >= target) {
          ans = Math.min(ans, j - i + 1);
          sum -= nums[i];
          i++;
        }
        j++;
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
