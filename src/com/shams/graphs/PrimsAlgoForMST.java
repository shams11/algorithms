/**
 *
 */

package com.shams.graphs;

import java.util.Arrays;

public class PrimsAlgoForMST {

  private static final int v = 6;
  static int[] parent = new int[v];
  static boolean[] visited = new boolean[v];
  static int[] value = new int[v];

  public static void main(String[] args) {
    int[][] graph = {
        {0, 4, 6, 0, 0, 0},
        {4, 0, 6, 3, 4, 0},
        {6, 6, 0, 1, 8, 0},
        {0, 3, 1, 0, 2, 3},
        {0, 4, 8, 2, 0, 7},
        {0, 0, 0, 3, 7, 0}
    };
    findMst(graph);
  }

  /*
   * Step1 : select min value vertex, 0 in first case
   * step2 : mark the selected vertex as visited
   * step3 : for each neighbouring vertex,
   *   1. if edge is present (obviously edge will be present with neighbour)
   *   2. if neighbour is not visited
   *   3. if the edge cost is less than the neighbour vertex cost, the update the neighbour's cost
   *       and the parent of neighbour will be the vertex selected in step 1
   *   4. repeat this process for all the vertices
   * */
  private static void findMst(int[][] graph) {

    Arrays.fill(value, Integer.MAX_VALUE);
    //Assuming start point as Node-0
    parent[0] = -1;  //Start node has no parent
    value[0] = 0;  //start node has value=0 to get picked 1st
    for (int i = 0; i < v; i++) {
      int u = selectMinValueNotVisitedVertex(value, visited);
      visited[u] = true;
      for (int j = 0; j < v; j++) {
        if (graph[u][j] != 0 && !visited[j] && graph[u][j] < value[j]) {
          parent[j] = u;
          value[j] = graph[u][j];
        }
      }
    }
    //Print MST
    for (int i = 1; i < v; ++i)
      System.out.println("U->V: " + parent[i] + "->" + i + "  wt = " + graph[parent[i]][i]);
  }

  private static int selectMinValueNotVisitedVertex(int[] value, boolean[] visited) {
    int min = Integer.MAX_VALUE;
    int minVertex = -1;
    for (int i = 0; i < v; i++) {
      if (!visited[i] && value[i] < min) {
        minVertex = i;
        min = value[i];
      }
    }
    return minVertex;
  }
}
