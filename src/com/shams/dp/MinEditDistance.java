/***
 * https://www.youtube.com/watch?v=ZkgBinDx9Kg&ab_channel=KnowledgeCenter
 * https://leetcode.com/problems/edit-distance/
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 * https://www.youtube.com/watch?v=AuYujVj646Q&ab_channel=TECHDOSE
 * */

package com.shams.dp;

public class MinEditDistance {
  public static void main(String[] args) {
    String word1 = "horse";
    String word2 = "ros";
    System.out.println(minDistance(word1, word2));
  }

  public static int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    char[] x = word1.toCharArray();
    char[] y = word2.toCharArray();
    int[][] t = new int[m + 1][n + 1];
    // Initialization
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0) {
          t[i][j] = j;
        }
        if (j == 0) {
          t[i][j] = i;
        }
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (x[i - 1] == y[j - 1]) {
          t[i][j] = t[i - 1][j - 1];
        } else {
          t[i][j] = 1 + min(
              t[i][j - 1],  // insert
              t[i - 1][j], // delete
              t[i - 1][j - 1] // replace
          );
        }
      }
    }
    return t[m][n];
  }

  private static int min(int x, int y, int z) {
    if (x <= y && x <= z) {
      return x;
    } else if (y <= x && y <= z) {
      return y;
    } else {
      return z;
    }
  }
}

