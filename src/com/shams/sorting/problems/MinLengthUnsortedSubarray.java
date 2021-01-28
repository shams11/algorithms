package com.shams.sorting.problems;

/**
 * Reference : https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 */
public class MinLengthUnsortedSubarray {
  public static void main(String[] args) {
    int[] a = {0, 1, 15, 25, 6, 7, 30, 40, 50};
    int[] a1 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
    findMinLengthSubArray(a1);
  }

  private static void findMinLengthSubArray(int[] a) {
    int start = 0, end = 0;
    for (int i = 0; i < a.length - 1; ++i) {
      if (a[i] > a[i + 1]) {
        start = i;
        break;
      }
    }
    if (start == a.length - 1) {
      System.out.println("The complete array is sorted");
      return;
    }
    for (int i = a.length - 1; i > 0; --i) {
      if (a[i] < a[i - 1]) {
        end = i;
        break;
      }
    }
    System.out.println("start : " + start + "   end : " + end);

    int min = a[start];
    int max = a[start];
    for (int i = start + 1; i <= end; ++i) {
      if (a[i] < min) {
        min = a[i];
      }
      if (a[i] > max) {
        max = a[i];
      }
    }
    System.out.println(" Min : " + min + "   Max : " + max);
    for(int i = 0; i < start; ++i) {
      if (a[i] > min) {
        start = i;
        break;
      }
    }

    for(int i = a.length -1; i >= end -1; --i) {
      if (a[i] < max) {
        end = i;
        break;
      }
    }
    System.out.println("Final start : " + start + "   Final end : " + end);
  }
}
