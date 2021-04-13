/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * https://www.youtube.com/watch?v=4Gi8uAz666s&list=PLtQWXpf5JNGJMr17PhMPBtYG5JP1_Ownp&index=1&ab_channel=MichaelMuinos
 */

package com.shams.binarysearch;

public class SingleEleInSortedArray {
  public static void main(String[] args) {
    int[] a = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    System.out.println(singleNonDuplicate(a));
  }

  public static int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) return nums[0];
    int start = 0, end = nums.length - 1, mid;
    while (start < end) {
      mid = start + (end - start) / 2;
      boolean isEven = (end - mid) % 2 == 0;
      if (nums[mid] == nums[mid - 1]) {
        if (isEven) {
          end = mid - 2;
        } else {
          start = mid + 1;
        }
      } else if (nums[mid] == nums[mid + 1]) {
        if (isEven) {
          start = mid + 2;
        } else {
          end = mid - 1;
        }
      } else {
        return nums[mid];
      }
    }
    return nums[start];
  }
}
