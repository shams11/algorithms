/**
 * https://leetcode.com/problems/path-sum/
 * */
package com.shams.trees.binarytrees;

public class PathSum {

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
    int targetSum = 22;
    System.out.println(hasPathSum(root, targetSum));
  }

  public static boolean hasPathSum(TreeNode root, int targetSum) {
    return hasPathSumHelper(root, 0, targetSum);
  }

  static boolean hasPathSumHelper(TreeNode root, int curSum, int targetSum) {
    if (root == null) {
      return false;
    }
    curSum += root.val;
    if (isLeaf(root)) {
      return (curSum == targetSum) ? true : false;
    }
    return hasPathSumHelper(root.left, curSum, targetSum)
        || hasPathSumHelper(root.right, curSum, targetSum);
  }

  static boolean isLeaf(TreeNode root) {
    return (root.left == null && root.right == null);
  }
}
