/***
 * https://leetcode.com/problems/minimum-path-sum/
 * */

package com.shams.matrix;

public class MinimumPathSum {
  public static void main(String[] args) {
//    int[][] grid = {
//        {1, 3, 1},
//        {1, 5, 1},
//        {4, 2, 1}
//    };
    int[][] grid = {
        {1, 2, 3},
        {4, 5, 6}
    };
    System.out.println(minPathSum(grid));
  }

  public static int minPathSum(int[][] grid) {
    int m = grid.length; // row length
    int n = grid[0].length; // column length
    int[][] t = new int[m][n];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        getMin(grid, t, i, j, m, n);
      }
    }
    return t[0][0];
  }

  static int[][] DIRECTONS = {
      {0, 1}, // right
      {1, 0} // down
  };

  static int getMin(int[][] g, int[][] t, int i, int j, int m, int n) {
    if (t[i][j] > 0) {
      return t[i][j];
    }

    int min = Integer.MAX_VALUE;
    for (int[] direction : DIRECTONS) {
      int x = direction[0] + i;
      int y = direction[1] + j;
      if (x > -1 && y > -1 && x < m && y < n) {
        int curMin = getMin(g, t, x, y, m, n);
        min = Math.min(curMin, min);
      }
    }
    if (i == m - 1 && j == n - 1) {
      min = 0; // last cell will not be compared with any other adjacent cells
    }
    t[i][j] = g[i][j] + min;
    return t[i][j];
  }
}
