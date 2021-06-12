/***
 * https://leetcode.com/problems/possible-bipartition/submissions/
 * https://www.youtube.com/watch?v=0ACfAqs8mm0&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=8&ab_channel=TECHDOSE
 * */

package com.shams.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/***
 * A bipartite graph, also called a bigraph, is a set of graph vertices decomposed into two disjoint
 * sets such that no two graph vertices within the same set are adjacent.
 *
 * Algorithm
 * ---------
 * 1. Build Graph (build Map)
 * 2. Have a colour array, initialized to -1
 * 3. for each person in the loop, apply bfs
 * 4. Assign colour 1 to parent and color 1 - color[parent] to child.
 *    that means no 2 parent child will have same color
 * 5. if parent/child has same color then return false
 * */
public class BipartiteGraph {

  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) {
//    int N = 4;
//    int[][] a = {
//        {1, 2},
//        {1, 3},
//        {2, 4}
//    };
//    Output: true
//    Explanation: group1 [1,4], group2 [2,3]
//
//    int N = 3;
//    int[][] a = {
//        {1, 2},
//        {1, 3},
//        {2, 3}
//    };
//   Output: false

    int N = 5;
    int[][] a = {
        {1, 2},
        {2, 3},
        {3, 4},
        {4, 5},
        {1, 5}
    };
    // Output: false
    System.out.println(possibleBiPartition(N, a));
  }

  public static boolean possibleBiPartition(int N, int[][] dislikes) {
    if (N == 1) return true;

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] d : dislikes) {
      if (!map.containsKey(d[0])) {
        map.put(d[0], new ArrayList<>());
      }
      map.get(d[0]).add(d[1]);
    }

    int[] colours = new int[N + 1];
    Arrays.fill(colours, -1);
    // Apply BFS
    for (int i = 1; i <= N; i++) {
      if (colours[i] == -1) {
        if (!isBiPartite(i, N, map, colours)) {
          return false;
        }
      }
    }
    return true;
  }

  // There are 2 colours {0, 1}. if the colour of a cur vertex is 1,
  // then 1 - colour[curVertex] will diff colour to its neighbour
  static boolean isBiPartite(int s, int N, Map<Integer, List<Integer>> map, int[] colours) {
    colours[s] = 1;
    q.add(s);
    while (!q.isEmpty()) {
      s = q.poll();
      for (Integer u : map.getOrDefault(s, new ArrayList<>())) {
        if (colours[u] == colours[s]) {
          return false;
        }
        if (colours[u] == -1) {
          colours[u] = 1 - colours[s]; // give diff colour to neighbour
          q.add(u);
        }
      }
    }
    return true;
  }
}
