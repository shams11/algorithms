/**
 * https://leetcode.com/problems/path-sum-ii/
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.right = new TreeNode(2);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);
    root.right.right.left = new TreeNode(5);
    int targetSum = 22;
    System.out.println(pathSum(root, targetSum));
  }

  static List<List<Integer>> result = new ArrayList<>();
  static List<Integer> list = new ArrayList<>();

  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    hasPath(root, list, targetSum);
    return result;
  }

  private static void hasPath(TreeNode root, List<Integer> list, int targetSum) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    if (root.val == targetSum && root.left == null && root.right == null) {
      result.add(list);
      return;
    }
    hasPath(root.left, new ArrayList<>(list), targetSum - root.val);
    hasPath(root.right, new ArrayList<>(list), targetSum - root.val);
  }
}
