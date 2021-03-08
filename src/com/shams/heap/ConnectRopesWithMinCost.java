/**
 * https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 * https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=10&ab_channel=AdityaVerma
 */

package com.shams.heap;

import java.util.PriorityQueue;

public class ConnectRopesWithMinCost {
  public static void main(String[] args) {
    int[] a = {4, 2, 3, 6};
    System.out.println(minCost(a));
  }

  private static int minCost(int[] a) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> {
      return e1 - e2;
    });

    for (int value : a) {
      pq.add(value);
    }

    int cost = 0;
    int curCost = 0;
    while (!pq.isEmpty()) {
      int rope1 = pq.poll();
      int rope2 = pq.poll();
      curCost = rope1 + rope2;
      cost += curCost;
      if (!pq.isEmpty()) {
        pq.add(curCost);
      } else {
        break;
      }
    }
    return cost;
  }
}
