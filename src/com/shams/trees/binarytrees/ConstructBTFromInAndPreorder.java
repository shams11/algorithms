package com.shams.trees.binarytrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInAndPreorder {
  public static void main(String[] args) {
//    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//    Output: [3,9,20,null,null,15,7]

    int[] pre = {3, 9, 20, 15, 7};
    int[] in = {9, 3, 15, 20, 7};
    TreeNode root = buildTree(pre, in);
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
  static int preIndex = 0;

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    populateMapWithInorderEleAndTheirIndex(inorder);
    return buildTree(preorder, inorder, 0, inorder.length - 1);
  }

  private static void populateMapWithInorderEleAndTheirIndex(int[] in) {
    for (int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
  }

  private static TreeNode buildTree(int[] pre, int[] in, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(pre[preIndex++]);
    if (inStart == inEnd) {
      return root;
    }

    int rootIndex = map.get(root.val);
    root.left = buildTree(pre, in, inStart, rootIndex - 1);
    root.right = buildTree(pre, in, rootIndex + 1, inEnd);
    return root;
  }
}
