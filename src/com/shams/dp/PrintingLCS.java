package com.shams.dp;

public class PrintingLCS {

  static int[][] t;

  public static void main(String[] args) {
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";

    int m = s1.length();
    int n = s2.length();

    t = new int[m + 1][n + 1];
    lcs(s1, s2, m, n);
  }

  private static void lcs(String x, String y, int m, int n) {
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }
      }
    }
    int i = m;
    int j = n;
    StringBuffer output = new StringBuffer();
    while (i > 0 && j > 0) {
      if (x.charAt(i - 1) == y.charAt(j - 1)) {
        output.append(x.charAt(i - 1));
        i--;
        j--;
      } else {
        if (t[i][j - 1] > t[i - 1][j]) {
          j--;
        } else {
          i--;
        }
      }
    }
    System.out.println(output.reverse());
  }
}
