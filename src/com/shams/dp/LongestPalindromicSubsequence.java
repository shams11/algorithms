package com.shams.dp;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    String s = "agbcba";
    // Output : 5
    // LPS : abcba
    System.out.println(longestPalindromicSubsequence(s));
  }

  private static int longestPalindromicSubsequence(String s1) {
    // agbcba
    // abcbga
    // LPS = LCS(s, reverse(s))
    String s2 = new StringBuilder(s1).reverse().toString();
    int m = s1.length(), n = s2.length();
    int[][] t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; ++i) {
      for (int j = 0; j < n + 1; ++j) {
        if (i == 0 || j == 0) t[i][j] = 0;
      }
    }

    for (int i = 1; i < m + 1; ++i) {
      for (int j = 1; j < n + 1; ++j) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }
    return t[m][n];
  }
}
