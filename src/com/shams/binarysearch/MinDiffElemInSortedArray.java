/***
 * https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

public class MinDiffElemInSortedArray {
  public static void main(String[] args) {
    int[] a = {1, 3, 8, 10, 15};
    int k = 6;
    System.out.println(getMinDiffForKey(a, 0, a.length - 1, k));
  }

  private static int getMinDiffForKey(int[] a, int start, int end, int key) {
    if (key < a[start]) {
      return a[0] - key;
    }
    if (key > a[end]) {
      return key - a[end];
    }
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == key) {
        return 0;
      }
      if (key < a[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    // when start and end cross over after while loop, the min difference of elements at start and end with K
    // will be the answer
    return Math.min(Math.abs(a[end] - key), Math.abs(a[start] - key));
  }
}
