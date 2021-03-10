/**
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=11
 */

package com.shams.stack;

import java.util.Stack;

public class StackMin {

  public static class CustomStack {

    Stack<Integer> s;
    int min;

    CustomStack() {
      s = new Stack<>();
      this.min = -1;
    }

    // Implement below methods
    // push();
    // pop();
    // getMin();
    // top();
    void push(int x) {
      if (s.isEmpty()) {
        s.push(x);
        min = x;
        System.out.println("Number Inserted: " + x);
        return;
      } else if (x > min) {
        s.push(x);
      } else if (x < min) {
        s.push(2 * x - min);
        min = x;
      }
      System.out.println("Number Inserted: " + x);
    }

    void pop() {
      if (s.isEmpty()) {
        System.out.println("Stack is empty");
      } else if (s.peek() >= min) {
        int t = s.pop();
        System.out.println("popped " + t);
      } else if (s.peek() < min) {
        System.out.println("popped " + min);
        min = 2 * min - s.peek();
        s.pop();
      }
    }

    int getMin() {
      System.out.println("Minimum Element in the " +
          " stack is: " + min);
      return min;
    }

    int peek() {
      if (s.isEmpty()) {
        System.out.println("Stack is empty");
        return -1;
      }
      if (s.peek() > min) {
        System.out.println(s.peek());
        return s.peek();
      } else {
        System.out.println(min);
        return min;
      }
    }
  }

  public static void main(String[] args) {
    CustomStack s = new CustomStack();
    s.push(18);
    s.getMin();
    s.push(19);
    s.getMin();
    s.push(29);
    s.getMin();
    s.push(15);
    s.getMin();
    s.pop();
    s.getMin();
//    s.pop();
//    s.peek();
  }
}
