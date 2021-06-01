/**
 * https://www.youtube.com/watch?v=MOGBRkkOhkY&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=7&ab_channel=AdityaVermaAdityaVerma
 * */
package com.shams.recursion;

import java.util.Stack;

public class SortStack {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(6);
    s.push(3);
    s.push(8);
    s.push(2);
    System.out.println(s);
    sortStack(s);
    System.out.println(s);
  }

  private static void sortStack(Stack<Integer> s) {
    if(s.isEmpty()) {
      return;
    }
    int temp = s.pop();
    sortStack(s);
    insert(s, temp);
  }

  private static void insert(Stack<Integer> s, int ele) {
    if(s.isEmpty()) {
      s.push(ele);
      return;
    }
    int temp = s.pop();
    insert(s, ele);
    sort(s, temp);
  }

  private static void sort(Stack<Integer> s , int ele) {
    if(s.isEmpty()) {
      s.push(ele);
      return;
    }
    if(ele < s.peek()) {
      s.push(ele);
      return;
    }
    int temp = s.pop();
    sort(s, ele);
    s.push(temp);
  }
}
