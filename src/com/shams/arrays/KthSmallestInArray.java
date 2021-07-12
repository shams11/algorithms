package com.shams.arrays;

public class KthSmallestInArray {
  public static void main(String[] args) {
    int[] a = {3, 2, 1, 5, 6, 4, 9, 8, 24, 16};
    int k = 9;
    System.out.println(findKthSmallest(a, k));
  }

  private static int findKthSmallest(int[] a, int k) {
    int start = 0, end = a.length - 1, resultIndex = k - 1;

    while(start <= end) {
      int pivotIndex = partition(a, start, end);
      if(pivotIndex < resultIndex) start = pivotIndex + 1;
      else if(pivotIndex > resultIndex) end = pivotIndex - 1;
      else return a[pivotIndex];
    }
    return a[resultIndex];
  }

  static int partition(int[] a, int start, int end) {
    int pivotIndex = start;
    while(start <= end) {
      while(start <= end && a[start] <= a[pivotIndex]) start++;
      while (start <= end && a[end] >= a[pivotIndex]) end--;

      if(start > end) break;;

      swap (a, start, end);
    }
    swap(a, end, pivotIndex);
    return end;
  }

  private static void swap(int[] a, int start, int end) {
    int temp = a[start];
    a[start] = a[end];
    a[end] = temp;
  }
}
