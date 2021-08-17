/***
 * https://leetcode.com/problems/maximal-square/
 * https://www.youtube.com/watch?v=RElcqtFYTm0&ab_channel=TECHDOSE
 * */
package com.shams.dp;

public class MaximalSquare {
  public static void main(String[] args) {
    int[][] a = {
        {1, 0, 1, 0, 0},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0}
    };
    System.out.println(maximalSquare(a));
  }

  public static int maximalSquare(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;

    int m = matrix.length, n = matrix[0].length;
    int largest = 0;
    int[][] t = new int[m + 1][n + 1];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (matrix[i - 1][j - 1] == 1) {
                                        //^
          // find min in all directions <-|. i.e prev col, row and diag elements
          // 1st row and 1st col will be 0's to take care of out of bounds case
          t[i][j] = 1 + min(t[i - 1][j - 1], t[i][j - 1], t[i - 1][j]);
          largest = Math.max(largest, t[i][j]);
        }
      }
    }
    return largest * largest;
  }

  private static int min(int x, int y, int z) {
    if (x <= y && x <= z) return x;
    if (y <= x && y <= z) return y;
    return z;
  }
}
