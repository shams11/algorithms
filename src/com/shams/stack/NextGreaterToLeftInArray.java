package com.shams.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterToLeftInArray {
  public static void main(String[] args) {
    int[] a = {1, 3, 2, 4};
    // Output : -1, -1, 3, -1
    System.out.println(nextGreaterToLeft(a));
  }

  private static List<Integer> nextGreaterToLeft(int[] a) {
    List<Integer> list = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < a.length; i++) {
      if (s.isEmpty()) {
        list.add(-1);
      } else if (a[i] < s.peek()) {
        list.add(s.peek());
      } else if (a[i] > s.peek()) {
        while (!s.isEmpty() &&  a[i] > s.peek()) {
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
    return list;
  }
}
