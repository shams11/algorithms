/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/submissions/
 */

package com.shams.trees.binarytrees;

public class FlipEquivalentBinaryTree {
  public static void main(String[] args) {

    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(3);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(5);
    root1.left.right.left = new TreeNode(7);
    root1.left.right.right = new TreeNode(8);
    root1.right.left = new TreeNode(6);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(2);
    root2.left.right = new TreeNode(6);
    root2.right.left = new TreeNode(4);
    root2.right.right = new TreeNode(5);
    root2.right.right.left = new TreeNode(8);
    root2.right.right.right = new TreeNode(7);

    System.out.println(flipEquiv(root1, root2));
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;

    return isStructureSame(root1, root2);
  }

  static void flipNodes(TreeNode node) {
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
  }

  static boolean isStructureSame(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;

    if (root1.val == root2.val) {
      if (root1.left == null && root2.left != null) {
        flipNodes(root2);
      } else if (root1.right == null && root2.right != null) {
        flipNodes(root2);
      } else if (root1.left != null && root2.left != null && root1.left.val != root2.left.val) {
        flipNodes(root2);
      }
    }
    return isStructureSame(root1.left, root2.left) && isStructureSame(root1.right, root2.right);
  }
}
