/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

package com.shams.trees.binarytrees;

public class SumRootToLeafNumbers {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);
    root.right = new TreeNode(0);
    System.out.println(sumNumbers(root));
  }

  static int res = 0;

  public static int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    calSum(root, 0);
    return res;
  }

  static void calSum(TreeNode root, int count) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      count = count * 10 + root.val;
      res += count;
      return;
    }
    count = count * 10 + root.val;
    calSum(root.left, count);
    calSum(root.right, count);
  }
}
