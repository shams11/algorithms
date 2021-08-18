/**
 * https://www.geeksforgeeks.org/longest-repeated-subsequence/
 * https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30&ab_channel=AdityaVerma
 */

package com.shams.dp;

public class LongestRepeatingSubsequence {
  public static void main(String[] args) {
    String s = "AABEBCDD";
    // Output : ABD : 3
    // ABD is there twice

    // LCS code diff => if(x.charAt(i) == y.chatAt(j) && i != j)
    // because we want to take only repeating chars which are part of LCS
    System.out.println(longestRepeatingSubsequence(s));
  }

  private static int longestRepeatingSubsequence(String s1) {
    String s2 = s1;
    int m = s1.length(), n = s2.length();
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; ++i) {
      for (int j = 0; j < n + 1; ++j) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; ++j) {
        // i != j because we want to take only repeating chars which are part of LCS
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    return t[m][n];
  }
}
