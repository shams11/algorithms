/**
 * https://www.youtube.com/watch?v=uLjO2LUlLN4
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */

package com.shams.matrix;

public class LongestIncreasingPath {


  public static void main(String[] args) {
    int[][] mat = {
        {3, 4, 5},
        {3, 2, 6}
    };

    int[][] mat1 = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1}
    };

    int[][] mat2 = {
        {7, 8, 9},
        {9, 7, 6},
        {7, 2, 3}
    };

    int[][] mat3 = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1}
    };
    // Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
    //Output: 4
    //Explanation: The longest increasing path is [1, 2, 6, 9].
    System.out.println(longestIncreasingPath(mat2));
  }

  static int[][] DIRECTIONS = {
      {1, 0}, //down
      {-1, 0}, // top
      {0, 1}, // right
      {0, -1} // left
  };

  public static int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int n = matrix.length; // no of rows
    int m = matrix[0].length; // no of columns
    int[][] t = new int[n][m]; // cache to memoize

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int curMax = longestPath(matrix, t, n, m, i, j);
        max = Math.max(max, curMax);
      }
    }
    return max;
  }

  private static int longestPath(int[][] matrix, int[][] t, int n, int m, int i, int j) {
    if (t[i][i] > 0) {
      return t[i][j];
    }
    int max = 0;
    for (int[] direction : DIRECTIONS) {
      int x = direction[0] + i;
      int y = direction[1] + j;
      if (x > -1 && x < n && y > -1 && y < m && matrix[x][y] > matrix[i][j]) {
        int curMax = longestPath(matrix, t, n, m, x, y);
        max = Math.max(max, curMax);
      }
    }
    t[i][j] = max + 1;
    return t[i][j];
  }
}
