/***
 * https://leetcode.com/problems/find-peak-element/submissions/
 * https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

public class PeekElement {
  public static void main(String[] args) {
    // int[] a = {1, 2, 1, 3, 5, 6, 4};
    // Output : 5
    // Explanation: Your function can return either index number 1 where the peak element is 2,
    // or index number 5 where the peak element is 6.

    int[] a = {1, 2, 3, 1};
    //Output: 2
    //Explanation: 3 is a peak element and your function should return the index number 2.
    System.out.println(findPeakElement(a, 0, a.length - 1));
  }

  public static int findPeakElement(int[] a, int start, int end) {
    if (a.length == 1) {
      return 0;
    }
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (mid > 0 && mid < end) {
        if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
          return mid;
        }
        if (a[mid - 1] > a[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (mid == 0) {
        if (a[mid] > a[mid + 1]) {
          return 0;
        } else {
          return 1;
        }
      } else if (mid == end) {
        if (a[mid] > a[mid - 1]) {
          return mid;
        } else {
          return mid - 1;
        }
      }
    }
    return -1;
  }
}
