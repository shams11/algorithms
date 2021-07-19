/**
 * https://leetcode.com/problems/reorganize-string/
 */

package com.shams.stack;

import java.util.Stack;

public class ReorganizeString {
  public static void main(String[] args) {
    String s = "cxmwmmm";
    System.out.println(reorganizeString(s));
  }

  public static String reorganizeString(String s) {
    if (s.length() == 1) return s;
    if (s.length() == 2) {
      if (s.charAt(0) != s.charAt(1)) {
        return s;
      }
      return "";
    }
    Stack<Character> s1 = new Stack<>();
    Stack<Character> s2 = new Stack<>();

    s1.push(s.charAt(0));
    int i = 1;
    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == s1.peek()) {
        s2.push(c);
      } else {
        s1.push(c);
        if (!s2.isEmpty()) s1.push(s2.pop());
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!s1.isEmpty()) {
      sb.append(s1.pop());
    }
    sb = sb.reverse();
    if (!s2.isEmpty() && s2.peek() != sb.charAt(0)) {
      sb.insert(0, s2.pop());
    }
    i = 1;
    while (!s2.isEmpty() && i < sb.length() - 1) {
      if (s2.peek() != sb.charAt(i - 1) && s2.peek() != sb.charAt(i)) {
        sb = sb.insert(i, s2.pop());
      }
      i++;
    }
    return !s2.isEmpty() ? "" : sb.toString();
  }
}
