/***
 *
 * https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7
 * https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * */

package com.shams.stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxAreaHistogram {
  public static void main(String[] args) {
    int[] a = {6, 2, 5, 4, 5, 1, 6};
    //int[] a = {2, 1, 0, 1, 3};
    System.out.println(largestRectangleArea(a));
  }

  public static class Pair {
    int val;
    int index;

    Pair(int value, int ind) {
      this.val = value;
      this.index = ind;
    }
  }

  static Stack<Pair> s;

  public static int largestRectangleArea(int[] heights) {
    List<Integer> nextSmallestLeft = getNextSmallerToLeft(heights);
    List<Integer> nextSmallestRight = getNextSmallerToRight(heights);

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      System.out.println(heights[i] + "*" + nextSmallestRight.get(i) + "-" + nextSmallestLeft.get(i) + "-1");
      max = Math.max(max, heights[i] * (nextSmallestRight.get(i) - nextSmallestLeft.get(i) - 1));
    }
    return max;
  }

  private static List<Integer> getNextSmallerToLeft(int[] a) {
    s = new Stack<>();
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

  private static List<Integer> getNextSmallerToRight(int[] a) {
    s = new Stack<>();
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
}
