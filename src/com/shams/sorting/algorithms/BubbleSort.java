package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

public class BubbleSort {
  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    bubbleSort(a1);
    UtilityHelper.printArray(a1);
  }

  private static void bubbleSort(int[] a) {
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a.length - i - 1; ++j) {
        if (a[j] > a[j + 1]) {
          UtilityHelper.swap(a, j, j + 1);
        }
      }
    }
  }
}
