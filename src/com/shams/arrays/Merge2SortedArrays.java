/**
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 */

package com.shams.arrays;

import com.shams.commons.UtilityHelper;

public class Merge2SortedArrays {
  public static void main(String[] args) {
    int[] a = {1, 5, 9, 10, 15, 20};
    int[] b = {2, 3, 8, 13};
    mergeArrays(a, b, a.length, b.length);
    UtilityHelper.printArray(a);
    UtilityHelper.printArray(b);

    /**
     * Output: ar1[] = {1, 2, 3, 5, 8, 9}
     *         ar2[] = {10, 13, 15, 20}
     * */
  }

  private static void mergeArrays(int[] a, int[] b, int m, int n) {
    int i = 0;
    int j = 0;
    while (i < m && j < n) {
      if (a[i] < b[j]) {
        i++;
      } else {
        swap(a, b, i, j);
        int k = j;
        while ( k  < n -1 && b[k] > b[k + 1]) {
          UtilityHelper.swap(b, k, k + 1);
          k++;
        }
      }
    }
  }

  private static void swap(int[] a, int[] b, int i, int j) {
    int temp = a[i];
    a[i] = b[j];
    b[j] = temp;
  }
}
