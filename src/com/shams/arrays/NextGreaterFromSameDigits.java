/***
 * https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 * https://leetcode.com/problems/next-permutation/
 * */

package com.shams.arrays;

import java.util.Arrays;

public class NextGreaterFromSameDigits {

  public static void main(String[] args) {
    // int[] a1 = {2, 3, 1};
    // Output : 312
    int[] a2 = { 5, 3, 4, 9, 7, 6 };
    // Output : 536479
    nextPermutation(a2);
    Arrays.stream(a2).forEach(System.out::print);

  }

  public static void nextPermutation(int[] nums) {
    int k = nums.length - 2;
    while (k >= 0 && nums[k] >= nums[k + 1])
      k--;

    if (k == -1) {
      Arrays.sort(nums);
      return;
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > nums[k]) {
        swap(nums, k, i);
        break;
      }
    }
    Arrays.sort(nums, k + 1, nums.length);
  }

  private static void swap(int[] a, int start, int end) {
    int temp = a[start];
    a[start] = a[end];
    a[end] = temp;
  }
}
