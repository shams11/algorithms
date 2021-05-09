/**
 * https://www.youtube.com/watch?v=Rs6DXyWpWrI&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=27&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class KosaRajuStronglyConnectedComponents {
  private static final int v = 8;

  public static void main(String[] args) {
    int[][] graph = {
        {0, 1},
        {1, 2},
        {2, 0},
        {2, 3},
        {3, 4},
        {4, 5},
        {4, 7},
        {5, 6},
        {6, 4},
        {6, 7}
    };
    System.out.println(kosaRajuStroinglyConnectedComponents(graph));
  }

  static Map<Integer, List<Integer>> map = new HashMap<>();
  static Stack<Integer> s = new Stack<>();
  static boolean[] visited = new boolean[v];

  private static List<List<Integer>> kosaRajuStroinglyConnectedComponents(int[][] graph) {
    buildGraph(graph);
    dfs();
    reverseEdges(graph);
    Arrays.fill(visited, false);
    return popStackAndApplyDfs();
  }

  private static List<List<Integer>> popStackAndApplyDfs() {
    List<List<Integer>> result = new ArrayList<>();
    while (!s.isEmpty()) {
      int cur = s.pop();
      List<Integer> list = new ArrayList<>();
      if (!visited[cur]) {
        dfsOnReverseGraph(cur, list);
      }
      if (list.size() != 0) {
        result.add(list);
      }
    }
    return result;
  }

  private static void dfsOnReverseGraph(int cur, List<Integer> list) {
    list.add(cur);
    visited[cur] = true;
    List<Integer> neighbours = reverseMap.getOrDefault(cur, new ArrayList<>());
    for (Integer n : neighbours) {
      if (!visited[n]) {
        dfsOnReverseGraph(n, list);
      }
    }
  }

  static Map<Integer, List<Integer>> reverseMap = new HashMap<>();

  private static void reverseEdges(int[][] graph) {
    for (int[] e : graph) {
      if (!reverseMap.containsKey(e[1])) {
        reverseMap.put(e[1], new ArrayList<>());
      }
      reverseMap.get(e[1]).add(e[0]);
    }
  }


  private static void dfs() {
    for (int i = 0; i < v; i++) {
      if (!visited[i]) {
        dfsUtil(i);
      }
    }
  }

  private static void dfsUtil(int u) {
    visited[u] = true;
    List<Integer> neighbors = map.getOrDefault(u, new ArrayList<>());
    for (Integer n : neighbors) {
      if (!visited[n]) {
        dfsUtil(n);
      }
    }
    s.push(u);
  }

  private static void buildGraph(int[][] graph) {
    for (int[] e : graph) {
      if (!map.containsKey(e[0])) {
        map.put(e[0], new ArrayList<>());
      }
      map.get(e[0]).add(e[1]);
    }
  }
}
