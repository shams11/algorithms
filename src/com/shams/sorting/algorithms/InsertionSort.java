package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

public class InsertionSort {

  public static void main(String[] args) {
    int[] a = {9, 10, 2, 4, 4};
    int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    insertionSort(a1);
    UtilityHelper.printArray(a1);
  }

  private static void insertionSort(int[] a) {
    int j;
    for (int i = 1; i < a.length; ++i) {
      j = i;
      while (j > 0 && a[j] < a[j - 1]) {
        UtilityHelper.swap(a, j, j - 1);
        --j;
      }
    }
  }
}
