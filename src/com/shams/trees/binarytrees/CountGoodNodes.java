/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */

package com.shams.trees.binarytrees;

public class CountGoodNodes {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(3);

    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);

    System.out.println(goodNodes(root));
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static int count = 0;

  public static int goodNodes(TreeNode root) {
    countGoodNodes(root, root.val);
    return count;
  }

  static void countGoodNodes(TreeNode root, int rootValue) {
    if (root == null) return;

    if (root.val >= rootValue) count++;
    countGoodNodes(root.left, Math.max(root.val, rootValue));
    countGoodNodes(root.right, Math.max(root.val, rootValue));
  }
}
