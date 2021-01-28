package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

public class HeapSort {
  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    int[] a1 = {5, 3, 4, 2, 7, 6, 8, 1, 9, 5, 3, 4, 1};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    heapSort(a1);
    UtilityHelper.printArray(a1);
  }

  private static void heapSort(int[] a) {
    int length = a.length;
    for (int i = (length / 2) - 1; i >= 0; --i) {
      heapify(a, i, length);
    }
    for (int i = length - 1; i > 0; --i) {
      UtilityHelper.swap(a, 0, i);
      heapify(a, 0, i);
    }
  }

  private static void heapify(int[] a, int i, int length) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;

    if (left < length && a[left] > a[largest]) {
      largest = left;
    }
    if (right < length && a[right] > a[largest]) {
      largest = right;
    }
    if (largest != i) {
      UtilityHelper.swap(a, largest, i);
      heapify(a, largest, length);
    }
  }
}
