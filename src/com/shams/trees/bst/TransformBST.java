/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * https://www.geeksforgeeks.org/transform-bst-sum-tree/
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * */
package com.shams.trees.bst;

public class TransformBST {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(3);
    root.right.right = new TreeNode(8);
    transformBST(root);
    printTree(root);
    // Output BST : 24 20 15 8 0
  }

  private static void printTree(TreeNode root) {
    if (root == null) return;
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }

  static int sum = 0;
  private static void transformBST(TreeNode root) {
    if(root == null) return;
    transformBST(root.right);
    sum += root.val;
    root.val = sum - root.val;
    transformBST(root.left);
  }
}
