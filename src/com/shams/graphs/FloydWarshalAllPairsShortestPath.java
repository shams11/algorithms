package com.shams.graphs;

public class FloydWarshalAllPairsShortestPath {

  private static final int MAX = Integer.MAX_VALUE;
  private static final int v = 6;

  public static void main(String[] args) {
    int[][] graph = {
        {0, 1, 4, MAX, MAX, MAX},
        {MAX, 0, 4, 2, 7, MAX},
        {MAX, MAX, 0, 3, 4, MAX},
        {MAX, MAX, MAX, 0, MAX, 4},
        {MAX, MAX, MAX, 3, 0, MAX},
        {MAX, MAX, MAX, MAX, 5, 0}
    };

    allPairsShortestPath(graph);
  }

  private static void allPairsShortestPath(int[][] graph) {
    // copy graph
    int[][] t = new int[v][v];
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++) {
        t[i][j] = graph[i][j];
      }
    }

    for (int k = 0; k < v; k++) {
      for (int i = 0; i < v; i++) {
        for (int j = 0; j < v; j++) {
          if (t[i][k] == MAX || t[k][j] == MAX) {
            continue;
          }
          if ((t[i][k] + t[k][j]) < t[i][j]) {
            t[i][j] = t[i][k] + t[k][j];
          }
        }
      }
    }

    //Check for negative edge weight cycle
    for (int i = 0; i < v; ++i) {
      if (t[i][i] < 0) {
        System.out.println("Negative edge weight cycle is present");
        return;
      }
    }

    //Print Shortest Path Graph
    //(Values printed as INT_MAX defines there is no path)
    for (int i = 0; i < v; ++i) {
      for (int j = 0; j < v; ++j) {
        System.out.println(i + " to " + j + " distance is " + t[i][j]);
      }
    }
  }
}
