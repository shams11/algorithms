/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 * https://www.youtube.com/watch?v=EwggFsMTxu8&ab_channel=MichaelMuinos
 * https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=6&ab_channel=AdityaVerma
 * */
package com.shams.binarysearch;

public class FirstAndLastOccurrence {

  public static void main(String[] args) {
    int[] a = {2, 2};
    int target = 3;
    int[] res = searchRange(a, target);
    System.out.println("[" + res[0] + "," + res[1] + "]");
  }

  public static int[] searchRange(int[] nums, int target) {
    int firstOccurrence = getFirstOccurrence(nums, target, 0, nums.length - 1);
    int lastOccurrence = getLastOccurance(nums, target, 0, nums.length - 1);
    int[] result = {firstOccurrence, lastOccurrence};
    return result;
  }

  static int getFirstOccurrence(int[] nums, int target, int start, int end) {
    int res = -1, mid;
    if (nums.length == 0) {
      return res;
    }
    if (nums.length == 1 && nums[0] == target) {
      return 0;
    }
    if (nums.length == 1 && nums[0] != target) {
      return res;
    }
    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        res = mid;
        end = mid - 1;
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  static int getLastOccurance(int[] nums, int target, int start, int end) {
    int res = -1, mid;
    if (nums.length == 0) {
      return res;
    }

    if (nums.length == 1 && nums[0] == target) {
      return 0;
    }
    if (nums.length == 1 && nums[0] != target) {
      return res;
    }
    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        res = mid;
        start = mid + 1;
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }
}
