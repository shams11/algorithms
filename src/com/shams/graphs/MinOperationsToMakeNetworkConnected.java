/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/
 * https://www.youtube.com/watch?v=3JIwIRir2sM&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=35&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinOperationsToMakeNetworkConnected {
  public static void main(String[] args) {
    int n = 6;
    int[][] graph = {{0, 1}, {0, 2}, {0,3}, {1, 2}, {1, 3}};
//    Input: n = 4, connections = [[0,1],[0,2],[1,2]]
//    Output: 1
//    Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

    System.out.println(makeConnected(n, graph));
  }

  static Map<Integer, List<Integer>> map = new HashMap<>();
  static boolean[] visited;

  public static int makeConnected(int n, int[][] connections) {
    // if # of edges less than equal to n-2, then not enough cables
    // max diff should be atmost 1.
    if (connections.length < n - 1) return -1;

    buildGraph(n, connections);
    visited = new boolean[n];
    int components = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        components++;
        dfs(i);
      }
    }
    // Redundant edges = Total edges - (( n-1) - (c - 1)) // c : # no of components in the graph
    // Total edges = connections.length
    // c components required (n-1) edges. i.e 2 components required 1 edge.
    // so reduce required edges for the existing components. Remaining will be redundant edges
    int redundant = connections.length - ((n - 1) - (components - 1));
    if (redundant >= (components - 1)) {
      return components - 1;
    }
    return -1;
  }

  private static void dfs(int u) {
    visited[u] = true;
    List<Integer> neighbors = map.getOrDefault(u, new ArrayList<>());
    for (int v : neighbors) {
      if (!visited[v]) {
        dfs(v);
      }
    }
  }

  private static void buildGraph(int n, int[][] connections) {
    for (int i = 0; i < n; i++) {
      map.put(i, new ArrayList<>());
    }
    for (int[] c : connections) {
      map.get(c[0]).add(c[1]);
      map.get(c[1]).add(c[0]);
    }
  }

  // This was my first approach

//  static Map<Integer, List<Integer>> map = new HashMap<>();
//  static int[] disc;
//  static int[] low;
//  static int[] parent;
//  static int time = 0;
//
//  public static int makeConnected(int n, int[][] connections) {
//    // if # of edges less than n-2, then not enough cables
//    if (connections.length < n - 2) return -1;
//
//    buildGraph(n, connections);
//    System.out.println(map);
//    disc = new int[n];
//    low = new int[n];
//    parent = new int[n];
//    Arrays.fill(disc, -1);
//    Arrays.fill(low, -1);
//    Arrays.fill(parent, -1);
//    for (int i = 0; i < n; i++) {
//      if (disc[i] == -1) {
//        dfs(i);
//      }
//    }
//    int count = 0;
//    for (int i : disc) {
//      if (i == -1) count++;
//    }
//    return count;
//  }
//
//  private static void dfs(int u) {
//    disc[u] = low[u] = time;
//    time++;
//    List<Integer> neighbors = map.getOrDefault(u, new ArrayList<>());
//    if (neighbors.size() == 0) {
//      disc[u] = -1;
//      low[u] = -1;
//      return;
//    }
//    for (int v : neighbors) {
//      if (disc[v] == -1) {
//        parent[v] = u;
//        dfs(v);
//        low[u] = Math.min(low[u], low[v]);
//      } else if (v != parent[u]) {
//        low[u] = Math.min(low[u], disc[v]);
//      }
//    }
//  }
//
//  private static void buildGraph(int n, int[][] connections) {
//    for (int i = 0; i < n; i++) {
//      map.put(i, new ArrayList<>());
//    }
//    for (int[] c : connections) {
//      map.get(c[0]).add(c[1]);
//      map.get(c[1]).add(c[0]);
//    }
//  }
}
