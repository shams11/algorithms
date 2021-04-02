/**
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */

package com.shams.binarysearch;

public class RotationCountInSortedArray {
  public static void main(String[] args) {
    //int[] a = {7, 9, 11, 12, 5};
    // Output : 4

    // int[] a = {7, 9, 11, 12, 15};
    // Output : 0

    int[] a = {4, 5, 6, 7, 0, 1, 2};
    // Output : 4
    System.out.println(rotationCount(a, 0, a.length - 1, a.length));
  }

  private static int rotationCount(int[] a, int start, int end, int n) {
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
      } else if (a[mid] <= end) {
        end = mid - 1;
      }
    }
    return 0;
  }
}
