package com.shams.recursion;

import java.util.Stack;

public class DeleteStackMiddleElement {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    System.out.println(s);
    delMid(s);
    System.out.println(s);
  }

  private static void delMid(Stack<Integer> s) {
    if(s.isEmpty()) {
      return;
    }
    int k = (s.size() / 2 ) + 1;
    solve(s, k);
  }

  private static void solve(Stack<Integer> s, int k) {
    if( k == 1) {
      s.pop();
      return;
    }
    int temp = s.pop();
    solve(s, k - 1);
    s.push(temp);
  }
}
