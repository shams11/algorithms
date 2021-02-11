/***
 * https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * */

package com.shams.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapping {

  public static void main(String[] args) {
    int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int traps = trap(heights);
    System.out.println(traps);
  }

  private static int trap(int[] a) {
    List<Integer> nll = getNextlargestLeft(a);
    List<Integer> nlr = getNextlargestRight(a);
    int traps = 0;
    for (int i = 0; i < a.length; i++) {
      int result = Math.min(nll.get(i), nlr.get(i)) - a[i];
      if (result > 0) {
        traps += result;
      }
    }
    return traps;
  }

  private static List<Integer> getNextlargestRight(int[] a) {
    Stack<Integer> s = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = a.length - 1; i >= 0; i--) {
      if (s.isEmpty()) {
        list.add(-1);
        s.push(a[i]);
      } else if (a[i] < s.peek()) {
        list.add(s.peek());
      } else if (a[i] >= s.peek()) {
        s.pop();
        if (s.isEmpty()) {
          list.add(-1);
        }
        s.push(a[i]);
      }
    }
    Collections.reverse(list);
    System.out.println("nlr : " + list);
    return list;
  }

  private static List<Integer> getNextlargestLeft(int[] a) {
    Stack<Integer> s = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (s.isEmpty()) {
        list.add(-1);
        s.push(a[i]);
      } else if (a[i] < s.peek()) {
        list.add(s.peek());
      } else if (a[i] >= s.peek()) {
        s.pop();
        if (s.isEmpty()) {
          list.add(-1);
        }
        s.push(a[i]);
      }
    }
    System.out.println("nll : " + list);
    return list;
  }
}
