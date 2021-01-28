package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

public class SelectionSort {
  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    selectionSort(a1);
    UtilityHelper.printArray(a1);
  }

  private static void selectionSort(int[] a) {
    int smallest;
    int smallestIndex = -1;
    for (int i = 0; i < a.length - 1; ++i) {
      smallest = a[i];
      smallestIndex = i;
      for (int j = i + 1; j < a.length; ++j) {
        if(smallest > a[j]) {
          smallest = a[j];
          smallestIndex = j;
        }
      }
      UtilityHelper.swap(a, i, smallestIndex);
      // System.out.println("swapping i : " + i + " with smallestIndex : " + smallestIndex);
      // UtilityHelper.printArray(a);
    }
  }
}
