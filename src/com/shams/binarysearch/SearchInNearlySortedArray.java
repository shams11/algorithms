/**
 * https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9&ab_channel=AdityaVermaAdityaVerma
 */

package com.shams.binarysearch;

// Modified Binary search
public class SearchInNearlySortedArray {
  public static void main(String[] args) {
    int[] a = {10, 20, 40, 30, 50};
    System.out.println(binarySearch(a, 40, 0, a.length));

  }

  static int binarySearch(int[] a, int x, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (a[mid] == x) return mid;
      if ((mid - 1) >= start && a[mid - 1] == x) return mid - 1;
      if ((mid + 1) <= end && a[mid + 1] == x) return mid + 1;
      if (x < a[mid]) end = mid - 2;
      else start = mid + 2;
    }
    return -1;
  }
}
