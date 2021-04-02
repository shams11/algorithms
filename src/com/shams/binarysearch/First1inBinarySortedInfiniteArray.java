/**
 * https://www.youtube.com/watch?v=8x6dmO6XW8k&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=14&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
 */

package com.shams.binarysearch;

public class First1inBinarySortedInfiniteArray {
  public static void main(String[] args) {

    int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
    int x = 1;
    // Output : 13

    // This problem is combination of infinite array and first occurrence of key
    System.out.println(first1Position(a, 1));
  }

  private static int first1Position(int[] a, int x) {
    int start = 0, end = 1;
    while (x > a[end]) {
      start = end;
      end = end * 2;
    }
    return getFirstOccurrenceOf1(a, start, end, x);
  }

  private static int getFirstOccurrenceOf1(int[] a, int start, int end, int x) {
    int res = -1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == x) {
        res = mid;
        end = mid - 1;
      } else if (x < a[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }
}
