/***
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 * https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
     int[] a = {4,5,6,7,0,1,2};
     int target = 0;
    // Output : 4

    // int[] a = {4, 5, 6, 7, 0, 1, 2};
    // int target = 3;
    // Output : -1
    // int[] a = {1};
    // int target = 0;
    // Output = -1;
    System.out.println(search(a, target));
  }

  public static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    if (nums.length == 1 && nums[0] != target) return -1;

    int index = getMinEleIndex(nums, 0, nums.length - 1, nums.length);
    int leftIndex = binarySearch(nums, 0, index - 1, target);
    int rightIndex = binarySearch(nums, index, nums.length - 1, target);
    if (leftIndex == -1 && rightIndex == -1) return -1;
    return leftIndex != -1 ? leftIndex : rightIndex;

  }

  static int getMinEleIndex(int[] a, int start, int end, int n) {
    int mid, next, prev;
    while (start <= end) {
      if (a[start] <= a[end]) {
        return start;
      }
      mid = start + (end - start) / 2;
      next = (mid + 1) % n;
      prev = (mid + n - 1) % n;
      if (a[mid] <= a[next] && a[mid] <= a[prev]) {
        return mid;
      }
      if (a[start] <= a[mid]) {
        start = mid + 1;
      } else if (a[mid] <= a[end]) {
        end = mid - 1;
      }
    }
    return 0;
  }

  static int binarySearch(int[] a, int start, int end, int target) {
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == target) return mid;
      if (a[mid] >= target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

}
