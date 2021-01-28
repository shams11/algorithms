/**
 * https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 * 21-Jan-2021
 * */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;
import java.util.LinkedList;
import java.util.Queue;

public class InsertionInLevelOrderAtFirstEmptyPosition {

  private static void insert(UtilityHelper.Node root, int key) {
    if (root == null) {
      new UtilityHelper.Node(key);
      return;
    }
    Queue<UtilityHelper.Node> queue = new LinkedList<UtilityHelper.Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      root = queue.peek();
      queue.remove();
      if (root.left == null) {
        root.left = new UtilityHelper.Node(key);
        break;
      } else {
        queue.add(root.left);
      }
      if (root.right == null) {
        root.right = new UtilityHelper.Node(key);
        break;
      } else {
        queue.add(root.right);
      }
    }
  }

  public static void main(String[] args) {
    UtilityHelper.Node root = new UtilityHelper.Node(10);
    root.left = new UtilityHelper.Node(11);
    root.left.left = new UtilityHelper.Node(7);
    root.right = new UtilityHelper.Node(9);
    root.right.left = new UtilityHelper.Node(15);
    root.right.right = new UtilityHelper.Node(8);

    UtilityHelper.inorder(root);
    System.out.println();
    System.out.println("------- After inserting at level order -----");
    insert(root, 12);
    UtilityHelper.inorder(root);
  }
}
