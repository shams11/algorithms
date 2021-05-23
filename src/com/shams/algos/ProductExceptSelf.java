/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */

package com.shams.algos;

import java.util.Arrays;

public class ProductExceptSelf {
  public static void main(String[] args) {
    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]

    //Example 2:
    //Input: nums = [-1,1,0,-3,3]
    //Output: [0,0,9,0,0]
    int[] nums = {1, 2, 3, 4};
    Arrays.stream(productExceptSelf(nums)).forEach( i -> System.out.print( i + " "));
  }

  private static int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      res[i] = nums[i - 1] * res[i - 1];
    }
    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] = res[i] * right;
      right *= nums[i];
    }
    return res;
  }
}
