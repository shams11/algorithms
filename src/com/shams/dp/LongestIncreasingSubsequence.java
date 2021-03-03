/***
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * https://www.youtube.com/watch?v=mouCn3CFpgg&ab_channel=TECHDOSE
 * */

package com.shams.dp;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lengthOfLIS(nums));
  }
  public static int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    for(int i = 0; i < n; i++) {
      lis[i] = 1;
    }
    for(int i = 1; i < n; i++) {
      for(int j = 0; j < i; j++) {
        if(nums[i] > nums[j] && lis[i] <= lis[j]) {
          lis[i] = 1 + lis[j];
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
      max = Math.max(max, lis[i]);
    }
    return max;
  }
}
