/***
 * https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8&ab_channel=AdityaVerma
 * */

package com.shams.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

  public static void main(String[] args) {
    int[] a = {2, 5, 2, 8, 5, 6, 8, 8};
    frequencySort(a);
  }

  private static void frequencySort(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : a) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> {
      int frequency1 = map.get(e1);
      int frequency2 = map.get(e2);
      return frequency2 - frequency1;
    });

    pq.addAll(map.keySet());

    while (!pq.isEmpty()) {
      int freq = map.get(pq.peek());
      int arrayElement = pq.peek();
      for (int i = 0; i < freq; i++) {
        System.out.print(arrayElement + " ");
      }
      pq.poll();
    }
  }
}
