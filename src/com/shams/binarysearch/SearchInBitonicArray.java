/***
 * https://www.geeksforgeeks.org/find-element-bitonic-array/
 * https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19&ab_channel=AdityaVerma
 * */

package com.shams.binarysearch;

import org.w3c.dom.ls.LSOutput;

public class SearchInBitonicArray {
  public static void main(String[] args) {
//    int[] a = {-3, 9, 18, 20, 17, 5, 1};
//    int key = 20;
    // Output : Found at index 3

//    int[] a = {5, 6, 7, 8, 9, 10, 3, 2, 1};
//    int key = 30;
//    Output : Not Found

    int[] a = {1, 3, 8, 12, 4, 2};
    int key = 4;
    // Output : 4
    System.out.println(searchKeyIndexInBitonicArray(a, 0, a.length - 1, key));
  }

  private static int searchKeyIndexInBitonicArray(int[] a, int start, int end, int key) {
    int maxElementIndex = getMaxElementIndex(a, start, end);
    System.out.println("Max element index : " + maxElementIndex);
    int leftArrayIndex = binarySearch(a, start, maxElementIndex - 1, key);
    int rightArrayIndex = binarySearchInReverseSortedArray(a, maxElementIndex, end, key);
    if (leftArrayIndex == -1 && rightArrayIndex == -1) {
      return -1;
    }
    return leftArrayIndex != -1 ? leftArrayIndex : rightArrayIndex;
  }

  private static int binarySearchInReverseSortedArray(int[] a, int start, int end, int key) {
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == key) {
        return mid;
      }
      if (key < a[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  private static int binarySearch(int[] a, int start, int end, int key) {
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (a[mid] == key) {
        return mid;
      }
      if (key < a[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private static int getMaxElementIndex(int[] a, int start, int end) {
    if (a.length == 1) {
      return 0;
    }
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (mid > 0 && mid < end - 1) {
        if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
          return mid;
        }
        if (a[mid - 1] > a[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (mid == 0) {
        if (a[mid] > a[mid + 1]) {
          return 0;
        } else {
          return 1;
        }
      } else {
        if (a[mid] > a[mid - 1]) {
          return mid;
        } else {
          return mid - 1;
        }
      }
    }
    return -1;
  }
}
