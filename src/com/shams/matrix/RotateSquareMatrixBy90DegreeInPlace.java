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
    transpose(a, N);
    reverseColumns(a, N);
  }

  private static void reverseColumns(int[][] a, int n) {
    for (int i = n-1; i >= 0; i--) {
      for (int j = n-1, k = 0; j > k; j--, k++) {
        swap(a, j, i, k, i);
      }
    }
  }

  private static void swap(int[][] a, int i, int j, int k, int l) {
    int temp = a[i][j];
    a[i][j] = a[k][l];
    a[k][l] = temp;
  }

  private static void transpose(int[][] a, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        swap(a, i, j, j, i);
      }
    }
  }

  static void printMatrix(int[][] mat, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(" " + mat[i][j]);
      }
      System.out.println();
    }
  }
}

