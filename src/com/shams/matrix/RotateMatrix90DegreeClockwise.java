/***
 * https://leetcode.com/problems/rotate-image/submissions/
 * https://www.youtube.com/watch?v=J-Ihez5cwCM&list=PLtQWXpf5JNGJMr17PhMPBtYG5JP1_Ownp&index=2&ab_channel=MichaelMuinos
 * */

package com.shams.matrix;

public class RotateMatrix90DegreeClockwise {
  public static void main(String[] args) {
//    int[][] a = {
//        {5, 1, 9, 11},
//        {2, 4, 8, 10},
//        {13, 3, 6, 7},
//        {15, 14, 12, 16}
//    };
    // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

    int[][] a = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    // Transpose will change the matrix to
    // {1, 5, 9, 13}
    // {2, 6, 10, 14}
    // {3, 7, 11, 15}
    // {4, 8, 12, 16}

    // reverse columns
    // {13, 9, 5, 1}
    // {14, 10, 6, 2}
    // {15, 11, 7, 3}
    // {16, 12, 8, 4}
    rotate(a);
    print(a);
  }

  private static void print(int[][] a) {
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a.length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void rotate(int[][] m) {
    if (m == null || m.length == 0) {
      return;
    }
    int r = m.length;
    transpose(m, r);
    reverse(m, r);
  }

  private static void transpose(int[][] m, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        swap(m, i, j, j, i);
      }
    }
  }

  private static void reverse(int[][] m, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0, k = n - 1; j < k; j++, k--) {
        swap(m, i, j, i, k);
      }
    }
  }

  private static void swap(int[][] m, int i, int j, int k, int l) {
    int temp = m[i][j];
    m[i][j] = m[k][l];
    m[k][l] = temp;
  }
}
