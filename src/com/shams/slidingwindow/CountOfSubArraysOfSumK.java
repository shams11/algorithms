/***
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 * */

package com.shams.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraysOfSumK {
  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    int k = 3;
    System.out.println(contSubArraysOfSizeK(a, k));
  }

  public static int contSubArraysOfSizeK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0, result = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if(map.containsKey(sum - k)) {
        result += map.get(sum - k);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
}
