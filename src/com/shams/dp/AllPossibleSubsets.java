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

  /**
   * initially [] is added to result
   * At i = start = 0, [1] is added result. This call still needs to iterate 2 more times, i = 1, 2
   *      i = start = 1, tempList => [0, 1]. This call still needs to iterate 2 more times, i = 2
   *          start = 2 tempList => [0, 1, 2], This iteration will end when i becomes 3
   *            - i = start= 3. exits
   *            - when start was 2, statements after create call gets executed to remove 3 from tempList
   *      Now, i = start = 1.  2 is removed from tempList, i becomes 2
   *          - 3 is added to tempList => [1, 3]
   *          - i becomes 3 and exit
   *   Now, 1 is removed from the tempList, i becomes 1
   *   i = start = 1 tempList => [2]
   *   i = start = 2 tempList => [2, 3]
   *    - 3 is removed
   *    - 2 is removed
   *
   *
   *
   *
   *    Result sequence
   *
   *    []
   *    [1]
   *    [1, 2]
   *    [1, 2, 3]
   *    [1, 3]
   *    [2]
   *    [2, 3]
   *    [3]

  ***/
  static void createSubsets(
      List<List<Integer>> list,
      List<Integer> tempList,
      int[] nums, int start) {

    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      createSubsets(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
