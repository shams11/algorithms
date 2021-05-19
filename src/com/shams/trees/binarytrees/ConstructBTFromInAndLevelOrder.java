/**
 * https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals-set-2/?ref=rp
 * https://www.youtube.com/watch?v=7eBndROfUnw&ab_channel=FitCoderFitCoder
 */

package com.shams.trees.binarytrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInAndLevelOrder {
  public static void main(String[] args) {
    int[] in = {4, 8, 10, 12, 14, 20, 22};
    int[] level = {20, 8, 22, 4, 12, 10, 14};
    populateMapWithLevelOrderIndex(level);
    TreeNode root = constructTree(in, 0, in.length-1);
    printTree(root);
  }

  private static void populateMapWithLevelOrderIndex(int[] level) {
    for (int i = 0; i < level.length; i++) {
      map.put(level[i], i);
    }
  }

  private static void printTree(TreeNode root) {
    if (root == null) return;
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }

  private static TreeNode constructTree(int[] in, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }

    int rootIndex = findEleWithMinIndexInLevelOrder(in, inStart, inEnd);
    TreeNode root = new TreeNode(in[rootIndex]);
    if (inStart == inEnd) {
      return root;
    }

    root.left = constructTree(in, inStart, rootIndex - 1);
    root.right = constructTree(in, rootIndex + 1, inEnd);
    return root;
  }

  static Map<Integer, Integer> map = new HashMap<>();



  private static int findEleWithMinIndexInLevelOrder(int[] in, int inStart, int inEnd) {
    int minIndex = inStart;
    for (int i = inStart + 1 ; i <= inEnd; i++) {
      if(map.get(in[i]) < map.get(in[minIndex])) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
