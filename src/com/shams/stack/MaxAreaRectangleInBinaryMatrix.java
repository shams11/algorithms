/***
 * https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
 * https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 * https://leetcode.com/problems/maximal-rectangle/submissions/
 * */

package com.shams.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {

  public static class Pair {
    int val;
    int index;

    Pair(int value, int ind) {
      this.val = value;
      this.index = ind;
    }
  }

  public static void main(String[] args) {
    int[][] a1 = {
        {0, 1, 1, 0},
        {1, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0}
    };
    int[][] a = {
      {0, 1, 1},
      {1, 1, 1},
      {0, 1, 1}
    };
    System.out.println(printMaxAreaRectangleInBinaryMatrix(a, a.length, a[0].length));
  }

  private static int printMaxAreaRectangleInBinaryMatrix(int[][] a, int n, int m) {

    int[] b = new int[m];
    for (int j = 0; j < m; j++) {
      b[j] = a[0][j];
    }
    int result = getMaxAreaHologram(b);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 0) {
          b[j] = 0;
        } else {
          b[j] = b[j] + a[i][j];
        }
      }
      result = Math.max(result, getMaxAreaHologram(b));
    }
    return result;
  }

  private static int getMaxAreaHologram(int[] a) {
    List<Integer> nsl = getNextSmallerToLeft(a);
    List<Integer> nrl = getNextSmallerToRight(a);

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      int curMax = a[i] * (nrl.get(i) - nsl.get(i) - 1);
      max = Math.max(curMax, max);
    }
    return max;
  }

  private static List<Integer> getNextSmallerToRight(int[] a) {
    Stack<Pair> s = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = a.length - 1; i >= 0; i--) {
      if (s.isEmpty()) {
        list.add(a.length);
      } else if (a[i] > s.peek().val) {
        list.add(s.peek().index);
      } else if (a[i] <= s.peek().val) {
        while (!s.isEmpty() && a[i] <= s.peek().val) {
          s.pop();
        }
        if (s.isEmpty()) {
          list.add(a.length);
        } else {
          list.add(s.peek().index);
        }
      }
      s.push(new Pair(a[i], i));
    }
    Collections.reverse(list);
    System.out.println("nsr : " + list);
    return list;
  }

  private static List<Integer> getNextSmallerToLeft(int[] a) {
    Stack<Pair> s = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (s.isEmpty()) {
        list.add(-1);
      } else if (a[i] > s.peek().val) {
        list.add(s.peek().index);
      } else if (a[i] <= s.peek().val) {
        while (!s.isEmpty() && a[i] <= s.peek().val) {
          s.pop();
        }
        if (s.isEmpty()) {
          list.add(-1);
        } else {
          list.add(s.peek().index);
        }
      }
      s.push(new Pair(a[i], i));
    }
    System.out.println("nsl : " + list);
    return list;
  }
}
