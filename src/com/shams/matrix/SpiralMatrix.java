/**
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */

package com.shams.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] a = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    // Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    System.out.println(spiralOrder(a));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> nums = new ArrayList<>();
    int top = 0, right = matrix[0].length - 1, down = matrix.length - 1, left = 0;
    int dir = 0;
    while (top <= down && left <= right) {
      if (dir == 0) {
        for (int i = left; i <= right; i++) {
          nums.add(matrix[top][i]);
        }
        top++;
      } else if (dir == 1) {
        for (int i = top; i <= down; i++) {
          nums.add(matrix[i][right]);
        }
        right--;
      } else if (dir == 2) {
        for (int i = right; i >= left; i--) {
          nums.add(matrix[down][i]);
        }
        down--;
      } else if (dir == 3) {
        for (int i = down; i >= top; i--) {
          nums.add(matrix[i][left]);
        }
        left++;
      }
      dir = (dir + 1) % 4;
    }
    return nums;
  }
}
