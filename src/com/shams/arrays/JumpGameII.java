/**
 * https://www.youtube.com/watch?v=BRnRPLNGWIo&ab_channel=AlgorithmsMadeEasy
 * https://leetcode.com/problems/jump-game-ii/
 * */
package com.shams.arrays;

public class JumpGameII {
  public static void main(String[] args) {
    int[] a  = {2, 3, 1, 1, 4};
    System.out.println(minJumps(a));
  }

  private static int minJumps(int[] a) {
    int farthest = 0, end = 0, jumps = 0;
    for(int i = 0; i < a.length - 1; i++) {
      farthest = Math.max(farthest, i + a[i]);
      if(i == end ) {
        end = farthest;
        jumps++;
      }
    }
    return jumps;
  }
}
