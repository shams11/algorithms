/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * https://www.youtube.com/watch?v=HdMs2Fl_I-Q&ab_channel=KevinNaughtonJr.KevinNaughtonJr.
 * */
package com.shams.trees.binarytrees;

public class SubTreeOfAnotherTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(0);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(1);
    root.right.left.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.left.right = new TreeNode(2);
    System.out.println(isSubtree(root, root.right.left));
  }

  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null || subRoot == null) {
      return false;
    } else if (isStructureSame(root, subRoot)) {
      return true;
    } else {
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
  }

  static boolean isStructureSame(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root != null && subRoot != null && root.val == subRoot.val) {
      return isStructureSame(root.left, subRoot.left)
          && isStructureSame(root.right, subRoot.right);
    }
    return false;
  }
}
