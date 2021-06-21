/***
 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 * https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

import java.util.Arrays;

public class AllocateMinPages {
  public static void main(String[] args) {
    /**
     * Given number of pages in n different books and m students.
     * The books are arranged in ascending order of number of pages.
     * Every student is assigned to read some consecutive books.
     * The task is to assign books in such a way that the maximum number
     * of pages assigned to a student is minimum.
     *
     * Input : [10, 10, 40]
     * scheme1 => [10, 50], scheme2 => [20, 40]
     * max pages in each scheme = [50, 40]
     * min in above step is 40, should be the answer
     * */
    /**
     * [10, 20, 30, 40] and 2 students
     * scheme1 => [10, 90], scheme2 => [30, 70], scheme3 => [60, 40]
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
      // in this scheme, One student will read max of mid number of pages.
      // if the number of pages allocated to a student exceeds max,
      // then the book will be given to next student
      if (sum > mid) {
        student++;
        // ex : if mid is 50 books with 10 and 20 pages allocated to student 1),
        // then book with 30 pages cannot be allocated to student 1 because,
        // his capacity is only to read 50 pages now
        // so, allocate the book with 30 pages to student 2
        sum = a[i];
      }
      if (student > k) {
        return false;
      }
    }
    return true;
  }
}
