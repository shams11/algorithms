/***
 * https://www.youtube.com/watch?v=CxrnOTUlNJE&ab_channel=TECHDOSE
 * https://leetcode.com/problems/rotting-oranges/submissions/
 * */

package com.shams.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
  public static void main(String[] args) {
//    int[][] grid = {
//        {1, 2}
//    };
    int[][] grid = {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };
    // Output: 4
    System.out.println(orangesRotting(grid));
  }

  static int ones = 0;

  public static int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          ++ones;
        }
        if (grid[i][j] == 2) {
          q.add(i * n + j);
        }
      }
    }

    if (ones == 0) return 0;
    return bfs(grid, q);
  }

  static int[][] DIRECTIONS = {
      {0, -1},
      {0, 1},
      {-1, 0},
      {1, 0}
  };

  private static int bfs(int[][] grid, Queue<Integer> q) {
    int count = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int index = q.poll();
        int x1 = index / grid[0].length;
        int y1 = index % grid[0].length;
        for (int[] d : DIRECTIONS) {
          int x = d[0] + x1;
          int y = d[1] + y1;
          if (x > -1 && y > -1 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = 2;
            q.add(x * grid[0].length + y);
            ones--;
          }
        }
      }
      ++count;
    }
    return ones == 0 ? count - 1 : -1; // remove initial given rotten orange from count
  }
}
