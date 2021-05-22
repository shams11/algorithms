/***
 * https://leetcode.com/problems/deepest-leaves-sum/
 * */

package com.shams.trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    /**
     *              6
     * 			 7		    	     8
     * 		2     7  	    	1     3
     * 	9     1       4            5
     *
     * */
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(7);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(3);
    root.left.left.left = new TreeNode(9);
    root.left.right.left = new TreeNode(1);
    root.right.left.left = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    System.out.println(deepestLeavesSum(root));
    System.out.println(deepestLeavesSumLevelOrder(root));
  }

  public static int deepestLeavesSumLevelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int result = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      result = 0;
      for (int i = 0; i < size; i++) {
        root = q.poll();
        result += root.val;
        if (root.left != null) {
          q.offer(root.left);
        }
        if (root.right != null) {
          q.offer(root.right);
        }
      }
    }
    return result;
  }

  static int sum = 0;

  public static int deepestLeavesSum(TreeNode root) {
    if (root == null) return 0;
    int maxHeight = getHeight(root);

    getDeepestLeavesSum(root, maxHeight, 1);
    return sum;
  }

  static int getHeight(TreeNode root) {
    if (root == null) return 0;

    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return 1 + Math.max(left, right);
  }

  static void getDeepestLeavesSum(TreeNode root, int maxHeight, int curHeight) {

    if (root == null) return;

    if (root.left == null && root.right == null && maxHeight == curHeight) {
      sum += root.val;
    }

    getDeepestLeavesSum(root.left, maxHeight, curHeight + 1);
    getDeepestLeavesSum(root.right, maxHeight, curHeight + 1);
  }
}
