/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
 * https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 * */
package com.shams.trees.binarytrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInAndPostOrder {
  public static void main(String[] args) {
    // Input:
    int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
    int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
    //
    //Output: Root of below tree
    //          1
    //       /     \
    //     2        3
    //   /    \   /   \
    //  4     5   6    7
    //    \
    //      8
    TreeNode root = buildTree(in, post);
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

  static Map<Integer, Integer> map = new HashMap<>();
  static int poEndIndex;

  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    poEndIndex = postorder.length - 1;
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildTreeUtil(inorder, postorder, 0, inorder.length - 1);
  }

  static TreeNode buildTreeUtil(int[] in, int[] po, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(po[poEndIndex--]);
    if (inStart == inEnd) {
      return root;
    }
    int rootIndex = map.get(root.val);
    root.right = buildTreeUtil(in, po, rootIndex + 1, inEnd);
    root.left = buildTreeUtil(in, po, inStart, rootIndex - 1);
    return root;
  }
}
