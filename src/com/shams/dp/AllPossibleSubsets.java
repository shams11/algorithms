/**
 * https://leetcode.com/problems/subsets/discuss/1031486/Javaor-Recursion-or-100
 */

package com.shams.dp;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubsets {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = subsets(nums);
    result.forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    createSubsets(list, new ArrayList<>(), nums, 0);
    return list;
  }

  static void createSubsets(
      List<List<Integer>> list,
      List<Integer> resultList,
      int[] nums, int start) {

    list.add(new ArrayList<>(resultList));
    for (int i = start; i < nums.length; i++) {
      resultList.add(nums[i]);
      createSubsets(list, resultList, nums, i + 1);
      resultList.remove(resultList.size() - 1);
    }
  }
}
