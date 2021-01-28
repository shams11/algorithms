package com.shams.searching;

import com.shams.commons.UtilityHelper;

public class BinarySearch {

  public static void main(String[] args) {
    int[] a1 = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    UtilityHelper.printArray(a1);
    System.out.println("After sorting");
    int x = 56;
    int index = binarySearch(a1, 0, a1.length - 1, x);
    System.out.println(String.format(" %s is present at %s index ", x, index));
  }

  private static int binarySearch(int[] a, int l, int r, int x) {
    if (l <= r) {
      int mid = (l + r) / 2;
      if (a[mid] == x)
        return mid;
      if (x < a[mid])
        return binarySearch(a, l, mid - 1, x);
      else
        return binarySearch(a, mid + 1, r, x);
    }
    return -1;
  }
}
