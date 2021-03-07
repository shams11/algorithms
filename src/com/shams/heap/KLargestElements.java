package com.shams.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {
  public static void main(String[] args) {
    int[] a = {7, 10, 4, 3, 20, 15};
    int k = 3;
    System.out.println(kLargestElements(a, k));
  }

  private static List<Integer> kLargestElements(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e1 - e2);
    for(int i : a) {
      pq.add(i);
      if(pq.size() > k) {
        pq.poll();
      }
    }
    List<Integer> list = new ArrayList<>();
    while(!pq.isEmpty()) {
      list.add(pq.poll());
    }
    Collections.reverse(list);
    return list;
  }
}
