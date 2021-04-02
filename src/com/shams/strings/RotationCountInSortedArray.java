/**
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */

package com.shams.strings;

public class RotationCountInSortedArray {
  public static void main(String[] args) {
    //int[] a = {7, 9, 11, 12, 5};
    // Output : 4

    // int[] a = {7, 9, 11, 12, 15};
    // Output : 0

    int[] a = {15, 18, 2, 3, 6, 12};
    // Output : 2
    System.out.println(rotationCount(a, 0, a.length - 1, a.length));
  }

  private static int rotationCount(int[] a, int start, int end, int n) {
    int mid, next, prev;
    while (start <= end) {
      mid = start + (end - start) / 2;
      next = (mid + 1) % n;
      prev = (mid + n - 1) % n;
      if (a[mid] <= a[next] && a[mid] <= a[prev]) {
        return mid;
      }
      if (a[start] > a[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return 0;
  }
}
