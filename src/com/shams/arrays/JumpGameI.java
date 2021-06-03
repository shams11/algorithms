/**
 * https://leetcode.com/problems/jump-game/
 * */
package com.shams.arrays;

public class JumpGameI {
  public static void main(String[] args) {
    int[] a = {2, 3, 1, 1, 4};
    System.out.println(canJump(a));
  }

  public static boolean canJump(int[] nums) {
    int lastGoodIndex = nums.length - 1;
    for(int i = lastGoodIndex; i >= 0; i--) {
      if(i + nums[i] >= lastGoodIndex) {
        lastGoodIndex = i;
      }
    }
    return lastGoodIndex == 0;
  }
}
