package com.shams.graphs;

import static com.shams.commons.UtilityHelper.getNeighbours;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUnDirectedGraph {
  public static void main(String[] args) {
    int[][] a = {
        {0, 1, 1, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 1},
        {0, 0, 1, 0}
    };
    System.out.println(isCycleDetected(a));
  }

  private static boolean isCycleDetected(int[][] a) {
    int[] visited = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      visited[i] = 1;
      List<Integer> neighbours = getNeighbours(i, a);
      for (Integer u : neighbours) {
        int[] newVisited = Arrays.copyOf(visited, visited.length);
        if (isCyclePresent(u, a, newVisited)) {
          return true;
        }
      }
      visited[i] = 0;
    }
    return false;
  }

  private static boolean isCyclePresent(Integer u, int[][] a, int[] visited) {

    if (visited[u] == 2) return true;
    visited[u] = 1;

    List<Integer> neighbours = getNeighbours(u, a);
    for (Integer n : neighbours) {
      if (visited[n] == 1) {
        visited[n] = 2;
      } else {
        if (isCyclePresent(n, a, visited)) {
          return true;
        }
      }
    }
    return false;
  }
}
