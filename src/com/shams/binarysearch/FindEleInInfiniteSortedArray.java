/***
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

public class FindEleInInfiniteSortedArray {
  public static void main(String[] args) {
    int[] a = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
    int x = 10;
    // Output : 4;
    System.out.println(findPos(a, 10));
  }

  private static int findPos(int[] a, int x) {
    int start = 0, end = 1;
    while (x > a[end]) {
      start = end;
      end = 2 * end;
    }
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == x) {
        return mid;
      }
      if (a[mid] < x) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
