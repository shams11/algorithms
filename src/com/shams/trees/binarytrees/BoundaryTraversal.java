/**
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * https://www.youtube.com/watch?v=4YQY0MgGOBM&list=PLOAph0xkZvSsHbTgufVQ4O8lx6-_OQk2U&index=146&ab_channel=WorkWithGoogler
 */

package com.shams.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(10);
    System.out.println(boundaryTraversal(root));
  }

  private static List<Integer> boundaryTraversal(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    List<Integer> result = new ArrayList<>();
    result.add(root.val);
    getLeftBoundary(root.left, result);
    getLeaves(root, result);
    getRightBoundary(root.right, result);
    return result;
  }

  private static void getLeftBoundary(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      result.add(root.val);
      getLeftBoundary(root.left, result);
    } else if (root.right != null) {
      result.add(root.val);
      getLeftBoundary(root.right, result);
    }
    // don't so anything for leaf nodes
  }

  private static void getLeaves(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    getLeaves(root.left, result);
    if (root.left == null && root.right == null) {
      result.add(root.val);
    }
    getLeaves(root.right, result);
  }

  private static void getRightBoundary(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    if (root.right != null) {
      getRightBoundary(root.right, result);
      result.add(root.val);
    } else if (root.left != null) {
      getRightBoundary(root.left, result);
      result.add(root.val);
    }
    // don't so anything for leaf nodes
  }
}
