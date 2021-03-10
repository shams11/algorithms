/***
 * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * */

package com.shams.matrix;

public class RotateSquareMatrixBy90DegreeInPlace {
  public static void main(String[] args) {
    int[][] a = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    int N = a.length;
    rotate90InPlace(a, N);
    printMatrix(a, N);
  }

  private static void rotate90InPlace(int[][] a, int N) {
    for (int x = 0; x < N / 2; x++) {
      for (int y = x; y < N - x - 1; y++) {
        int temp = a[x][y];

        // copy from top right to top left -> copy from (0, 3) to (0, 0)
        a[x][y] = a[y][N - x - 1];

        // copy from right bottom to top right -> copy from (3, 3) to (0, 3)
        a[y][N - x - 1] = a[N - x - 1][N - y - 1];

        // copy from left bottom to right bottom -> copy from (3, 0) to (3, 3)
        a[N - x - 1][N - y - 1] = a[N - y - 1][x];

        // copy from top left to bottom left -> copy from (0, 0) to (3, 0)
        a[N - y - 1][x] = temp;
      }
    }
  }

  static void printMatrix(
      int mat[][], int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(
            " " + mat[i][j]);

      System.out.print("\n");
    }
    System.out.print("\n");
  }
}

