package com.shams.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KahnsAlgorithmForFindingCycleInGraph {
  public static void main(String[] args) {
    int[][] prerequisites = {
        {3, 0},
        {3, 2},
        {4, 0},
        {4, 1},
        {5, 0},
        {5, 3},
        {2, 1}
    };
    int numCourses = 6;
    System.out.println(findOrder(numCourses, prerequisites));
  }

  static Map<Integer, List<Integer>> map = new HashMap<>();
  static int[] indegree;
  static Queue<Integer> q = new LinkedList<>();

  private static List<Integer> findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0)
      return List.of();

    // step 1 : build graph
    buildGraph(numCourses, prerequisites);
    // step 2 : push nodes with indegree 0 to queue
    pushNodesWIthIndegreeZeroToQueue();
    //step 3 apply BFS
    return applyBFS(numCourses);
  }

  private static List<Integer> applyBFS(int numCourses) {

    int count = 0;
    List<Integer> result = new ArrayList<>();
    while (!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> neighbors = map.getOrDefault(cur, new ArrayList<>());
      for (int n : neighbors) {
        indegree[n]--;
        if (indegree[n] == 0) {
          q.add(n);
        }
      }
      count++;
      result.add(cur);
    }
    if (count == numCourses) {
      System.out.println("No cycle");
    } else {
      System.out.println("Cycle is present");
    }
    return result;
  }

  private static void pushNodesWIthIndegreeZeroToQueue() {
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
  }

  private static void buildGraph(int numCourses, int[][] prerequisites) {
    indegree = new int[numCourses];
    for (int[] pr : prerequisites) {
      if (!map.containsKey(pr[0])) {
        map.put(pr[0], new ArrayList<>());
      }
      indegree[pr[1]]++;
      map.get(pr[0]).add(pr[1]);
    }
  }
}
