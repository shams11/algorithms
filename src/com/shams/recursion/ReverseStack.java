/**
 * https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10&ab_channel=AdityaVerma
 * */
package com.shams.recursion;

import java.util.Stack;

public class ReverseStack {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    System.out.println(s);
    revers(s);
    System.out.println(s);
    System.out.println();
  }

  private static void revers(Stack<Integer> s) {
    if(s.isEmpty()) {
      return;
    }
    int temp = s.pop();
    revers(s);
    pushStack(s, temp);
  }

  private static void pushStack(Stack<Integer> s, int ele) {
    if(s.isEmpty()) {
      s.push(ele);
      return;
    }
    int temp = s.pop();
    pushStack(s, ele);
    s.push(temp);
  }
}
