/**
 * https://leetcode.com/problems/shortest-bridge/
 * https://www.youtube.com/watch?v=3Yz-IDSpm-E&ab_channel=ApoorvaDave
 */

package com.shams.graphs;

import java.util.HashSet;
import java.util.Set;

public class ShortestBridgeUsingFloodFill {
  public static void main(String[] args) {
//    int[][] a = {
//        {0, 1},
//        {1, 0}
//    };
    // Output : 1
    int[][] a = {
        {0, 1, 0},
        {0, 0, 0},
        {0, 0, 1}
    };
    // Output : 2
    System.out.println(shortestBridge(a));
  }

  static Set<Integer> set1 = new HashSet<>();
  static Set<Integer> set2 = new HashSet<>();

  public static int shortestBridge(int[][] A) {
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
