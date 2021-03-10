/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
 * https://leetcode.com/problems/online-stock-span/
 */

package com.shams.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

  public static class Pair {
    int val;
    int index;

    Pair(int value, int ind) {
      this.index = ind;
      this.val = value;
    }
  }

  public static void main(String[] args) {
    int[] a = {100, 80, 60, 70, 60, 75, 85};
    //int[] a = {6, 2, 5, 4, 5, 1, 6};
    System.out.println(getConsecutiveSmallerOnLeftOfEachElement(a));
  }

  private static List<Integer> getConsecutiveSmallerOnLeftOfEachElement(int[] a) {
    Stack<Pair> s = new Stack<>();
    List<Integer> list = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (s.isEmpty()) {
        //s.push(new Pair(a[i], i));
        list.add(-1);
      } else if (a[i] <= s.peek().val) {
        list.add(s.peek().index);
      } else if (a[i] >= s.peek().val) {
        while (!s.isEmpty() && a[i] >= s.peek().val) {
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
    System.out.println( "nsl : " + list);
    for (int i = 0; i < list.size(); i++) {
      result.add(i - list.get(i));
    }
    return result;
  }
}
