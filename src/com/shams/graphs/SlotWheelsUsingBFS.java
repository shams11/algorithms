package com.shams.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlotWheelsUsingBFS {
  public static void main(String[] args) {

  }

  public static int slotWheels(List<String> history) {
    int total = 0;
    Queue<String> q = new LinkedList<>();
    for (String s : history) {
      q.add(s);
    }
    while (!q.isEmpty()) {
      int max = Integer.MIN_VALUE;
      int qSize = q.size();
      for (int i = 0; i < qSize; ++i) {
        String s = q.poll();
        int curMax = findMax(s);
        int index = s.indexOf(Character.forDigit(curMax, 10));
        s = s.substring(0, index) + s.substring(index + 1);
        if(!s.equals("")) {
          q.add(s);
        }
        max = Math.max(max, curMax);
      }
      total += max;
    }
    System.out.println(total);
    return total;
  }

  static int findMax(String s) {
    int curChar;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      curChar = c - '0';
      max = Math.max(max, curChar);
    }
    return max;
  }
}
