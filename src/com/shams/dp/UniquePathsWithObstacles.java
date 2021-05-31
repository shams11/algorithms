/**
 * https://leetcode.com/problems/unique-paths-ii/submissions/
 */

package com.shams.dp;

public class UniquePathsWithObstacles {
  public static void main(String[] args) {
//    int[][] a = {
//        {0, 1},
//        {0 ,0}
//    };
    // Output : 1
    int[][] a = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    };
    // Output : 2
    System.out.println(uniquePathsWithObstacles(a));
  }

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) return 0;
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] t = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          t[i][j] = 1;
        } else if (i == 0 || j == 0) {
          if (obstacleGrid[i][j] == 1) {
            t[i][j] = 0;
          } else {
            if (i == 0) {
              t[i][j] = t[i][j - 1];
            }
            if (j == 0) {
              t[i][j] = t[i - 1][j];
            }
          }
        }
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          t[i][j] = 0;
        } else {
          t[i][j] = t[i - 1][j] + t[i][j - 1];
        }
      }
    }
    return t[m - 1][n - 1];
  }
}
