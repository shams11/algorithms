/**
 * https://www.youtube.com/watch?v=eTaWFhPXPz4&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=16&ab_channel=TECHDOSE
 */

package com.shams.graphs;

import java.util.Arrays;

public class DisjointSet {
  public static void main(String[] args) {
    int v = 4;
    int[][] edges = {
        {0, 1},
        {0, 3},
        {2, 3}
    };
    System.out.println(disjointSet(v, edges));
  }

  static int[] parent;

  private static boolean disjointSet(int v, int[][] edges) {
    parent = new int[v];
    Arrays.fill(parent, -1);
    if (isCycle(edges)) {
      return true;
    }
    return false;
  }

  private static boolean isCycle(int[][] edges) {
    for (int[] e : edges) {
      int fromParent = find(e[0]);
      int toParent = find(e[1]);
      // if absolute parent of these 2 nodes are same, then they are in the same set
      // and there is already one edge exists between them. so return true here
      // else if we add a path, then it will create a cycle
      if (fromParent == toParent) {
        return true;
      }
      // As there is no edge between e[0] and e[1], then create a edge between the parents
      // of these 2 nodes, so that it becomes set
      parent[fromParent] = toParent;
    }
    return false;
  }

  private static int find(int v) {
    if (parent[v] == -1) {
      return v;
    }
    return find(parent[v]);
  }
}
