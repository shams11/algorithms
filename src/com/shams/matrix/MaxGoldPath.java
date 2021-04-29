/***
 * https://www.youtube.com/watch?v=8nlmcgy7vso&list=PLtQWXpf5JNGLGkKSGYW6KA0Q71t__6CgQ&ab_channel=MichaelMuinos
 * https://leetcode.com/problems/path-with-maximum-gold/
 */

package com.shams.matrix;

/**
 * Game: GoldPicker with traps.
 * Objective: Collect all coins from all start points
 * 0 - start Exploration.
 * 1 - trap. Stop exploration.
 * 2 - Gold Coin. get chance to explore more
 *
 * 1 0 2 0
 * 1 2 2 1
 * 1 0 0 2
 **/
class MaxGoldPath {

//  static int[][] mat = {
//      {1, 0, 2, 0},
//      {1, 2, 2, 1},
//      {1, 0, 0, 2}
//  };

  static int[][] mat = {
      {0, 6, 0},
      {5, 8, 7},
      {0, 9, 0}
  };
  // Output : 24
  public static void main(String[] args) {
    System.out.println("Output :" + getMaxGold(mat, mat.length, mat[0].length));
  }

  static int getMaxGold(int[][] mat, int m, int n) {
    boolean[][] t = new boolean[m][n];
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] > 0) {
          int curMax = calMaxGold(mat, m, n, i, j, t);
          max = Math.max(max, curMax);
        }
      }
    }
    return max;
  }

  static int calMaxGold(int[][] mat, int m, int n, int i, int j, boolean[][] visited) {
    int max = 0;
    if (i < 0 || j < 0 || i >= m || j >= n || mat[i][j] == 0 || visited[i][j]) {
      return 0;
    }
    visited[i][j] = true;
    int left = calMaxGold(mat, m, n, i, j - 1, visited);
    int right = calMaxGold(mat, m, n, i, j + 1, visited);
    int up = calMaxGold(mat, m, n, i - 1, j, visited);
    int down = calMaxGold(mat, m, n, i + 1, j, visited);
    max = Math.max(left, Math.max(right, Math.max(up, down)));
    visited[i][j] = false;
    return max + mat[i][j];
  }
}

