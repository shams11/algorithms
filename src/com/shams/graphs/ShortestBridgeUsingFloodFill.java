/**
 * https://leetcode.com/problems/shortest-bridge/
 * https://www.youtube.com/watch?v=3Yz-IDSpm-E&ab_channel=ApoorvaDave
 */

package com.shams.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestBridgeUsingFloodFill {
  public static void main(String[] args) {
//    int[][] a = {
//        {0, 1},
//        {1, 0}
//    };
    // Output : 1
//    int[][] a = {
//        {0, 1, 0},
//        {0, 0, 0},
//        {0, 0, 1}
//    };
    // Output : 2
    int[][] a = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1}
    };
    // Output : 1
    System.out.println(shortestBridge(a));
  }


  /**
   * Use DFS + BFS to solve this WONDERFUL problem!
   * Step 1: use DFS to mark the first island to another number
   * Step 2: start from the first island, doing BFS level order traversal to find number of bridges (levels)
   * until reach the second island
   * */
  
  static Queue<Integer> q = new LinkedList<>();

  public static int shortestBridge(int[][] A) {
    if (A == null || A.length == 0) return 0;

    int m = A.length;
    int n = A[0].length;
    boolean foundIsland = false;
    for (int i = 0; i < m; i++) {
      if (foundIsland) {
        break;
      }
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1) {
          dfs(A, i, j);
          foundIsland = true;
          break;
        }
      }
    }
    return bfs(A);
  }

  static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private static int bfs(int[][] a) {
    int depth = 0;
    int n = a[0].length;
    int m = a.length;
    while (!q.isEmpty()) {
      int qSize = q.size();
      for (int i = 0; i < qSize; i++) {
        int index = q.poll();
        int x = index / n;
        int y = index % n;
        for (int[] d : DIRECTIONS) {
          int x1 = d[0] + x;
          int y1 = d[1] + y;
          if (x1 > -1 && y1 > -1 && x1 < m && y1 < n && a[x1][y1] != 2) {
            if (a[x1][y1] == 1) return depth;
            q.add(x1 * n + y1);
            a[x1][y1] = 2;
          }
        }
      }
      ++depth;
    }
    return -1;
  }

  private static void dfs(int[][] a, int i, int j) {
    if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0 || a[i][j] == 2) {
      return;
    }

    a[i][j] = 2;
    q.add(i * a[0].length + j);
    dfs(a, i - 1, j);
    dfs(a, i + 1, j);
    dfs(a, i, j - 1);
    dfs(a, i, j + 1);
  }




  // 2nd approach
  static Set<Integer> set1 = new HashSet<>();
  static Set<Integer> set2 = new HashSet<>();

  public static int shortestBridge1(int[][] A) {
    int m = A.length;
    int n = A[0].length;

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 0) continue;
        if (A[i][j] == 1) {

          if (count == 0) {
            ++count;
            fillSet(A, i, j, m, n, set1);
          } else if (count == 1) {
            ++count;
            fillSet(A, i, j, m, n, set2);
          } else {
            break;
          }
        }
      }
    }
    System.out.println("set 1 :" + set1);
    System.out.println("set 2 :" + set2);
    return findMinDistance(set1, set2, n);
  }

  static int findMinDistance(Set<Integer> set1, Set<Integer> set2, int n) {
    int min = Integer.MAX_VALUE;
    for (int i : set1) {
      for (int j : set2) {
        int x1 = i / n;
        int y1 = i % n;

        int x2 = j / n;
        int y2 = j % n;
        int ans = Math.abs(x1 - x2) + Math.abs(y1 - y2) - 1;
        min = Math.min(min, ans);
      }
    }
    return min;
  }

  static void fillSet(int[][] A, int i, int j, int m, int n, Set<Integer> set) {

    if (i < 0 || j < 0 || i >= m || j >= n || A[i][j] == 0) return;
    A[i][j] = 0;  // to avoid infinite loop
    set.add(i * n + j); // capture co-ordinates of 1's in the grid
    fillSet(A, i, j - 1, m, n, set); // left
    fillSet(A, i, j + 1, m, n, set); // right
    fillSet(A, i - 1, j, m, n, set); // top
    fillSet(A, i + 1, j, m, n, set); // down
  }
}
