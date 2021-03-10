/**
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * https://www.geeksforgeeks.org/next-greater-element/
 */

package com.shams.stack;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterToRightInArray {
  public static void main(String[] args) {
    int[] a = {1, 3, 2, 4};
    List<Integer> result = nextGreaterElement(a);
    System.out.println(result);
  }

  private static List<Integer> nextGreaterElement(int[] a) {
    Stack<Integer> s = new Stack<>();
    List<Integer> list = new java.util.ArrayList<>();
    for (int i = a.length - 1; i >= 0; --i) {
      if (s.isEmpty()) {
        list.add(-1);
      } else if (a[i] < s.peek()) {
        list.add(s.peek());
      } else if (a[i] > s.peek()) {
        while (!s.isEmpty() && a[i] > s.peek()) {
          s.pop();
        }
        if (s.isEmpty()) {
          list.add(-1);
        } else {
          list.add(s.peek());
        }

      }
      s.push(a[i]);
    }
    Collections.reverse(list);
    return list;
  }
}
