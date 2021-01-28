/**
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */

package com.shams.trees.binarytrees;

import com.shams.commons.UtilityHelper;

public class PrintKDistanceNodesFromGivenNode {

  static void printKDistanceNodeDown(UtilityHelper.Node node, int k) {
    // Base Case
    if (node == null || k < 0)
      return;

    // If we reach a k distant node, print it
    if (k == 0) {
      System.out.print(node.val);
      System.out.println("");
      return;
    }

    // Recur for left and right subtrees
    printKDistanceNodeDown(node.left, k - 1);
    printKDistanceNodeDown(node.right, k - 1);
  }

  // Prints all nodes at distance k from a given target node.
  // The k distant nodes may be upward or downward.This function
  // Returns distance of root from target node, it returns -1
  // if target node is not present in tree rooted with root.
  static int printKDistanceNode(UtilityHelper.Node node, UtilityHelper.Node target, int k) {
    // Base Case 1: If tree is empty, return -1
    if (node == null)
      return -1;

    // If target is same as root. Use the downward function
    // to print all nodes at distance k in subtree rooted with
    // target or root
    if (node == target) {
      printKDistanceNodeDown(node, k);
      return 0;
    }

    // Recur for left subtree
    int dl = printKDistanceNode(node.left, target, k);

    // Check if target node was found in left subtree
    if (dl != -1) {

      // If root is at distance k from target, print root
      // Note that dl is Distance of root's left child from
      // target
      if (dl + 1 == k) {
        System.out.print(node.val);
        System.out.println("");
      }

      // Else go to right subtree and print all k-dl-2 distant nodes
      // Note that the right child is 2 edges away from left child
      else
        printKDistanceNodeDown(node.right, k - dl - 2);

      // Add 1 to the distance and return value for parent calls
      return 1 + dl;
    }

    // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
    // Note that we reach here only when node was not found in left
    // subtree
    int dr = printKDistanceNode(node.right, target, k);
    if (dr != -1) {
      if (dr + 1 == k) {
        System.out.print(node.val);
        System.out.println("");
      } else
        printKDistanceNodeDown(node.left, k - dr - 2);
      return 1 + dr;
    }

    // If target was neither present in left nor in right subtree
    return -1;
  }

  // Driver program to test the above functions
  public static void main(String args[]) {
    UtilityHelper.Node root = new UtilityHelper.Node(20);
    /* Let us construct the tree shown in above diagram */
    root.left = new UtilityHelper.Node(8);
    root.right = new UtilityHelper.Node(22);
    root.left.left = new UtilityHelper.Node(4);
    root.left.right = new UtilityHelper.Node(12);
    root.left.right.left = new UtilityHelper.Node(10);
    root.left.right.right = new UtilityHelper.Node(14);
    UtilityHelper.Node target = root.left.right.right;
    printKDistanceNode1(root, target, 3);
  }

  private static int printKDistanceNode1(
      UtilityHelper.Node root,
      UtilityHelper.Node target,
      int k) {

    if (root == null || target == null || k < 0) {
      System.out.println();
      return -1;
    }

    if (root == target) {
      printKDistanceNodeDown1(root, k);
      return 0;
    }
    int dl = printKDistanceNode1(root.left, target, k);
    if (dl != -1) {
      if (dl + 1 == k) {
        System.out.println(root.val);
      } else {
        printKDistanceNodeDown1(root.right, k - dl - 2);
      }
      return dl + 1;
    }
    int dr = printKDistanceNode1(root.right, target, k);
    if (dr != -1) {
      if (dr + 1 == k) {
        System.out.println(root.val);
      } else {
        printKDistanceNodeDown1(root.left, k - dr - 2);
      }
      return dr + 1;
    }
    return -1;
  }

  private static void printKDistanceNodeDown1(UtilityHelper.Node root, int k) {
    if (root == null)
      return;
    if (k == 0) {
      System.out.println(root.val);
      return;
    }
    printKDistanceNodeDown1(root.left, k - 1);
    printKDistanceNodeDown1(root.right, k - 1);
  }
}
