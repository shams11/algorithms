/**
 * https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 */

package com.shams.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeftInArray {

  public static void main(String[] args) {
    int[] a = {1, 6, 4, 10, 2, 5};
    /**
     * Input:  arr[] = {1, 6, 4, 10, 2, 5}
     * Output:         {-1, 1, 1,  4, 1, 2}
     * */
    System.out.println(nextSmallerToLeft(a));
  }

  private static List<Integer> nextSmallerToLeft(int[] a) {
    List<Integer> list = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < a.length; i++) {
      if (s.isEmpty()) {
        list.add(-1);
      } else if (a[i] > s.peek()) {
        list.add(s.peek());
      } else if (a[i] < s.peek()) {
        while (!s.isEmpty() && a[i] < s.peek()) {
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
