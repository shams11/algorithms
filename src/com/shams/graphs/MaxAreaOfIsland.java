/**
 * https://www.youtube.com/watch?v=JP39wU1UhRs&ab_channel=MichaelMuinos
 * https://leetcode.com/problems/max-area-of-island/submissions/
 */

package com.shams.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

  public static void main(String[] args) {
//    int[][] grid = {
//        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//    };
    // Output : 6

    int[][] grid = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}};
    // Output : 4
    System.out.println(maxAreaIsland(grid));
  }

  private static int maxAreaIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int max = 0, m = grid.length, n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          int curCount = getIslandCount(grid, i, j, m, n);
          max = Math.max(curCount, max);
        }
      }
    }
    return max;
  }

  static int[][] DIRECTIONS = {
      {0, -1},
      {0, 1},
      {-1, 0},
      {1, 0},
  };
  static Queue<Integer> q = new LinkedList<>();

  // DFS
  static int getIslandCount(int[][] grid, int i, int j, int m, int n) {
    if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;

    grid[i][j] = 0;
    int left = getIslandCount(grid, i, j - 1, m, n);
    int right = getIslandCount(grid, i, j + 1, m, n);
    int top = getIslandCount(grid, i - 1, j, m, n);
    int down = getIslandCount(grid, i + 1, j, m, n);
    return left + right + top + down + 1;
  }

  // BFS
  private static int getMaxAreaIsland(int[][] grid, int i, int j, int m, int n) {
    int count = 1;
    q.add(i * n + j);
    grid[i][j] = 0;
    while (!q.isEmpty()) {
      int index = q.poll();
      int row = index / n;
      int col = index % n;
      for (int[] d : DIRECTIONS) {
        int x = d[0] + row;
        int y = d[1] + col;
        if (x > -1 && x < m && y > -1 && y < n && grid[x][y] == 1) {
          q.add(x * n + y);
          grid[x][y] = 0;
          count++;
        }
      }
    }
    return count;
  }
}
