/**
 * https://www.youtube.com/watch?v=64KK9K4RpKE&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=28&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticulationPointsUsingTarjansAlgo {
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
        {4, 3}
    };
    System.out.println(findArticulationPoints(graph));
  }

  static int v = 5;
  static int[] parent = new int[v];
  static int[] disc = new int[v];
  static int[] low = new int[v];

  private static List<Integer> findArticulationPoints(int[][] graph) {
    buildGraph(graph);
    Arrays.fill(parent, -1);
    Arrays.fill(disc, -1);
    Arrays.fill(low, -1);
    for (int i = 0; i < v; i++) {
      if (disc[i] == -1) {
        dfs(i);
      }
    }
    return result;
  }

  static List<Integer> result = new ArrayList<>();
  static int time = 0;

  private static void dfs(int u) {
    disc[u] = low[u] = time;
    int children = 0;
    List<Integer> neighbors = map.getOrDefault(u, new ArrayList<>());
    for (int v : neighbors) {
      if (disc[v] == -1) {
        children++;
        parent[v] = u;
        dfs(v);
        low[u] = Math.min(low[u], low[v]);

        // u is root
        if (parent[u] == -1 && children > 1) {
          result.add(u);
        }
        // Case-2: if current node is not parent, if the current node is removed then
        // sub-graph/sub child will become separate component. its low time will be definitely
        // greater than discovery time of its parent
        if (parent[u] != -1 && low[v] >= disc[u]) {
          result.add(u);
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
