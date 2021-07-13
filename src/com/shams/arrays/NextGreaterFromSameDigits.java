/***
 * https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 * */

package com.shams.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NextGreaterFromSameDigits {


  public static void main(String[] args) {
    int[] a = {2, 3, 1};
    nextPermutation(a);
    Arrays.stream(a).forEach(System.out::print);
  }

  public static void nextPermutation(int[] nums) {
    int k = nums.length - 2;
    while (k >= 0 && nums[k] >= nums[k + 1]) k--;

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
