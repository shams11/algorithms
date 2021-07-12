package com.shams.arrays;

public class KthLargestInArray {
  public static void main(String[] args) {
    int[] a = {3, 2, 1, 5, 6, 4};
    int k = 2;
    System.out.println(findKthLargest(a, k));
  }

  public static int findKthLargest(int[] nums, int k) {
    int resultIndex = nums.length - k;
    int start = 0, end = nums.length - 1;

    while (start <= end) {
      int pivotIndex = partition(nums, start, end);
      if (pivotIndex < resultIndex) start = pivotIndex + 1;
      else if (pivotIndex > resultIndex) end = pivotIndex - 1;
      else return nums[pivotIndex];
    }
    return nums[resultIndex];
  }

  static int partition(int[] a, int start, int end) {
    int pivotIndex = start;

    while (start <= end) {
      while (start <= end && a[start] <= a[pivotIndex]) start++;
      while (start <= end && a[end] >= a[pivotIndex]) end--;

      if (start > end) break;

      swap(a, start, end);
    }
    swap(a, pivotIndex, end);
    return end;
  }

  private static void swap(int[] a, int start, int end) {
    int temp = a[start];
    a[start] = a[end];
    a[end] = temp;
  }
}
