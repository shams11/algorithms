/**
 * https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7&ab_channel=AdityaVerma
 * https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1
 */

package com.shams.heap;

import java.util.*;

public class TopKFrequentNumbers {

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
    int k = 2;
    System.out.println(topkFrequentNumbers(a, k));
  }

  private static List<Integer> topkFrequentNumbers(int[] a, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : a) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((e1, e2) -> {
      int frequency1 = map.get(e1);
      int frequency2 = map.get(e2);
      return frequency1 - frequency2;
    });
    for (Integer e : map.keySet()) {
      pq.add(e);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    LinkedList<Integer> list = new LinkedList<>();
    while (!pq.isEmpty()) {
      list.addFirst(pq.poll());
    }
    return list;
  }
}
