/**
 * https://leetcode.com/problems/critical-connections-in-a-network/submissions/
 * https://www.youtube.com/watch?v=HsBefuOqkd4&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=34&ab_channel=TECHDOSE
 * */
package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TarjansFindBridges {
  public static void main(String[] args) {
    int[][] graph = {
        {0, 2},
        {2, 0},
        {0, 3},
        {3, 0},
        {1, 0},
        {0, 1},
        {2, 1},
        {1, 2},
        {3, 4},
        {4, 3},
    };
    // Output : [[3, 4], [0, 3]]

//    int[][] graph = {
//        {1, 0},
//        {2, 0},
//        {3, 2},
//        {4, 2},
//        {4, 3},
//        {3, 0},
//        {4, 0}
//    };
    // Output : [[0,1]]
    int n = 5;
    System.out.println(findBridges(n, graph));
  }

  private static final int v = 5;
  static int[] disc = new int[v];
  static int[] low = new int[v];
  static int[] parent = new int[v];

  private static List<List<Integer>> findBridges(int n, int[][] graph) {
    buildGraph(n, graph);
    System.out.println(map);
    Arrays.fill(disc, -1);
    Arrays.fill(low, -1);
    Arrays.fill(parent, -1);

    for (int i = 0; i < v; i++) {
      if (disc[i] == -1) {
        dfs(i);
      }
    }
    return result;
  }

  static int time = 0;

  static List<List<Integer>> result = new ArrayList<>();

  private static void dfs(int u) {
    disc[u] = low[u] = time;
    time++;
    List<Integer> neighbors = map.getOrDefault(u, new ArrayList<>());
    for (int v : neighbors) {
      if (disc[v] == -1) {
        parent[v] = u;
        dfs(v);
        low[u] = Math.min(low[u], low[v]);

        if (low[v] > disc[u]) {
          List<Integer> list = new ArrayList<>();
          list.add(u);
          list.add(v);
          result.add(list);
        }
      } else if (v != parent[u]) {
        low[u] = Math.min(low[u], disc[v]);
      }
    }
  }

  static Map<Integer, List<Integer>> map = new HashMap<>();

  private static void buildGraph(int n, int[][] graph) {
    for(int i = 0; i < n; i++) {
      map.put(i, new ArrayList<>());
    }
    for (int[] e : graph) {
      map.get(e[0]).add(e[1]);
      map.get(e[1]).add(e[0]);
    }
  }
}
