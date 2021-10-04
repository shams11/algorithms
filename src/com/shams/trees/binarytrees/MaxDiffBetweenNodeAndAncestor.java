/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */

package com.shams.trees.binarytrees;

public class MaxDiffBetweenNodeAndAncestor {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right = new TreeNode(10);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);
    System.out.println(maxAncestorDiff(root));
  }


  public static int maxAncestorDiff(TreeNode root) {
    return maxAncestorDiffHelper(root, root.val, root.val);
  }

  public static int maxAncestorDiffHelper(TreeNode root, int max, int min) {
    if (root == null) {
      return max - min;
    }
    // current node will be either min or max. compare it against min and max to evaluate to min/max
    min = Math.min(root.val, min);
    max = Math.max(root.val, max);
    int left = maxAncestorDiffHelper(root.left, max, min);
    int right = maxAncestorDiffHelper(root.right, max, min);
    return Math.max(left, right);
  }
}
