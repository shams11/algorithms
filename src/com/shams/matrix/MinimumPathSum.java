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
//    int[][] grid = {
//        {1, 2, 3},
//        {4, 5, 6}
//    };

    //Input :  [[1,3,1],[1,5,1],[4,2,1]]
    // Output : 7
    int[][] grid = {
        {1,3,1},
        {1,5,1},
        {4,2,1}
    };
    System.out.println(minPathSum(grid));
  }

  // DP
  public static int minPathSum(int[][] grid) {
    if(grid == null || grid.length == 0) return 0;
    int m = grid.length; int n = grid[0].length;
    int[][] t = new int[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(i == 0 && j == 0) {
          t[i][j] = grid[i][j];
        }
        else if(i == 0 || j == 0) {
          if(i == 0) {
            t[i][j] = t[i][j - 1];
          }
          if(j == 0) {
            t[i][j] = t[i-1][j];
          }
        } else {
          t[i][j] = grid[i][j] + Math.min(t[i-1][j], t[i][j-1]);
        }
      }
    }
    return t[m-1][n-1];
  }

  // bfs
  public static int minPathSum1(int[][] grid) {
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
