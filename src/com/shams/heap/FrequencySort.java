/***
 * https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8&ab_channel=AdityaVerma
 * */

package com.shams.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

  static class Pair {
    int freq;
    int arrayEle;

    public Pair(int value, Integer key) {
      this.freq = value;
      this.arrayEle = key;
    }
  }

  public static void main(String[] args) {
    int[] a = {2, 5, 2, 8, 5, 6, 8, 8};
    frequencySort(a);
  }

  private static void frequencySort(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : a) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((e1, e2) -> {
      int frequency1 = e1.freq;
      int frequency2 = e2.freq;
      return frequency2 - frequency1;
    });
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      pq.add(new Pair(e.getValue(), e.getKey()));
    }
    while (!pq.isEmpty()) {
      int freq = pq.peek().freq;
      int arrayElement = pq.peek().arrayEle;
      for (int i = 0; i < freq; i++) {
        System.out.print(arrayElement + " ");
      }
      pq.poll();
    }
  }
}
