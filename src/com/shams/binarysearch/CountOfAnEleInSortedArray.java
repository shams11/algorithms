/**
 * https://www.youtube.com/watch?v=Ru_HhBFV3Xo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=6&ab_channel=AdityaVerma
 * https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 */

package com.shams.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfAnEleInSortedArray {

  public static void main(String[] args) {
    int[] a = {1, 1, 2, 2, 2, 2, 3};
    int x = 2;
    System.out.println(countOccurrence(a, x));
    System.out.println(countFrequency(a, x));
  }

  private static int countFrequency(int[] a, int x) {
    List<Integer> list = new ArrayList<>();
    for (int i : a) {
      list.add(i);
    }
    return Collections.frequency(list, x);
  }

  private static int countOccurrence(int[] a, int x) {
    int firstIndex = getFirstIndex(a, x, 0, a.length - 1);
    int lastIndex = getLastIndex(a, x, 0, a.length - 1);
    if (firstIndex == -1 && lastIndex == -1) return -1;
    return lastIndex - firstIndex + 1;
  }

  private static int getLastIndex(int[] a, int x, int start, int end) {
    int res = -1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (x == a[mid]) {
        res = mid;
        start = mid + 1;
      } else if (x < a[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private static int getFirstIndex(int[] a, int x, int start, int end) {
    int res = -1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (x == a[mid]) {
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
