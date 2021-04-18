/***
 * https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * */

package com.shams.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapping {

  public static void main(String[] args) {
    //int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] heights = {4, 2, 0, 3, 2, 5};
    int traps = trap(heights);
   // System.out.println( "trap 1 : " + traps);

    System.out.println("trap 2 : " + trap2(heights));
  }

  private static int trap2(int[] a) {
    int n = a.length;
    int[] maxOnLeft = new int[n];
    maxOnLeft[0] = a[0];
    for (int i = 1; i < n; i++) {
      // calculate max value on left for each element
      maxOnLeft[i] = Math.max(maxOnLeft[i - 1], a[i]);
    }
    Arrays.stream(maxOnLeft).forEach(System.out::print);
    int[] maxOnRight = new int[n];
    maxOnRight[n - 1] = a[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      // calculate max value on Right for each element
      maxOnRight[i] = Math.max(maxOnRight[i + 1], a[i]);
    }
    int[] water = new int[n];
    for (int i = 0; i < n; i++) {
      water[i] = Math.min(maxOnLeft[i], maxOnRight[i]) - a[i];
    }
    int sum = 0;
    for(int i = 0; i < n; i++) {
      sum += water[i];
    }
    return sum;
  }

  private static int trap(int[] a) {
    List<Integer> largestOnLeft = getLargestOnLeft(a);
    List<Integer> largestOnRight = getLargestOnRight(a);
    int traps = 0;
    for (int i = 0; i < a.length; i++) {
      // Get min of largest on left and right and minus current building height
      int result = Math.min(largestOnLeft.get(i), largestOnRight.get(i)) - a[i];
      if (result > 0) {
        traps += result;
      }
    }
    return traps;
  }

  private static List<Integer> getLargestOnRight(int[] a) {
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
    System.out.println("ngr : " + list);
    return list;
  }

  private static List<Integer> getLargestOnLeft(int[] a) {
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
    System.out.println("ngl : " + list);
    return list;
  }
}
