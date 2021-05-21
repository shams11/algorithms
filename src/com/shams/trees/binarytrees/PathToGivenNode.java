package com.shams.trees.binarytrees;

public class PathToGivenNode {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    /**
     *              6
     * 			  7			 		        8
     *
     * 		2     12  				13     3
     *
     * 	9     1        4  	            5
     * */
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(7);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(12);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(3);
    root.left.left.left = new TreeNode(9);
    root.left.right.left = new TreeNode(1);
    root.right.left.left = new TreeNode(4);
    root.right.right.right = new TreeNode(5);

    System.out.println(getPath(root, root.right.left.left));
  }


  static String getPath(TreeNode root, TreeNode node) {
    if (root == null || node == null) return null;
    if (root.val == node.val) return "";
    String left = getPath(root.left, node);
    String right = getPath(root.right, node);

    if (left != null) {
      return "L" + left;
    }
    if (right != null) {
      return "R" + right;
    }
    return null;
  }
}
