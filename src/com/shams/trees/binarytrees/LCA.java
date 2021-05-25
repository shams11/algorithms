/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * */
package com.shams.trees.binarytrees;

public class LCA {

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
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);

    TreeNode p = root.right.left;
    TreeNode q = root.right.right;
    System.out.println(lca(root, p, q).val);
    System.out.println(lowestCommonAncestor(root, p, q).val);
  }

  private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    return left == null ? right : right == null ? left : root;
  }


  // My Approach
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    String s1 = getPath(root, p);
    String s2 = getPath(root, q);
    System.out.println(s1);
    System.out.println(s2);
    int i = 0, j = 0;
    while(i < s1.length() && j < s2.length()) {
      if(s1.charAt(i) == s2.charAt(j)) {
        if(s1.charAt(i) == 'L') {
          root = root.left;
        } else {
          root = root.right;
        }
      } else {
        break;
      }
      i++;
      j++;
    }
    return root;
  }

  static String getPath(TreeNode root, TreeNode node) {
    if(root == null) {
      return null;
    }
    if(root.val == node.val) {
      return "";
    }
    String left = getPath(root.left, node);
    String right = getPath(root.right, node);
    if(left != null) {
      return "L" + left;
    }
    if(right != null) {
      return "R" + right;
    }
    return null;
  }
}
