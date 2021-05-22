/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

package com.shams.trees.bst;

public class SortedArrayToBST {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
//    Input: nums = [-10,-3,0,5,9]
//    Output: [0,-3,9,-10,null,5] or [-10 -3 0 5 9 ] inorder traversal
//    Explanation: [0,-10,5,null,-3,null,9] is also accepted:
    int[] a = {-10, -3, 0, 5, 9};
    TreeNode root = sortedArrayToBST(a);
    printTree(root);
  }

  public static TreeNode sortedArrayToBST(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }
  private static void printTree(TreeNode root) {
    if (root == null) return;
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }

  static TreeNode buildTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = buildTree(nums, start, mid - 1);
    root.right = buildTree(nums, mid + 1, end);
    return root;
  }
}
