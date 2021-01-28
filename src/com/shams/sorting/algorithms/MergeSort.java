package com.shams.sorting.algorithms;

import com.shams.commons.UtilityHelper;

public class MergeSort {

  // https://www.javatpoint.com/merge-sort
  public static void main(String[] args) {
    int[] a = {1, 2, 4, 4};
    // int[] a1 = {9, 3, 4, 2, 7, 6, 8, 1, 5};
    int[] a1 = {10, 5, 2, 23, 45, 21, 7, 5, 10};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    int[] temp = new int[a1.length];
    mergeSort(a1, temp, 0, a1.length - 1);
    UtilityHelper.printArray(a1);
  }

  private static void mergeSort(int[] a, int[] temp, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(a, temp, start, mid);
      mergeSort(a, temp, mid + 1, end);
      merge(a, temp, start, mid, end);
    }
  }

  private static void merge(int[] a, int[] temp, int start, int mid, int end) {
    int i = start;
    int j = mid + 1;
    int k = start;

    while (i <= mid && j <= end) {
      if (a[i] < a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    while (i <= mid) {
      temp[k++] = a[i++];
    }
    while (j <= end) {
      temp[k++] = a[j++];
    }

    for (int l = start; l < k; ++l) {
      a[l] = temp[l];
    }
  }
}
