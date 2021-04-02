/**
 * https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=10&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/floor-in-a-sorted-array/
 */

package com.shams.binarysearch;

public class FloorOfEleInSortedArray {

  public static void main(String[] args) {
    // int[] a = {1, 2, 8, 10, 10, 12, 19};
    // int x = 5;
    // Output : 2 is the largest element in arr[] smaller than 5

    int[] a = {1, 2, 8, 10, 10, 12, 19};
    int x = 20;
    // Output 19 is the largest element in arr[] smaller than 20.

    // int[] a = {1, 2, 8, 10, 10, 12, 19};
    // int x = 0;
    // Output : Since floor doesn't exist, output is -1.
    System.out.println(getFloorOfX(a, 0, a.length - 1, x));
  }

  private static int getFloorOfX(int[] a, int start, int end, int x) {
    int mid;
    int res = -1;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == x) {
        return x;
      }
      if (a[mid] < x) {
        res = a[mid];
        start = mid + 1;
      } else if (a[mid] > x) {
        end = mid - 1;
      }
    }
    return res;
  }
}
