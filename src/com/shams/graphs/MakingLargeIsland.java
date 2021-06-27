/**
 * https://www.youtube.com/watch?v=_426VVOB8Vo&ab_channel=MichaelMuinos
 * https://leetcode.com/problems/making-a-large-island/submissions/
 */

package com.shams.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingLargeIsland {
  public static void main(String[] args) {

//    int[][] a = {
//        {1, 0},
//        {0, 1}
//    };
    int[][] a = {
        {0, 1, 0, 1, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 1, 1, 0}
    };
    // Output = 6
    System.out.println(largestIsland(a));
  }

  static int[][] DIRECTIONS = {
      {0, -1}, {0, 1}, {-1, 0}, {1, 0}
  };

  // Optimized approach
  public static int largestIsland(int[][] a) {
    if (a == null || a.length == 0) return 0;
    int m = a.length;
    int n = a[0].length;
    int islandId = 2;
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 1) {
          int count = getIslandCount(a, i, j, islandId);
          max = Math.max(max, count);
          map.put(islandId++, count);
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 0) {
          Set<Integer> set = new HashSet<>();
          for (int[] d : DIRECTIONS) {
            int x = d[0] + i;
            int y = d[1] + j;
            if (x > -1 && x < m && y > -1 && y < n && a[x][y] != 0) {
              set.add(a[x][y]);
            }
          }
          int sum = 1;
          for (Integer k : set) {
            sum += map.get(k);
          }
          max = Math.max(max, sum);
        }
      }
    }
    return max;
  }

  private static int getIslandCount(int[][] a, int i, int j, int islandId) {
    if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] != 1) return 0;
    a[i][j] = islandId;
    int left = getIslandCount(a, i, -1 + j, islandId);
    int right = getIslandCount(a, i, 1 + j, islandId);
    int up = getIslandCount(a, -1 + i, j, islandId);
    int down = getIslandCount(a, 1 + i, j, islandId);
    return left + right + up + down + 1;
  }
}
