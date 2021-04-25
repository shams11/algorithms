/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * https://www.youtube.com/watch?v=UK1SqJH3p_M&ab_channel=HackerHeap
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStops {

  public static void main(String[] args) {
//    int n = 3, src = 0, dst = 2, k = 1;
//    int[][] flights = {
//        {0, 1, 100},
//        {1, 2, 100},
//        {0, 2, 500}
//    };
    // Output: 200

    int n = 3, src = 0, dst = 2, k = 0;
    int[][] flights = {
        {0, 1, 100},
        {1, 2, 100},
        {0, 2, 500}
    };
  // Output: 500
    System.out.println(findCheapestPrice(n, flights, src, dst, k));
  }

  static class Node {
    int city;
    int cost;
    int stop;

    public Node(int city, int cost, int stop) {
      this.city = city;
      this.cost = cost;
      this.stop = stop;
    }
  }

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if (flights == null || flights.length == 0) return -1;

    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] f : flights) {
      if (!graph.containsKey(f[0])) {
        graph.put(f[0], new ArrayList<>());
      }
      graph.get(f[0]).add(new int[]{f[1], f[2]});
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
    pq.add(new Node(src, 0, -1));
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.city == dst) return cur.cost;
      List<int[]> neighbours = graph.getOrDefault(cur.city, new ArrayList<>());
      for (int[] neigh : neighbours) {
        if (cur.stop < K) {
          pq.add(new Node(neigh[0], cur.cost + neigh[1], cur.stop + 1));
        }
      }
    }
    return -1;
  }
}
