package com.shams.heap;

import com.shams.commons.UtilityHelper;
import java.util.PriorityQueue;

public class SortKSortedArray {
  public static void main(String[] args) {
    int[] a = {6, 5, 3, 2, 8, 10, 9};
    int k = 3;
    int[] b = sortKSortedArray(a, k);
    UtilityHelper.printArray(b);
  }

  private static int[] sortKSortedArray(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e1 - e2);
    for (int i = 0; i < k + 1; i++) {
      pq.add(a[i]);
    }
    int j = 0;
    for (int i = k + 1; i < a.length; i++) {
      a[j++] = pq.poll();
      pq.add(a[i]);
    }

    while (pq.size() > 0) {
      a[j++] = pq.poll();
    }
    return a;
  }
}
