/**
 * https://leetcode.com/problems/unique-paths-iii/
 */

package com.shams.matrix;

public class UniquePathsIII {
  public static void main(String[] args) {
    // Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
    //Output: 2
    //Explanation: We have the following two paths:
    //1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    //2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

    // Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
    //Output: 4
    //Explanation: We have the following four paths:
    //1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
    //2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
    //3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
    //4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

    // Input: [[0,1],[2,0]]
    //Output: 0
    //Explanation:
    //There is no path that walks over every empty square exactly once.
    //Note that the starting and ending square can be anywhere in the grid.

    int[][] grid = {
        {1, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 2, -1}
    };
    System.out.println(uniquePathsIII(grid));
  }

  public static int uniquePathsIII(int[][] grid) {
    int zero = 0, startX = 0, startY = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          ++zero;
        } else if (grid[i][j] == 1) {
          startX = i;
          startY = j;
        }
      }
    }
    return dfs(grid, startX, startY, zero);
  }

  static int dfs(int[][] grid, int i, int j, int zero) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
      return 0;
    }
    if (grid[i][j] == 2) {
      return zero == -1 ? 1 : 0;
    }
    int temp = grid[i][j];
    grid[i][j] = -1;
    zero--;
    int totalPaths = dfs(grid, i - 1, j, zero)
        + dfs(grid, i + 1, j, zero)
        + dfs(grid, i, j - 1, zero)
        + dfs(grid, i, j + 1, zero);

    grid[i][j] = 0;
    zero++;
    return totalPaths;
  }
}
