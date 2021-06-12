/**
 * https://leetcode.com/problems/number-of-islands/
 * https://www.youtube.com/watch?v=HS7t2i9ldmE&list=PLtQWXpf5JNGJMr17PhMPBtYG5JP1_Ownp&index=13&ab_channel=MichaelMuinos
 */

package com.shams.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {

  public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    // Output: 1
    // grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    //]
    //Output: 3
    System.out.println(numIslands(grid));
  }

  static Queue<Integer> q = new LinkedList<>();
  static int[][] DIRECTIONS = {
      {0, -1}, // left
      {0, 1}, // right
      {-1, 0}, // top
      {1, 0} // down
  };

  public static int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          // count++;
          // countIslands(grid, m, n, i, j);
          count++;
          dfs(grid, i, j);
          }
        }
      }
    return count;
  }

  static void dfs(char[][] grid, int i, int j) {

    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
    grid[i][j] = '0';

    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }

  static void countIslands(char[][] grid, int m, int n, int i, int j) {
    q.add(i * n + j);
    grid[i][j] = '0';
    while (!q.isEmpty()) {
      int index = q.poll();
      int row = index / n;
      int col = index % n;
      for (int[] direction : DIRECTIONS) {
        int x = direction[0] + row;
        int y = direction[1] + col;
        if (x > -1 && x < m && y > -1 && y < n && grid[x][y] == '1') {
          q.add(x * n + y);
          grid[x][y] = '0';
        }
      }
    }
  }
}
