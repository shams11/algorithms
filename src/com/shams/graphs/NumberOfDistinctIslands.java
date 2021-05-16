/**
 * https://www.youtube.com/watch?v=c1ZxUOHlulo&ab_channel=MichaelMuinos\
 * https://leetcode.com/problems/number-of-distinct-islands/
 */

package com.shams.graphs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

  public static void main(String[] args) {
    int[][] a = {
        {1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1}
    };
    System.out.println(numOfDistinctIslands(a));
  }

  /* X - start
   *  O - out of bounds or water (0)
   *  L - left
   *  R - right
   *  U - up
   *  D - down
   * */

  private static int numOfDistinctIslands(int[][] a) {
    if (a == null || a.length == 0) return 0;
    Set<String> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if (a[i][j] == 1) {
          String path = computePath(a, i, j, "X");
          set.add(path);
        }
      }
    }
    return set.size();
  }

  private static String computePath(int[][] a, int i, int j, String direction) {
    if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0) {
      return "0";
    }
    a[i][j] = 0;
    String left = computePath(a, i, j - 1, "L");
    String right = computePath(a, i, j + 1, "R");
    String up = computePath(a, i - 1, j, "U");
    String down = computePath(a, i + 1, j, "D");
    return direction + left + right + up + down;
  }
}
