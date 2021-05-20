/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */

package com.shams.trees.bst;

public class RecoverBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(4);
    recoverTree(root);
    printTree(root);
  }

  private static void printTree(TreeNode root) {
    if (root == null) return;
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  // Threre are 2 ndoes where the BST property is failing. figure out those 2 nodes
  static TreeNode prev = null;
  static TreeNode firstElement = null;
  static TreeNode secondElement = null;

  public static void recoverTree(TreeNode root) {
    inorder(root);
    // swap firstElement and secondElement
    int temp = firstElement.val;
    firstElement.val = secondElement.val;
    secondElement.val = temp;
  }

  private static void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (firstElement == null && (prev == null || prev.val >= root.val)) {
      firstElement = prev;
    }
    if (firstElement != null && prev.val >= root.val) {
      secondElement = root;
    }
    prev = root;
    inorder(root.right);
  }
}
