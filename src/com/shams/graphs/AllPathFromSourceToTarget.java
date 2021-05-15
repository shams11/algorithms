/**
 * https://www.youtube.com/watch?v=CYnvDzMprdc&ab_channel=MichaelMuinos
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathFromSourceToTarget {
  public static void main(String[] args) {
    int[][] graph = {
        {4, 3, 1},
        {3, 2, 4},
        {3},
        {4},
        {}
    };
    // Output : [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    System.out.println(allPathsSourceTarget(graph));
  }


  static List<List<Integer>> result = new ArrayList<>();

  public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    Queue<List<Integer>> q = new LinkedList<>();
    q.add(Arrays.asList(0));
    while (!q.isEmpty()) {
      List<Integer> curList = q.poll();
      Integer lastNode = curList.get(curList.size() - 1);
      if (lastNode == graph.length - 1) {
        result.add(curList);
      } else {
        int[] neighbors = graph[lastNode];
        for (int n : neighbors) {
          List<Integer> newList = new ArrayList<>(curList);
          newList.add(n);
          q.add(newList);
        }
      }
    }
    return result;
  }
}


/*
  // My initial approach didn't work
   List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for(int n : graph[0]) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            dfs(n, n, graph, list);
            //result.add(list);

        }
        return result;
    }

    void dfs(int u, int parentNode, int[][] graph, List<Integer> list) {
        list.add(u);
        if(u == graph.length-1) {
            result.add(list);
            return;
        }
        for(int n : graph[u]) {
            dfs(n, parentNode, graph, list);
            if(u == parentNode) {
                list = new ArrayList<>();
                list.add(0);
                list.add(parentNode);
            }
        }
    }
  * */
