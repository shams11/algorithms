/**
 * https://leetcode.com/problems/network-delay-time/submissions/
 * https://www.youtube.com/watch?v=YHx6r9pM5e0&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=31&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTImeUsingDijkstras {

  /***
   * This is almost same as cheapest flights
   * https://leetcode.com/problems/cheapest-flights-within-k-stops/
   * */
  public static void main(String[] args) {
    int[][] graph = {
        {2, 1, 1},
        {2, 3, 1},
        {3, 1, 4},
        {3, 4, 1}
    };
    int n = 4, k = 2;

//    int[][] graph = {
//        {1, 2, 1},
//        {2, 3, 2},
//        {1, 3, 4}
//    };
//    int n = 3, k = 1;
    System.out.println(networkDelayTime(graph, n, k));
  }

  static public int networkDelayTime(int[][] times, int n, int k) {
    boolean[] visited = new boolean[n + 1];
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    buildGraph(times);
    if (!map.containsKey(k)) {
      return -1;
    }
    bfs(k, dist);
    int timeToSendSignalToAllNodes = Integer.MIN_VALUE;
    for (int i = 1; i < dist.length; i++) {
      {
        if (dist[i] == Integer.MAX_VALUE) {
          return -1;
        }
        timeToSendSignalToAllNodes = Math.max(timeToSendSignalToAllNodes, dist[i]);
      }
    }
    return timeToSendSignalToAllNodes;
  }

  private static void buildGraph(int[][] times) {
    for (int[] t : times) {
      if (!map.containsKey(t[0])) {
        map.put(t[0], new ArrayList<>());
      }
      map.get(t[0]).add(new int[]{t[1], t[2]});
    }
  }

  static Map<Integer, List<int[]>> map = new HashMap<>();
  static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

  static class Node {
    int val;
    int cost;

    public Node(int val, int cost) {
      this.val = val;
      this.cost = cost;
    }
  }

  private static void bfs(int src, int[] dist) {
    pq.add(new Node(src, 0));
    dist[src] = 0;
    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      List<int[]> neighbors = map.getOrDefault(cur.val, new ArrayList<>());
      for (int[] v : neighbors) {
        int dstNode = v[0];
        int timeForDstNode = v[1];
        int newCost = cur.cost + timeForDstNode;
        if (newCost < dist[dstNode]) {
          dist[dstNode] = newCost;
          pq.add(new Node(dstNode, newCost));
        }
      }
    }
  }
}

