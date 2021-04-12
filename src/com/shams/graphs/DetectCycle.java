package com.shams.graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {

  public static void main(String[] args) {
    int[][] a = {
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0},
    };
    System.out.println(isCycleDetected(a));
  }

  private static boolean isCycleDetected(int[][] a) {
    boolean[] visited = new boolean[a.length];
    for (int i = 0; i < a.length; i++) {
      visited[i] = true;
      List<Integer> neighbours = getNeighbours(i, a);
      for (Integer u : neighbours) {
        if (isCycleUtil(u, a, visited)) {
          return true;
        }
      }
      visited[i] = false;
    }
    return false;
  }

  private static boolean isCycleUtil(Integer v, int[][] a, boolean[] visited) {
    if (visited[v]) {
      return true;
    }
    visited[v] = true;
    List<Integer> neighbours = getNeighbours(v, a);
    for (Integer u : neighbours) {
      if (isCycleUtil(u, a, visited)) {
        return true;
      }
    }
    visited[v] = false;
    return false;
  }

  private static List<Integer> getNeighbours(Integer v, int[][] a) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (a[v][i] == 1) {
        list.add(i);
      }
    }
    return list;
  }
}
