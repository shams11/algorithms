/**
 * https://www.youtube.com/watch?v=uiz0IxPCUeU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=11&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
 */

package com.shams.binarysearch;

public class CeilOfAnEleInSortedArray {
  public static void main(String[] args) {
    int[] a = {1, 2, 8, 10, 10, 12, 19};
    int x = 20;
    // Output : floor doesn't exist in array,  ceil  = 1
    // For x = 1:    floor  = 1,  ceil  = 1
    // For x = 5:    floor  = 2,  ceil  = 8
    // For x = 20:   floor  = 19,  ceil doesn't exist in array
    System.out.println(ceilOfX(a, 0, a.length - 1, x));
  }

  private static int ceilOfX(int[] a, int start, int end, int x) {
    int mid, res = -1;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == x) {
        return x;
      }
      if (a[mid] > x) {
        res = a[mid];
        end = mid - 1;
      } else if (a[mid] < x) {
        start = mid + 1;
      }
    }
    return res;
  }
}
