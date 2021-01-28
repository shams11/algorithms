package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

/***
 * Program is not working. Need to modify
 * */
public class QuickSort {
  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    // int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    int[] a1 = {9, 3, 4, 2, 7};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    quickSort(a1, 0, a1.length - 1);
    UtilityHelper.printArray(a1);
  }

  private static void quickSort(int[] a, int start, int end) {
    if (start < end) {
      int partitionIndex = partition(a, start, end);
      quickSort(a, start, partitionIndex - 1);
      quickSort(a, partitionIndex + 1, end);
    }
  }

  private static int partition(int[] a, int p, int q) {
    int pivot = a[p];
    int i = p + 1;
    int j = q;
    int partitionIndex;

    while (true) {
      while (i < q && pivot > a[i]) {
        ++i;
      }

      while ( pivot < a[j]) {
        --j;
      }

      if (i < j) {
        UtilityHelper.swap(a, i, j);
      } else {
        break;
      }
    }
    if (a[j] > a[j - 1]) {
      partitionIndex = j;
    } else {
      partitionIndex = j - 1;
    }
    UtilityHelper.swap(a, partitionIndex, p);
    return partitionIndex;
  }
}
