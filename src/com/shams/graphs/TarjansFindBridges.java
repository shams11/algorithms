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
    System.out.println(findBridges(graph));
  }

  private static final int v = 5;
  static int[] disc = new int[v];
  static int[] low = new int[v];
  static int[] parent = new int[v];

  private static List<List<Integer>> findBridges(int[][] graph) {
    buildGraph(graph);
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

  private static void buildGraph(int[][] graph) {
    for (int[] e : graph) {
      if (!map.containsKey(e[0])) {
        map.put(e[0], new ArrayList<>());
      }
      map.get(e[0]).add(e[1]);
    }
  }
}
