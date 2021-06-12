/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * https://www.youtube.com/watch?v=ymxPZk7TesQ&ab_channel=MichaelMuinosMichaelMuinos
 */

package com.shams.graphs;

import java.util.HashSet;
import java.util.Set;

public class CountComponentsInGraph {
  public static void main(String[] args) {
    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
     * (each edge is a pair of nodes), write a function to
     * find the number of connected components in an undirected graph.
     *
     * Example 1:
     *      0          3
     *      |          |
     *      1 --- 2    4
     * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
     *
     * Example 2:
     *      0           4
     *      |           |
     *      1 --- 2 --- 3
     * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
     *
     * Note:
     * You can assume that no duplicate edges will appear in edges.
     * Since all edges are undirected, [0, 1] is the same as [1, 0]
     * and thus will not appear together in edges.
     *
     * */
    int n = 5;
//    int[][] edges = {
//        {0, 1},
//        {1, 2},
//        {3, 4}
//    };

    int[][] edges = {
        {0, 1},
        {1, 2},
        {2, 3},
        {3, 4}
    };
    // Output : 1
    System.out.println(countComponents(n, edges));
  }

  private static int countComponents(int n, int[][] edges) {
    int[] parent = new int[n];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    for (int[] e : edges) {
      union(e[0], e[1], parent);
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == i) {
        set.add(i);
      }
    }
    return set.size();
  }

  private static void union(int e1, int e2, int[] parent) {
    int parentE1 = find(e1, parent);
    int parentE2 = find(e2, parent);
    parent[parentE1] = parentE2;
  }

  private static int find(int v, int[] parent) {
    if (parent[v] != v) parent[v] = find(parent[v], parent);
    return parent[v];
  }
}
