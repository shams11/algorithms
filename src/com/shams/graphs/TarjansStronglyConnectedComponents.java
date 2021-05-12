/**
 * https://www.youtube.com/watch?v=ZeDNSeilf-Y&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=27&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TarjansStronglyConnectedComponents {

  private static final int v = 7;

  public static void main(String[] args) {

    int[][] graph = {
        {0, 1},
        {1, 2},
        {1, 3},
        {3, 4},
        {4, 0},
        {4, 5},
        {4, 6},
        {5, 6},
        {6, 5}
    };

    System.out.println(tarjans(graph));
  }

  static Map<Integer, List<Integer>> map = new HashMap<>();
  static Stack<Integer> s = new Stack<>();
  static int[] disc = new int[v];
  static int[] low = new int[v];
  static boolean[] presentInStack = new boolean[v];

  private static List<List<Integer>> tarjans(int[][] graph) {
    buildGraph(graph);
    Arrays.fill(disc, -1);
    Arrays.fill(low, -1);
    for (int i = 0; i < v; i++) {
      if (disc[i] == -1) {
        dfs(i);
      }
    }
    return result;
  }

  static int time = 0;
  static List<Integer> list;
  static List<List<Integer>> result = new ArrayList<>();

  private static void dfs(int u) {
    // low time of current node => Node with lowest discovery time accessible from the current node
    disc[u] = low[u] = time;
    s.push(u);
    presentInStack[u] = true;
    time++;
    List<Integer> neighbors = map.getOrDefault(u, new ArrayList<>());
    for (int v : neighbors) {
      if (disc[v] == -1) {
        dfs(v);
        // tree edge (parent - child edge)
        low[u] = Math.min(low[u], low[v]);
      } else if (presentInStack[v]) {
        // back-edge (edge from child to one of the ancestor of parent)
        // We need to maintain the earliest possible node which is accessible from the
        // current node, which will indicate the back edge
        low[u] = Math.min(low[u], disc[v]);
      }
    }

    // Root of component => if both disc and low time of a node is same
    if (disc[u] == low[u]) {
      list = new ArrayList<>();
      while (s.peek() != u) {
        list.add(s.peek());
        presentInStack[s.peek()] = false;
        s.pop();
      }

      presentInStack[s.peek()] = false;
      list.add(s.peek());
      result.add(list);
      s.pop();
    }
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
