/**
 * https://www.youtube.com/watch?v=6FPsqiCS2g8&ab_channel=WorkWithGoogler
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * */
package com.shams.matrix;

public class LongestLineOfOnesInBinaryMatrix {
  public static void main(String[] args) {
    int[][] a = {
        {0, 1, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 1}
    };
    // Output : 3
    System.out.println(longestLine(a));
  }

  public static int longestLine(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int maxOnes = 0;
    int curOnes;

    // Traverse rows
    for (int i = 0; i < m; ++i) {
      curOnes = 0;
      for (int j = 0; j < n; ++j) {
        if (mat[i][j] == 0) {
          curOnes = 0;
          continue;
        }
        maxOnes = Math.max(maxOnes, ++curOnes);
      }
    }


    // Traverse cloumns
    for (int j = 0; j < n; ++j) {
      curOnes = 0;
      for (int i = 0; i < m; ++i) {
        if (mat[i][j] == 0) {
          curOnes = 0;
          continue;
        }
        maxOnes = Math.max(maxOnes, ++curOnes);
      }
    }


    // m + n because the total diagonals will be m + n
    // starting index will be 0 at (2, 0) for bottom-left diagonal
    // and index will be 0 at (0, 0) for top-left diagonal


    // Traverse diagonally and anti-diagonally from bottom left and top left
    for (int index = 0; index < m + n; ++index) {
      curOnes = 0;

      // Traversing diagonals starting
      // index -> 0 => (2,0) -> startI should be 2
      // index -> 1 => (1,0), (2,1) -> startI should be 1
      // index -> 2 => (0,0),(1,1),(2,2) -> startI should be 0
      // index -> 3 => (0,1), (1,2), (2,3) -> startI should be 0, because diagonal will always start from 0th row
      // index -> 4 => (0,2), (1,3)
      // index -> 5 => (0, 3)
      int startI = index >= m - 1 ? 0 : m - 1 - index;
      int startJ = index >= m - 1 ? index + 1 - m : 0;
      // Traverse from bottom-left
      for (int i = startI, j = startJ; i < m && j < n; ++i, ++j) {
        if (mat[i][j] == 0) {
          curOnes = 0;
          continue;
        }
        maxOnes = Math.max(maxOnes, ++curOnes);
      }

      // Traverse from top-left to bottom left. At top-left index will be 0
      // Ex : index = 0, then startI and startY = (0, 0)
      // Ex : index = 1, then startI and startY = (0, 1)

      // {
          // (0,0), (0,1) (0,2), (0,3)
          // (1,0), (1,1) (1,2), (1,3)
          // (2,0), (2,1) (2,2), (2,3)
      // }

      // (0,0) => index at 0, result will be (0,0)
      // (1,0), (0,1) =>
      // (2,0), (1,1),(0,2)
      startI = index < n ? 0 : index - n + 1;
      startJ = index < n ? index : n - 1;
      // n-1 because, index starts from last column and index because j starts from (0,0), (0,1), (0,2)
      curOnes = 0;
      for (int i = startI, j = startJ; i < m && j >= 0; ++i, --j) {
        if (mat[i][j] == 0) {
          curOnes = 0;
          continue;
        }
        maxOnes = Math.max(maxOnes, ++curOnes);
      }
    }
    return maxOnes;
  }
}
