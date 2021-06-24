/***
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes
 * */

package com.shams.trees.binarytrees;
/***
 * SubTree with all deepest nodes is same as LCA of deepest nodes (both are same questions)
 * */
public class LCAOfDeepestLeaves {
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

    //Input: root = [3,5,1,6,2,0,8,null,null,7,4]
    //Output: [2,7,4]
    //Explanation: We return the node with value 2, colored in yellow in the diagram.
    //The nodes coloured in blue are the deepest nodes of the tree.
    //Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the
    // smallest subtree among them, so we return it.
    System.out.println(lcaDeepestLeaves(root).val);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static class Pair {
    TreeNode node;
    int deapth;

    Pair(TreeNode node, int d) {
      this.node = node;
      this.deapth = d;
    }
  }

  public static TreeNode lcaDeepestLeaves(TreeNode root) {
    Pair p = lca(root, 0);
    return p.node;
  }

  static Pair lca(TreeNode root, int deapth) {
    if (root == null) {
      return new Pair(null, deapth);
    }

    Pair left = lca(root.left, deapth + 1);
    Pair right = lca(root.right, deapth + 1);
    if (left.deapth == right.deapth) {
      return new Pair(root, left.deapth);
    } else {
      return left.deapth > right.deapth ? left : right;
    }
  }
}
