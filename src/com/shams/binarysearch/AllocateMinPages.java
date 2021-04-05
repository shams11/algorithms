/***
 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 * https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

import java.util.Arrays;

public class AllocateMinPages {
  public static void main(String[] args) {
    /**
     * Input : [10, 10, 40]
     * scheme1 => [10, 50], scheme2 => [20, 40]
     * max pages in each scheme = [50, 40]
     * min in above step is 40, should be the answer
     * */
    /**
     * [10, 20, 30, 40]
     * scheme1 => [10, 90], scheme2 => [30, 70], scheme3 => [60, 60]
     * max pages in each scheme = [90, 70, 60]
     * min in above step is 60, should be the answer
     * */
    int[] a = {10, 20, 30, 40};
    int k = 2;
    System.out.println(allocateMaxPages(a, k));
  }

  private static int allocateMaxPages(int[] a, int k) {
    int start = Arrays.stream(a).max().getAsInt();
    int end = Arrays.stream(a).sum();
    int res = -1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (isSchemeValid(a, k, mid)) {
        res = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }

  private static boolean isSchemeValid(int[] a, int k, int mid) {
    int sum = 0, student = 1;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if (sum > mid) {
        student++;
        sum = a[i];
      }
      if (student > k) {
        return false;
      }
    }
    return true;
  }
}
