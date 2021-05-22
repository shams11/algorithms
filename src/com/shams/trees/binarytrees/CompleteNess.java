/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * */
package com.shams.trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteNess {

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
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    System.out.println(isCompleteTree(root));
  }

  static Queue<TreeNode> q = new LinkedList<>();

  public static boolean isCompleteTree(TreeNode root) {
    q.offer(root);
    while(!q.isEmpty() && q.peek() != null) {
      TreeNode node = q.poll();
      q.offer(node.left);
      q.offer(node.right);
    }
    while(!q.isEmpty() && q.peek() == null) {
      q.poll();
    }
    return q.isEmpty();
  }
}
