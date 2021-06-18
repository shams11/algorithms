/**
 * https://leetcode.com/problems/asteroid-collision/
 * https://www.youtube.com/watch?v=70AtvN5487Y&ab_channel=MichaelMuinosMichaelMuinos
 */

package com.shams.stack;

import java.util.Stack;

public class AsteroidCollision {
  public static void main(String[] args) {
    //int[] a = {1,-1,-2,-2};
    int[] a = {5, 10, -5};
    // Input: asteroids = [5,10,-5]
    //Output: [5,10]
    //Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
    int[] result = asteroidCollision(a);
    for (int i : result) {
      System.out.print(i + " ");
    }
  }

  public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < asteroids.length; i++) {
      int asteroid = asteroids[i];
      if (asteroid > 0) {
        s.push(asteroid);
      } else {
        while (!s.isEmpty() && s.peek() > 0 && Math.abs(asteroid) > s.peek()) {
          s.pop();
        }
        if (s.isEmpty() || s.peek() < 0) {
          s.push(asteroid);
        } else if (s.peek() == Math.abs(asteroid)) {
          s.pop();
        }
      }
    }
    if (s.isEmpty()) return new int[0];
    int[] result = new int[s.size()];
    int i = s.size() - 1;
    while (!s.empty()) {
      result[i--] = s.pop();
    }
    return result;
  }
}
