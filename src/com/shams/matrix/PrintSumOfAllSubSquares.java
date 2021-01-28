package com.shams.matrix;

/**
 * https://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 */
public class PrintSumOfAllSubSquares {
  public static void main(String[] args) {

    int[][] arr = {
        {1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2},
        {3, 3, 3, 3, 3},
        {4, 4, 4, 4, 4},
        {5, 5, 5, 5, 5},
    };
    int k = 3;
    int n = 5;
    printAllSubSquaresOfSizeK1(arr, k, n);
  }

  private static void printAllSubSquaresOfSizeK1(int[][] mat, int k, int n) {
    if (k > n)
      System.out.println("Invalid input");

    int[] a = new int[n];
    int sum;
    for (int i = 0; i < n; ++i) {
      sum = 0;
      for (int j = 0; j < k; ++j) {
        a[i] = a[i] + mat[j][i];
      }
    }

    for (int i = k; i < n; ++i) {
      sum = 0;
      for (int j = 0; j < k; ++j) {
        sum = sum + a[j];
      }
      System.out.print(sum + " ");

      for (int j = k; j < n; ++j) {
        sum = sum + a[j] - a[j - k];
        System.out.print(sum + " ");
      }
      System.out.println(" ");
      for (int j = 0; j < n; ++j) {
        a[j] = a[j] + mat[i][j] - mat[i - k][j];
      }
    }
    sum = 0;
    for (int j = 0; j < k; ++j) {
      sum = sum + a[j];
    }
    System.out.print(sum + " ");
    for (int j = k; j < n; ++j) {
      sum = sum + a[j] - a[j - k];
      System.out.print(sum + " ");
    }
  }

  static void printAllSubSquaresOfSizeK(int[][] mat) {

    int n = 5;
    int k = 3;
    int[] a = new int[n];
    //store sum of first k elements column by column in all n columns
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        a[i] += mat[j][i];
      }
    }
    for (int i = k; i < n; i++) {
      int sum = 0;
      //sum of first k cloumns
      for (int j = 0; j < k; j++) {
        sum = sum + a[j];
      }

      System.out.print(sum + " ");

      //sum of remaining n-k columns
      for (int j = k; j < n; j++) {
        sum = sum + a[j] - a[j - k];
        System.out.print(sum + " ");
      }
      System.out.println();

      //updating array by adding i-th element of each column and removing i-k-th element
      for (int j = 0; j < n; j++) {
        a[j] = a[j] + mat[i][j] - mat[i - k][j];
      }
    }
    int sum = 0;
    for (int j = 0; j < k; j++) {
      sum = sum + a[j];
    }
    System.out.print(sum + " ");
    for (int j = k; j < n; j++) {
      sum = sum + a[j] - a[j - k];
      System.out.print(sum + " ");
    }
  }
}
