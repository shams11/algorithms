/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * https://www.youtube.com/watch?v=MnD8KhBHgRo&ab_channel=MichaelMuinos
 */

package com.shams.graphs;

public class CountClosedIslands {
  public static void main(String[] args) {
    int[][] a = {
        {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
        {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
        {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
        {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
    };
// Output 5

//    int[][] a = {
//        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
//        {0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
//        {1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
//        {1, 1, 1, 1, 1, 0, 0, 1, 0, 0},
//        {1, 0, 1, 0, 1, 1, 1, 1, 1, 0},
//        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
//        {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
//        {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
//        {0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
//        {1, 1, 0, 1, 0, 1, 0, 0, 1, 0}
//    };
    // Output 4
    System.out.println(closedIsland(a));
  }

  public static int closedIsland(int[][] grid) {

    if (grid == null || grid.length == 0) return 0;
    int count = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (grid[i][j] == 0) {
          if (isClosedIsland(grid, i, j, m, n)) {
            count++;
          }
        }
      }
    }
    return count;
  }

  static boolean isClosedIsland(int[][] grid, int i, int j, int m, int n) {

    if (grid[i][j] == 1) return true;
    if (isOnBorder(i, j, m, n)) return false;
    grid[i][j] = 1;
    boolean left = isClosedIsland(grid, i, j - 1, m, n);
    boolean right = isClosedIsland(grid, i, j + 1, m, n);
    boolean up = isClosedIsland(grid, i - 1, j, m, n);
    boolean down = isClosedIsland(grid, i + 1, j, m, n);
    return left && right && up && down;
  }

  // is on border (outer matrix and is 0)
  private static boolean isOnBorder(int i, int j, int m, int n) {
    return i == 0 || j == 0 || i == m - 1 || j == n - 1;
  }
}
