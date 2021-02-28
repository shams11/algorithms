/**
 * https://www.geeksforgeeks.org/print-shortest-common-supersequence/
 * https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29&ab_channel=AdityaVerma
 *
 * */
package com.shams.dp;

public class PrintSCS {
  static int[][] t;

  public static void main(String[] args) {
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";


    int m = s1.length();
    int n = s2.length();

    t = new int[m + 1][n + 1];
    System.out.println(lcs(s1, s2, m, n));
  }

  private static String lcs(String x, String y, int m, int n) {
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
          t[i][j] = 1 + t[i - 1][j - 1];
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
        }
      }
    }
    int i = m;
    int j = n;
    StringBuilder s = new StringBuilder();
    while (i > 0 && j > 0) {
      if (x.charAt(i - 1) == y.charAt(j - 1)) {
        s.append(x.charAt(i - 1));
        i--;
        j--;
      } else {
        if (t[i][j - 1] > t[i - 1][j]) {
          s.append(y.charAt(j - 1));
          j--;
        } else {
          s.append(x.charAt(i - 1));
          i--;
        }
      }
    }
    while (i > 0) {
      s.append(x.charAt(i-1));
      i--;
    }
    while (j > 0) {
      s.append(y.charAt(j - 1));
      j--;
    }
    return s.reverse().toString();
  }
}
